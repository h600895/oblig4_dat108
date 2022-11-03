package no.hvl.dat108.partyregister.controller;

import no.hvl.dat108.partyregister.util.LoginUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/${app.url.attendeeList}")
public class AttendeeController {

    @Value("/${app.url.login}")   private String LOGIN_URL;
    @Value("/${app.message.requiresLogin}")   private String REQUIRES_LOGIN_MESSAGE;


    @GetMapping
    public String showAttendees(HttpSession session, RedirectAttributes ra) {

        if (!LoginUtil.isUserLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }





        return "attendeeView";
    }
	
	
}
