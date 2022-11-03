package no.hvl.dat108.partyregister.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "attendee")
public class Attendee {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @Id
    private int phone;
    @NotNull
    private String password;
    @NotNull
    private String gender;

    public Attendee(String firstName, String lastName, int phone, String password, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.password = password;
        this.gender = gender;

    }
    //For debuging
    public Attendee(int username, String pword) {
        this.firstName = "Ole";
        this.lastName ="Olsen";
        this.phone = username;
        this.password = pword;
        this.gender = "Mann";
    }

    public Attendee(){

    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }









}
