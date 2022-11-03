package no.hvl.dat108.webshop.controller;

import no.hvl.dat108.webshop.util.Database;
import no.hvl.dat108.webshop.util.InputValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/${app.url.paamelding}")
public class RegistrationController {

    @Value("/${app.url.registration}") private String REGISTER_URL;
    @Value("/${app.url.attendeeList}") private String LIST_URL;
    @Value("/${app.message.unequalPassword}") private String UNEQUAL_PASSWORD_MESSAGE;
    @Value("/${app.message.phoneAlreadyUsed}") private String PHONE_ALREADY_USED_MESSAGE;
    @Value("/${app.message.invalidRegistration}") private String INVALID_REGISTRATION_MESSAGE;

    @GetMapping
    public String getRegisterView(){ return "registrationView"; }

    @PostMapping(value="/registration")
    public String registerAttendee(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam int phone,
                                   @RequestParam String pword,
                                   @RequestParam String pwordRep,
                                   @RequestParam String gender,
                                   RedirectAttributes ra) {
        // Valider brukeren sin info, send infoen videre til Database for å lage attendee-objekt.
        // Sjekk at passordene vi får inn stemmer.
        if(!pword.equals(pwordRep)){
            ra.addFlashAttribute("redirectMessage", UNEQUAL_PASSWORD_MESSAGE);
            return "redirect: " + REGISTER_URL;
        }
        // Sjekk om telefonnummeret allerede eksisterer i databasen
        if(Database.doesPhoneExist(phone)){
            ra.addFlashAttribute("redirectMessage", PHONE_ALREADY_USED_MESSAGE);
            return "redirect: " + REGISTER_URL;
        }
        if(!InputValidator.isValidFirstName(firstName) || !InputValidator.isValidLastName(lastName) ||
        !InputValidator.isValidPhone(phone) || !InputValidator.isValidPassword(pword) || !InputValidator.isValidGender(gender)){
            ra.addFlashAttribute("redirectMessage", INVALID_REGISTRATION_MESSAGE);
            return "redirect: " + REGISTER_URL;
        }
        Database.createAttendee(firstName, lastName, phone, gender);
        return "redirect:" + LIST_URL;
    }

}