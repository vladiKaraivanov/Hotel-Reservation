package bg.softuni.hotelreservation.web;

import bg.softuni.hotelreservation.hotel.model.Hotel;
import bg.softuni.hotelreservation.hotel.repository.HotelRepository;
import bg.softuni.hotelreservation.image.model.Image;
import bg.softuni.hotelreservation.image.repository.ImageRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller  // Важно: @Controller вместо @RestController
@RequestMapping("/admin/hotels")
public class ImageController {
    private final Cloudinary cloudinary;
    private final HotelRepository hotelRepository;
    private final ImageRepository imageRepository;

    public ImageController(Cloudinary cloudinary, HotelRepository hotelRepository, ImageRepository imageRepository) {
        this.cloudinary = cloudinary;
        this.hotelRepository = hotelRepository;
        this.imageRepository = imageRepository;
    }

    // GET метод за показване на формата
    @GetMapping("/{hotelId}/upload-image")
    public String uploadImage(@PathVariable UUID hotelId, Model model) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        model.addAttribute("hotel", hotel);
        return "admin/upload-images";
    }

    // POST метод за качване на изображение
    @PostMapping("/{hotelId}/upload-image")
    public String uploadImage(@PathVariable UUID hotelId, @RequestParam("image") MultipartFile file) {
        try {
            Hotel hotel = hotelRepository.findById(hotelId)
                    .orElseThrow(() -> new RuntimeException("Hotel not found"));

            // 1️⃣ Качване на изображението в Cloudinary
            Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String imageUrl = (String) uploadResult.get("url");

            if (imageUrl == null || imageUrl.isEmpty()) {
                throw new RuntimeException("Image URL is null or empty - Cloudinary upload failed!");
            }

            // 2️⃣ Запазване на изображението в базата
            Image image = new Image();
            image.setImageUrl(imageUrl);
            image.setHotel(hotel);
            imageRepository.save(image);

            // 3️⃣ Пренасочване към хотела след успешно качване
            return "redirect:/admin/hotels/" + hotelId + "/upload-image";
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/admin/hotels?error=upload_failed";
        }
    }

}
