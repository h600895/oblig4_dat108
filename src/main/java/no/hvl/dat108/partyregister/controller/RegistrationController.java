package no.hvl.dat108.partyregister.controller;

import no.hvl.dat108.partyregister.model.Attendee;
import no.hvl.dat108.partyregister.util.Database;
import no.hvl.dat108.partyregister.util.InputValidator;
import no.hvl.dat108.partyregister.util.LoginUtil;
import no.hvl.dat108.partyregister.util.RegistrationUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Value("/${app.url.registration}") private String REGISTER_URL;
    @Value("/${app.url.attendeeList}") private String LIST_URL;
    @Value("/${app.url.registrationConfirmation}") private String CONFIRMATION_URL;
    @Value("${app.message.unequalPassword}") private String UNEQUAL_PASSWORD_MESSAGE;
    @Value("${app.message.phoneAlreadyUsed}") private String PHONE_ALREADY_USED_MESSAGE;
    @Value("${app.message.invalidRegistration}") private String INVALID_REGISTRATION_MESSAGE;

    Database database = new Database();

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
            return "redirect:" + REGISTER_URL;
        }
        if(!InputValidator.isValidFirstName(firstName) || !InputValidator.isValidLastName(lastName) ||
        !InputValidator.isValidPhone(phoneInt) || !InputValidator.isValidPassword(pword) || !InputValidator.isValidGender(gender)){
            ra.addFlashAttribute("redirectMessage", INVALID_REGISTRATION_MESSAGE);
            return "redirect:" + "registration";
        }*/

        //Hash and salt password for storage in database
        byte[] salt = RegistrationUtil.getSalt();
        String hash = RegistrationUtil.hashPassword(pword, salt);
        System.out.println(salt.toString());
        System.out.println(hash);
        Attendee attendee = database.createAttendee(firstName, lastName, phoneInt, hash, salt, gender);
        LoginUtil.loginUser(request, attendee);
        return "redirect:" + CONFIRMATION_URL;
    }

}