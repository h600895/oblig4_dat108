package no.hvl.dat108.webshop.model;

public class Person {
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private String gender;

    public Person(String firstName, String lastName, String phone, String password, String gender) {
        this.firstName =firstName;
        this.lastName =lastName;
        this.phone =phone;
        this.password =password;
        this.gender =gender;

    }
}
