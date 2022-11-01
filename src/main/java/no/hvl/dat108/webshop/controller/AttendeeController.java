package no.hvl.dat108.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/${app.url.attendeeList}")
public class AttendeeController {

    @GetMapping
    public String getLoginView() {
        return "attendeeView";
    }
	
	
}
