package bg.softuni.hotelreservation.user.service;

import bg.softuni.hotelreservation.security.AuthenticationDetails;
import bg.softuni.hotelreservation.user.model.User;
import bg.softuni.hotelreservation.user.model.UserRegisterDto;
import bg.softuni.hotelreservation.user.model.UserRoleEnum;
import bg.softuni.hotelreservation.user.repository.UserRepository;
import bg.softuni.hotelreservation.web.dto.UserAdditionalInformationBindingModel;
import bg.softuni.hotelreservation.web.dto.UserBindingModel;
import bg.softuni.hotelreservation.web.dto.UserRegisterBindingModel;
import bg.softuni.hotelreservation.web.dto.UserViewModel;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
private final UserRepository userRepository;
private final ModelMapper modelMapper;
private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=  userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User with this username not found"));

        return new AuthenticationDetails(user.getId(), user.getUsername(), user.getPassword(),
        user.getRole(), user.getActive());
    }
    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) { // Ако няма потребители
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(UserRoleEnum.ADMIN); // Твоята енумерация ADMIN/USER
            admin.setActive(true);
            userRepository.save(admin);
            System.out.println("Администраторски акаунт създаден: admin@example.com / admin123");
        }
    }

    public UserRegisterDto registerUser(UserRegisterBindingModel userRegisterBindingModel) {
        if(userRepository.findByUsername(userRegisterBindingModel.getUsername()).isPresent() ||
        userRepository.findByEmail(userRegisterBindingModel.getEmail()).isPresent()){
            return null;
        }
        User user = modelMapper.map(userRegisterBindingModel, User.class);
        user.setActive(true);
        user.setRole(UserRoleEnum.USER);
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        return modelMapper.map(userRepository.save(user), UserRegisterDto.class);

    }

    public void addProfileInformation(UserAdditionalInformationBindingModel userAdditionalInformationBindingModel, String username) {

          User user = userRepository.findByUsername(username).orElseThrow(() ->
                  new UsernameNotFoundException("User with this username not found"));

          if(user != null){
              List<String> interests = userAdditionalInformationBindingModel.getInterests();

              user.setInterests(interests);
              user.setBirthday(userAdditionalInformationBindingModel.getBirthdate());
              user.setFirstName(userAdditionalInformationBindingModel.getFirstName());
              user.setLastName(userAdditionalInformationBindingModel.getLastName());

              userRepository.save(user);
          }

    }

    public List<UserViewModel> getAllUsers() {
     return userRepository.findAll().stream()
             .map(user -> modelMapper.map(user, UserViewModel.class))
             .collect(Collectors.toList());
    }

    public UserViewModel findUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User with this username not found"));
        return modelMapper.map(user, UserViewModel.class);
    }

    public void  manageUser( UserBindingModel userBindingModel) {
        User user = userRepository.findByUsername(userBindingModel.getUsername()).orElse(null);
        if(user != null){
            user.setUsername(userBindingModel.getUsername());
            user.setFirstName(userBindingModel.getFirstName());
            user.setFirstName(userBindingModel.getFirstName());
            user.setLastName(userBindingModel.getLastName());
            user.setBirthday(userBindingModel.getBirthday());
            user.setEmail(userBindingModel.getEmail());
            user.setRole(userBindingModel.getRole());
            user.setActive(userBindingModel.getActive());
            userRepository.save(user);
        }
    }

    public UserBindingModel convertToBindingModel(UserViewModel userViewModel) {
            UserBindingModel bindingModel = new UserBindingModel();
            bindingModel.setId(userViewModel.getId());
            bindingModel.setUsername(userViewModel.getUsername());
            bindingModel.setFirstName(userViewModel.getFirstName());
            bindingModel.setLastName(userViewModel.getLastName());
            bindingModel.setBirthday(userViewModel.getBirthday());
            bindingModel.setEmail(userViewModel.getEmail());
            bindingModel.setRole(userViewModel.getRole());
            bindingModel.setActive(userViewModel.isActive());
            return bindingModel;
        }
}
