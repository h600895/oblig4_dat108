package no.hvl.dat108.partyregister.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.partyregister.model.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public class LoginUtil {
	
	private final static int MAX_INTERACTIVE_INTERVAL = 60;

	@Autowired static AttendeeService attendeeService;

	@Value("/${app.url.login}")   private static String LOGIN_URL;
	@Value("/${app.message.requiresLogin}")   private static String REQUIRES_LOGIN_MESSAGE;


	public static void logoutUser(HttpSession session) {
        session.invalidate();
	}

	public static void loginUser(HttpServletRequest request, Attendee person) {
    	
        logoutUser(request.getSession());

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
        session.setAttribute("person", person);
		//session.setAttribute("attendees", );
	}
	
	public static boolean isUserLoggedIn(HttpSession session) {
		return session != null 
				&& session.getAttribute("person") != null;
	}

	//Sjekker om deltageren ligger i databasen
	public static boolean isAttendee(HttpSession session) {

		Attendee attendee = (Attendee) session.getAttribute("person");

		if (attendee == null) {
			return false;
		}
		return attendeeService.isAttendee(attendee);
	}

	public static boolean isAutorised(HttpSession session) {
		return LoginUtil.isUserLoggedIn(session) || LoginUtil.isAttendee(session);
	}

}
