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
    private String first_name; //first_name

    @Size(min = 2, max = 20, message = "Etternavn må være mellom 2 og 20 bokstaver")
    private String last_name; //last_name
    private String password_hash;
    private byte[] password_salt;
    private String gender;


    public Attendee(String firstName, String lastName, String phone, String hash, byte[] salt, String gender) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.phone = phone;
        this.password_hash = hash;
        this.password_salt = salt;
        this.gender = gender;

    }

    public Attendee(){

    }

    public String getFirstName() {
        return first_name;
    }


    public String getLastName() {
        return last_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword_hash() { return password_hash; }

    public byte[] getPassword_salt() { return password_salt; }

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
