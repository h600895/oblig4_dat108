package no.hvl.dat108.webshop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/${app.url.paamelding}")
public class RegistrationController {

    @Value("/${app.url.paamelding}") private String REGISTER_URL;
    @Value("/${app.url.deltagerliste}") private String LIST_URL;

    @GetMapping
    public String getRegisterView(){ return "registerView"; }

    @PostMapping
    public String registerUser() {
        return "redirect:" + LIST_URL;
    }

}