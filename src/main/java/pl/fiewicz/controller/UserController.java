package pl.fiewicz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.fiewicz.model.User;
import pl.fiewicz.repository.UserRepository;
import pl.fiewicz.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {


    private UserService userService;

    private UserRepository userRepository;
    @Autowired
    private HttpSession httpSession;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public String userAccount(Model model, Principal principal) {
        Optional<User> user = userRepository.findByLogin(principal.getName());
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            model.addAttribute("army", user.get().getArmy());
            model.addAttribute("resources", user.get().getResources());
        }

        return "user";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }


    @PostMapping("/register")
    public String registerUser(@ModelAttribute @Valid User user, BindingResult bindingResult) {

        Optional<User> userFound = userRepository.findByLogin(user.getLogin());

        if (userFound.isPresent()) {
            httpSession.setAttribute("userExists", "Użytkownik o podanym loginie istnieje już bazie!");
            System.out.println("Uzytkownik juz isteniej!");
            return "registerForm";
        } else {

            if (bindingResult.hasErrors()) {
                return "registerForm";
            } else {
                userService.userRegistrationWithDefaultRole(user);
                return "registerSucces";
            }
        }
    }
}
