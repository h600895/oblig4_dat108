package no.hvl.dat108.webshop.model;

public class Attendee {
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private String gender;

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

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }
}
