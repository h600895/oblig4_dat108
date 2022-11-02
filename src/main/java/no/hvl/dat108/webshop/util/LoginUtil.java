package no.hvl.dat108.webshop.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.webshop.model.Attendee;

public class LoginUtil {
	
	private final static int MAX_INTERACTIVE_INTERVAL = 60;

	public static void logoutUser(HttpSession session) {
        session.invalidate();
	}

	public static void loginUnser(HttpServletRequest request, Attendee person) {
    	
        logoutUser(request.getSession());

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
        session.setAttribute("person", person);
		session.setAttribute("appendees", Database.getAttendees());
	}
	
	public static boolean isUserLoggedIn(HttpSession session) {
		return session != null 
				&& session.getAttribute("person") != null
				&& session.getAttribute("appendees") != null;
	}

}
