package ru.gb.jtwo.lc.hw;

public class Person {
    private String phoneNumber;
    private String email;

    Person(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return (phoneNumber + ", " + email);
    }
}
