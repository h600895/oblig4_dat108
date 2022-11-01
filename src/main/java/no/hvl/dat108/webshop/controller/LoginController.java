package no.hvl.dat108.webshop.controller;

import javax.servlet.http.HttpServletRequest;

import no.hvl.dat108.webshop.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.webshop.util.InputValidator;
import no.hvl.dat108.webshop.util.LoginUtil;

@Controller
@RequestMapping("/${app.url.login}")
public class LoginController {
	
	@Value("${app.message.invalidUsername}") private String INVALID_USERNAME_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.webshop}") private String WEBSHOP_URL;
	
	/* 
	 * GET /login er forespørselen for å hente login-skjema.
	 */
	@GetMapping
    public String hentLoginSkjema() {
		return "loginView";
    }

	/* 
	 * POST /login er forespørselen for å logge inn.
	 */
	@PostMapping
    public String provAaLoggeInn(@RequestParam String firstName, String lastName, String phone, String pword, String pwordRep, String gender,
    		HttpServletRequest request,	RedirectAttributes ra) {

		//Sjekke om pword og pwordRep er like, eller skal dette gjøres i js kode?
		
		/*if (!InputValidator.isValidUsername(username)) {
			ra.addFlashAttribute("redirectMessage", INVALID_USERNAME_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}*/
		Person person = new Person(firstName, lastName, phone, pword, gender);
		System.out.println(person);
		LoginUtil.loggInnBruker(request, person);
		//LoginUtil.loggInnBruker(request, username);
		
		return "redirect:" + WEBSHOP_URL;
    }
}
