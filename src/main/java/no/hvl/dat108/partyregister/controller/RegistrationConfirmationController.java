package no.hvl.dat108.partyregister.controller;

import no.hvl.dat108.partyregister.util.LoginUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/registrationConfirmation")
public class RegistrationConfirmationController {

    @Value("/${app.url.attendeeList}")   private String ATTENDEELIST_URL;
    @Value("/${app.url.login}")   private String LOGIN_URL;
    @Value("/${app.message.requiresLogin}")   private String REQUIRES_LOGIN_MESSAGE;


    @GetMapping
    public String getRegistrationConfirmationView() {

        return "registrationConfirmationView";}
    @PostMapping
    public String getAttendeListView(HttpServletRequest request, RedirectAttributes ra) {
        if (!LoginUtil.isUserLoggedIn(request.getSession())) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }
        //return "loginView";
        return "redirect:" + ATTENDEELIST_URL;
    }
}
