package no.hvl.dat108.partyregister.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "attendee", schema = "attendee")
public class Attendee {


    @Id
    @Size(min = 8, max = 8, message = "Nummer må være akkurat 8 siffer")
    private String phone;

    @Size(min = 2, max = 20, message = "Fornavn må være mellom 2 og 20 bokstaver")
    private String firstname; //first_name

    @Size(min = 2, max = 20, message = "Etternavn må være mellom 2 og 20 bokstaver")
    private String lastname; //last_name
    private String passwordhash;
    private byte[] passwordsalt;
    private String gender;


    public Attendee(String firstName, String lastName, String phone, String hash, byte[] salt, String gender) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.phone = phone;
        this.passwordhash = hash;
        this.passwordsalt = salt;
        this.gender = gender;

    }

    public Attendee(){

    }

    public String getFirstName() {
        return firstname;
    }


    public String getLastName() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getPasswordhash() { return passwordhash; }

    public byte[] getPassword_salt() { return passwordsalt; }

    public String getGender() {
        return gender;
    }
    public String getFullGender () {
        if (gender.equals("M")) {
            return "Mann";
        }
        return "Kvinne";
    }









}
