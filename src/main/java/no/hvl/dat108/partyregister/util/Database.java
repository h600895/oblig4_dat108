package no.hvl.dat108.partyregister.util;


import no.hvl.dat108.partyregister.model.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

//Objektet som snakker med databasen
@Controller
public class Database {

    @Autowired private AttendeeService attendeeService;

    //Bare for testing, skal slettes når databasen er på plass.
    /*public static List<Attendee> getAttendees() {
        List<Attendee> list = new ArrayList<>();
        list.add(new Attendee("Fornavn1", "Etternavn1", 12345678, "1234", "K"));
        list.add(new Attendee("Fornavn2", "Etternavn2", 12345677, "1234","M"));
        list.add(new Attendee("Fornavn3", "Etternavn3", 12345676,"1234", "M"));
        list.add(new Attendee("Fornavn4", "Etternavn4", 12345675,"1234", "K"));
        list.add(new Attendee("Fornavn5", "Etternavn5", 12345674, "1234","K"));
        list.add(new Attendee("Fornavn6", "Etternavn6", 12345673,"1234", "K"));
        return list;
    }*/


    /*public static Attendee createAttendee(String firstName, String lastName, int phone, String gender) {
        //Legger inn i databasen
        return new Attendee(firstName, lastName, phone, gender);
    }

    public static Attendee findAttendee(int phone) {
        //Finner i databasen
        return new Attendee();
    }*/
    //Legge til sort etter hvert
    public List<Attendee> findAllAttendee() { return attendeeService.findAllAttendees();}

    public Attendee findByPhone(int phone) {return attendeeService.findAttendeeWithPhone(phone);}

    //public void updateAttendee() {}
    public Attendee createAttendee(String firstName, String lastName, int phone, String hash, byte[] salt, String gender) {
        Attendee attendee = new Attendee(firstName, lastName, phone, hash, salt, gender);
        attendeeService.createAttendee(attendee);
        return attendee;
    }

    //Returnerer true om den eksiterer
    public boolean doesPhoneExist(int phone) {

        if(attendeeService.findAttendeeWithPhone(phone) == null){
            return false;
        }
        return true;

    }



}
