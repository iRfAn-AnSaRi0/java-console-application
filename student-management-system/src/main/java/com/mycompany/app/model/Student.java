package com.mycompany.app.model;

import java.sql.Date;

public class Student {

    private int id;
    private String name;
    private String email;
    private String phone;
    private java.sql.Date dob;
    private String address;

    public Student(String name, String email, String phone, java.sql.Date dob, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.address = address;
    }

    public Student(int id, String name, String email, String phone, java.sql.Date dob, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.address = address;
    }

    public void setStudentDetails(String name, String email, String phone, java.sql.Date dob, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.address = address;
    }

    public int get_id() {
        return id;
    }

    public String get_name() {
        return name;
    }

    public String get_email() {
        return email;
    }

    public String get_phone() {
        return phone;
    }

    public Date get_dob() {
        return dob;
    }

    public String get_address() {
        return address;
    }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Email=" + email +
                ", Phone=" + phone + ", DOB=" + dob + ", Address=" + address + "]";
    }

}