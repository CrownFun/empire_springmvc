package pl.fiewicz.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/regulations")
    public String regulations(){
        return "regulations";
    }

    @GetMapping("/about")
    public String infoAboutPage(){
        return "about";
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }

}
