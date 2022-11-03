package no.hvl.dat108.partyregister.util;


import no.hvl.dat108.partyregister.model.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Objektet som snakker med databasen
@Service
public class Database {

    @Autowired static private AttendeeRepo attendeeRepo;

    //Bare for testing, skal slettes når databasen er på plass.
    public static List<Attendee> getAttendees() {
        List<Attendee> list = new ArrayList<>();
        list.add(new Attendee("Fornavn1", "Etternavn1", 12345678, "1234", "K"));
        list.add(new Attendee("Fornavn2", "Etternavn2", 12345677, "1234","M"));
        list.add(new Attendee("Fornavn3", "Etternavn3", 12345676,"1234", "M"));
        list.add(new Attendee("Fornavn4", "Etternavn4", 12345675,"1234", "K"));
        list.add(new Attendee("Fornavn5", "Etternavn5", 12345674, "1234","K"));
        list.add(new Attendee("Fornavn6", "Etternavn6", 12345673,"1234", "K"));
        return list;
    }


    /*public static Attendee createAttendee(String firstName, String lastName, int phone, String gender) {
        //Legger inn i databasen
        return new Attendee(firstName, lastName, phone, gender);
    }

    public static Attendee findAttendee(int phone) {
        //Finner i databasen
        return new Attendee();
    }*/
    //Legge til sort etter hvert
    public static List<Attendee> findAllAttendee() { return attendeeRepo.findAll();}

    public static Attendee findByPhone(int phone) {return attendeeRepo.findByPhone(phone);}

    //public void updateAttendee() {}

    public static Attendee createAttendee(String firstName, String lastName, int phone, String password, String gender) {
        Attendee attendee = new Attendee(firstName, lastName, phone, password, gender);
        attendeeRepo.save(attendee);
        return attendee;
    }

    //Returnerer true om den eksiterer
    public static boolean doesPhoneExist(int phone) { return attendeeRepo.existsById(phone);}



}
