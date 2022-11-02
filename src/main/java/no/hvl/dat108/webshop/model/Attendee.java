package no.hvl.dat108.webshop.model;

import javax.persistence.Id;

public class Attendee {
    private String firstName;
    private String lastName;

    @Id
    private int phone;
    private String password;
    private String gender;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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

    public Attendee(String firstName, String lastName, String phone, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone; //Skal antegelig være integer
        this.gender = gender; //Enum?

    }
    //For debuging
    public Attendee(String username, String pword) {
        this.firstName = "Ole";
        this.lastName ="Olsen";
        this.phone = username;
        this.password = pword;
        this.gender = "Mann";
    }







}
