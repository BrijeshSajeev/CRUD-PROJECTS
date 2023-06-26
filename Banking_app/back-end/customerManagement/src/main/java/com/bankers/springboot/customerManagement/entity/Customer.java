package com.bankers.springboot.customerManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "first_name")
        private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="accNo")
    private String accNo;
    @Column(name = "email")
    private String email;

    @Column(name = "pin")
    private int pin;

    @Column(name = "balance")
    private double balance;


    public Customer() {
    }

    public Customer(String firstName, String lastName,int pin,String accNo, String email, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.balance = balance;
        this.pin=pin;
        this.accNo=accNo;

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accNo='" + accNo + '\'' +
                ", email='" + email + '\'' +
                ", pin=" + pin +
                ", balance=" + balance +
                '}';
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}

