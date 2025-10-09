package com.mycompany.app.model;

public class Members {

    private int member_id;
    private String member_name;
    private String member_email;
    private String member_phone;
    private Integer member_issued_books;

    // setter constructor
    public Members(String member_name, String member_email, String member_phone, Integer member_issued_books) {
        this.member_name = member_name;
        this.member_email = member_email;
        this.member_phone = member_phone;
        this.member_issued_books = member_issued_books;
    }

    // getter constructor
    public Members(int member_id, String member_name, String member_email, String member_phone,
            Integer member_issued_books) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.member_email = member_email;
        this.member_phone = member_phone;
        this.member_issued_books = member_issued_books;
    }

    // setter method

    public void setMember(String member_name, String member_email, String member_phone, Integer member_issued_books) {
        this.member_name = member_name;
        this.member_email = member_email;
        this.member_phone = member_phone;
        this.member_issued_books = member_issued_books;
    }

    // getter method

    public int get_member_id() {
        return member_id;
    }

    public String get_member_name() {
        return member_name;
    }

    public String get_member_email() {
        return member_email;
    }

    public String get_member_phone() {
        return member_phone;
    }

    public Integer get_member_issued_books() {
        return member_issued_books;
    }

    @Override
    public String toString() {
        return "member_id : " + member_id + "member_name : " + member_name + "member_email : " + member_email
                + "member_phone : " + member_phone + "member_issued_books : " + member_issued_books;
    }

}