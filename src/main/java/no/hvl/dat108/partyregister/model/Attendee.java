package no.hvl.dat108.partyregister.model;

import javax.persistence.*;

@Entity
@Table(name = "attendee", schema = "attendee")
public class Attendee {


    @Id
    private int phone;
    private String firstName; //first_name
    private String lastName; //last_name
    private String password_hash;
    private byte[] password_salt;
    private String gender;


    public Attendee(String firstName, String lastName, int phone, String hash, byte[] salt, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.password_hash = hash;
        this.password_salt = salt;
        this.gender = gender;

    }

    public Attendee(){

    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
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
