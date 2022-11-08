package no.hvl.dat108.partyregister.controller;

import no.hvl.dat108.partyregister.model.Attendee;
import no.hvl.dat108.partyregister.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Value("/${app.url.registration}") private String REGISTER_URL;
    @Value("/${app.url.attendeeList}") private String LIST_URL;
    @Value("/${app.url.registrationConfirmation}") private String CONFIRMATION_URL;
    @Value("${app.message.unequalPassword}") private String UNEQUAL_PASSWORD_MESSAGE;
    @Value("${app.message.phoneAlreadyUsed}") private String PHONE_ALREADY_USED_MESSAGE;
    @Value("${app.message.invalidRegistration}") private String INVALID_REGISTRATION_MESSAGE;

    @Autowired AttendeeService attendeeService;

    @GetMapping
    public String getRegisterView(){ return "registrationView"; }

    @PostMapping
    public String registerAttendee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("phone") String phone,
                                   @RequestParam("pword") String pword,
                                   @RequestParam("pwordRep") String pwordRep,
                                   @RequestParam("gender") String gender,
                                   HttpServletRequest request,
                                   RedirectAttributes ra
                                   ) {

        // Valider brukeren sin info, send infoen videre til Database for å lage attendee-objekt.
        // Sjekk at passordene vi får inn er like.
        if(!pword.equals(pwordRep)){
            System.out.println("Passwords not equal");
            ra.addFlashAttribute("redirectMessage", UNEQUAL_PASSWORD_MESSAGE);
            return "redirect:" + REGISTER_URL;
        }
        // Sjekk om telefonnummeret allerede eksisterer i databasen
        if(attendeeService.findAttendeeWithPhone(phone) != null){
            ra.addFlashAttribute("redirectMessage", PHONE_ALREADY_USED_MESSAGE);
            return "redirect:" + REGISTER_URL;
        }
        //Sjekk om all dataen oppfyller kravene
        if(!InputValidator.isValidFirstName(firstName) || !InputValidator.isValidLastName(lastName) ||
        !InputValidator.isValidPhone(phone) || !InputValidator.isValidPassword(pword) || !InputValidator.isValidGender(gender)){
            ra.addFlashAttribute("redirectMessage", INVALID_REGISTRATION_MESSAGE);
            return "redirect:" + REGISTER_URL;
        }

        //Hash og salt brukerens passord før det lagres i databasen
        byte[] salt = RegistrationUtil.getSalt();
        String hash = RegistrationUtil.hashPassword(pword, salt);

        Attendee attendee = new Attendee(firstName, lastName, phone, hash, salt, gender);
        attendeeService.createAttendee(attendee);
        //TODO - bruker blir ikke ordentlig innlogget
        LoginUtil.loginUser(request, attendee);
        return "redirect:" + CONFIRMATION_URL;
    }

}