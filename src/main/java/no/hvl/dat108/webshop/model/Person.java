package no.hvl.dat108.webshop.model;

public class Person {
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private String gender;

    public Person(String firstName, String lastName, String phone, String password, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone; //Skal antegelig være integer
        this.password = password; //Må være hashet
        this.gender = gender; //Enum?

    }
    //For debuging
    public Person(String username, String pword) {
        this.firstName = "firstName";
        this.lastName ="lastName";
        this.phone = username;
        this.password = pword;
        this.gender = "kvinne";
    }
}
