package no.hvl.dat108.partyregister.controller;

import javax.servlet.http.HttpServletRequest;

import no.hvl.dat108.partyregister.model.Attendee;
import no.hvl.dat108.partyregister.util.Database;
import no.hvl.dat108.partyregister.util.RegistrationUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.partyregister.util.LoginUtil;

@Controller
@RequestMapping("/${app.url.login}")
public class LoginController {
	
	@Value("${app.message.invalidInfo}") private String INVALID_USERNAME_MESSAGE;
	@Value("/${app.url.login}")   private String LOGIN_URL;
	@Value("/${app.url.attendeeList}")   private String ATTENDEELIST_URL;

	Database database = new Database();

	/* 
	 * GET /login er forespørselen for å hente login-skjema.
	 */
	@GetMapping
    public String getLoginView() {
		return "loginView";
    }

	/* 
	 * POST /login er forespørselen for å logge inn.
	 */
	@PostMapping
    public String logIn(@RequestParam String phone, @RequestParam String pword,
    		HttpServletRequest request,	RedirectAttributes ra) {

		//tilkoble database får å få ut info om brukeren
		int usernameInt = Integer.parseInt(phone);
		Attendee attendee = database.findByPhone(usernameInt);
		if(attendee == null){
			ra.addFlashAttribute("redirectMessage", INVALID_USERNAME_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}
		byte[] attendeeSalt = attendee.getPassword_salt();
		String savedHash = attendee.getPassword_hash();
		String newHash = RegistrationUtil.hashPassword(pword, attendeeSalt);

		if (!savedHash.equals(newHash)) {
			ra.addFlashAttribute("redirectMessage", INVALID_USERNAME_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}

		//Sjekke om pword og pwordRep er like, eller skal dette gjøres i js kode?
		//Alle feltene skal bare hentes under registrering, ikke innlogging
		/*if (!InputValidator.isValidUsername(username)) {
			ra.addFlashAttribute("redirectMessage", INVALID_USERNAME_MESSAGE);
			return "redirect:" + LOGIN_URL;
		}*/



		LoginUtil.loginUser(request, attendee);
		return "redirect:" + ATTENDEELIST_URL;
		

    }
}
