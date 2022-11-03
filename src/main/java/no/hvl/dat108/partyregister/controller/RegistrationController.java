package no.hvl.dat108.partyregister.controller;

import no.hvl.dat108.partyregister.util.Database;
import no.hvl.dat108.partyregister.util.InputValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Value("/${app.url.registration}") private String REGISTER_URL;
    @Value("/${app.url.attendeeList}") private String LIST_URL;
    @Value("${app.message.unequalPassword}") private String UNEQUAL_PASSWORD_MESSAGE;
    @Value("${app.message.phoneAlreadyUsed}") private String PHONE_ALREADY_USED_MESSAGE;
    @Value("${app.message.invalidRegistration}") private String INVALID_REGISTRATION_MESSAGE;

    @GetMapping
    public String getRegisterView(){ return "registrationView"; }

    @PostMapping
    public String registerAttendee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("phone") String phone,
                                   @RequestParam("pword") String pword,
                                   @RequestParam("pwordRep") String pwordRep,
                                   @RequestParam("gender") String gender,
                                   RedirectAttributes ra
                                   ) {
        // Valider brukeren sin info, send infoen videre til Database for å lage attendee-objekt.
        // Sjekk at passordene vi får inn stemmer.

        if(!pword.equals(pwordRep)){
            System.out.println("Passwords not equal");
            ra.addFlashAttribute("redirectMessage", UNEQUAL_PASSWORD_MESSAGE);
            return "redirect:" + "registration";
        }
        int phoneInt = Integer.parseInt(phone);
        // Sjekk om telefonnummeret allerede eksisterer i databasen
        /*if(Database.doesPhoneExist(phoneInt)){
            ra.addFlashAttribute("redirectMessage", PHONE_ALREADY_USED_MESSAGE);
            return "redirect: " + REGISTER_URL;
        }*/
        if(!InputValidator.isValidFirstName(firstName) || !InputValidator.isValidLastName(lastName) ||
        !InputValidator.isValidPhone(phoneInt) || !InputValidator.isValidPassword(pword) || !InputValidator.isValidGender(gender)){
            ra.addFlashAttribute("redirectMessage", INVALID_REGISTRATION_MESSAGE);
            return "redirect:" + "registration";
        }
        //Database.createAttendee(firstName, lastName, phoneInt, pword, gender);
        System.out.println("redirect" + REGISTER_URL);
        return "redirect:" + REGISTER_URL;
    }

}