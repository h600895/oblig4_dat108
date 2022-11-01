package no.hvl.dat108.webshop.model;


import java.util.ArrayList;
import java.util.Arrays;

//Objektet som snakker med databasen
public class Database {

    //Bare for testing, skal erstattes med database data.
    public ArrayList<Person> getAttendees() {
        return new ArrayList<>(Arrays.asList(
                new Person("Fornavn1", "Etternavn1", "12345678", "Kvinne"),
                new Person("Fornavn2", "Etternavn2", "12345677", "Mann"),
                new Person("Fornavn3", "Etternavn3", "12345676", "Mann"),
                new Person("Fornavn4", "Etternavn4", "12345675", "Kvinne"),
                new Person("Fornavn5", "Etternavn5", "12345674", "Kvinne"),
                new Person("Fornavn6", "Etternavn6", "12345673", "Kvinne")
        ));
    }

}
