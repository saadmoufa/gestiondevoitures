package org.xproc.locages.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Home"; // Assuming "index" is the name of your home page HTML template
    }
}
