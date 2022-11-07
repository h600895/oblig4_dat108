package no.hvl.dat108.partyregister.controller;

import no.hvl.dat108.partyregister.model.Attendee;
import no.hvl.dat108.partyregister.util.AttendeeRepo;
import no.hvl.dat108.partyregister.util.AttendeeService;
import no.hvl.dat108.partyregister.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/${app.url.attendeeList}")
public class AttendeeController {

    @Value("/${app.url.login}")   private String LOGIN_URL;
    @Value("/${app.message.requiresLogin}")   private String REQUIRES_LOGIN_MESSAGE;

    @Autowired
    AttendeeService attendeeService;


    @GetMapping
    public String showAttendees(HttpSession session, RedirectAttributes ra) {

        Attendee attendee = (Attendee) session.getAttribute("person");



        if (!LoginUtil.isUserLoggedIn(session) && !attendeeService.isAttendee(attendee)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }

        //List<Attendee> attendees = attendeeService.findAllAttendees();
        List<Attendee> attendees = attendeeService.findAllSortedFirstName();

        session.setAttribute("attendees", attendees);



        return "attendeeView";
    }
	
	
}
