package com.baal.WebShop.controller.tymyleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/admin")
    public String getHome() {
        return "admin/index";
    }
}
