package bg.softuni.hotelreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableFeignClients
public class HotelReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelReservationApplication.class, args);
    }

}
