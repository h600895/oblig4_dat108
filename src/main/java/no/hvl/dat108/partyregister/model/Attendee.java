package no.hvl.dat108.partyregister.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "attendee")
public class Attendee {


    @Id
    private int phone;
    private String firstName;
    private String lastName;
    private String hash;
    private byte[] salt;
    private String gender;

    public Attendee(String firstName, String lastName, int phone, String hash, byte[] salt, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.hash = hash;
        this.salt = salt;
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

    public String getHash() { return hash; }

    public byte[] getSalt() { return salt; }

    public String getGender() {
        return gender;
    }









}
