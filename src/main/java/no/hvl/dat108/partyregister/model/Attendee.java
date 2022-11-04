package no.hvl.dat108.partyregister.model;

import javax.persistence.*;

@Entity
@Table(name = "attendee", schema = "attendee")
public class Attendee {


    @Id
    private int phone;
    private String first_name;
    private String last_name;
    private String password_hash;
    private byte[] password_salt;
    private String gender;


    public Attendee(String firstName, String lastName, int phone, String hash, byte[] salt, String gender) {
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

    public int getPhone() {
        return phone;
    }

    public String getPassword_hash() { return password_hash; }

    public byte[] getPassword_salt() { return password_salt; }

    public String getGender() {
        return gender;
    }









}
