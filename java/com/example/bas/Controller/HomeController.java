package com.example.bas.Controller;

import com.example.bas.Service.User.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Vi annotere klassen som Controller.
 * Autowirer pga. dependency injection.
 * Mapper HTTP requests til metoder.
 */
@Controller
public class HomeController {

    @Autowired
    Contact contactService;


    @GetMapping("/")
    public String bas() {
        return "bas";
}

    @GetMapping("userFrontPage")
    public String userFrontPage(Model model){
        model.addAttribute("contact", contactService.getContact());
        return "userFrontPage";
    }

    @GetMapping("adminFrontPage")
    public String adminFrontPage(Model model){
        model.addAttribute("contact", contactService.getContact());
        return "adminFrontPage";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("404")
    public String Error403(){
        return "404";
    }


}
