package org.softserveinc.java_be_genai_plgrnd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.Hidden;

/**
 * Home controller redirecting to the main Swagger API documentation page.
 */
@Controller
@Hidden
class HomeController {

    /**
     * Redirects root path to swagger
     */
    @GetMapping("/")
    public String root() {
        return "redirect:/swagger-ui.html";
    }

    /**
     * Redirects /swagger path to swagger
     */
    @GetMapping("/swagger")
    public String swagger() {
        return "redirect:/swagger-ui.html";
    }
}
