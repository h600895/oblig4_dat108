package no.hvl.dat108.partyregister.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/registrationConfirmation")
public class RegistrationConfirmationController {
    @Value("/${app.url.attendeeList}")   private String ATTENDEELIST_URL;


    @GetMapping
    public String getRegistrationConfirmationView() {

        return "registrationConfirmationView";}
}
