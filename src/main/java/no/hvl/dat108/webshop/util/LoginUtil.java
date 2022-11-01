package no.hvl.dat108.webshop.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.webshop.model.Cart;
import no.hvl.dat108.webshop.model.Person;

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
	}
	
	public static boolean erBrukerInnlogget(HttpSession session) {
		return session != null 
				&& session.getAttribute("username") != null
				&& session.getAttribute("cart") != null;
	}

}
