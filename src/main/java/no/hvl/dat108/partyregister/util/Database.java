package no.hvl.dat108.partyregister.util;


import no.hvl.dat108.partyregister.model.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

//Objektet som snakker med databasen
@Controller
public class Database {

    @Autowired private AttendeeService attendeeService;

    //Legge til sort etter hvert
    public List<Attendee> findAllAttendee() { return attendeeService.findAllAttendees();}

    public Attendee findByPhone(String phone) {return attendeeService.findAttendeeWithPhone(phone);}

    //public void updateAttendee() {}
    public Attendee createAttendee(String firstName, String lastName, String phone, String hash, byte[] salt, String gender) {
        Attendee attendee = new Attendee(firstName, lastName, phone, hash, salt, gender);
        attendeeService.createAttendee(attendee);
        return attendee;
    }

    //Returnerer true om den eksiterer
    public boolean doesPhoneExist(String phone) {

        return attendeeService.findAttendeeWithPhone(phone) != null;

    }





}
