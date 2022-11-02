package no.hvl.dat108.webshop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/${app.url.registration}")
public class RegistrationController {

    @Value("/${app.url.registration}") private String REGISTER_URL;
    @Value("/${app.url.attendeeList}") private String ATTENDEELIST_URL;

    //Har felter for Fornavn, Etternavn, Mobil, Passord, Passord repetert, kjønn
    private String firstName;
    private String lastName;
    private int phone;
    private String password;
    private String passwordRepeated;
    private String gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @GetMapping
    public String getRegisterView(){ return "registerView"; }

    @PostMapping
    public String registerUser() {
        return "redirect:" + ATTENDEELIST_URL;
    }

}