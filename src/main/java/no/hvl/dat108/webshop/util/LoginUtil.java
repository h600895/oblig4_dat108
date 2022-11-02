package no.hvl.dat108.webshop.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.webshop.model.Cart;
import no.hvl.dat108.webshop.model.Database;
import no.hvl.dat108.webshop.model.Person;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class LoginUtil {
	
	private final static int MAX_INTERACTIVE_INTERVAL = 60;

	public static void loggUtBruker(HttpSession session) {
        session.invalidate();
	}

	public static void loggInnBruker(HttpServletRequest request, Person person) {
    	
        loggUtBruker(request.getSession());

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
        session.setAttribute("person", person);
		session.setAttribute("appendees", Database.getAttendees());
	}
	
	public static boolean erBrukerInnlogget(HttpSession session) {
		return session != null 
				&& session.getAttribute("person") != null
				&& session.getAttribute("appendees") != null;
	}

}
