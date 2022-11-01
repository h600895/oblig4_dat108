package no.hvl.dat108.webshop.controller;

import no.hvl.dat108.webshop.model.Person;
import no.hvl.dat108.webshop.util.InputValidator;
import no.hvl.dat108.webshop.util.LoginUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/${app.url.paamelding}")
public class PaameldingController {

    @Value("${app.url.paamelding}") private String REGISTER_URL;
    @Value("${app.url.deltagerListe}") private String LIST_URL;

    @GetMapping
    public String getRegisterView(){ return "registerView"; }

    @PostMapping
    public String registerUser() {
        return "redirect: " + LIST_URL;
    }

}