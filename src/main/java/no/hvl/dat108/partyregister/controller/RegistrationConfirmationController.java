package no.hvl.dat108.partyregister.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/${app.url.registrationConfirmation}")
public class RegistrationConfirmationController {

    @GetMapping
    public String getRegistrationConfirmationView(HttpSession session) {

        return "registrationConfirmationView";}
}
