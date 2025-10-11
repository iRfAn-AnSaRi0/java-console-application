package com.mycompany.app.model;

import java.sql.Date;

public class IssuedBooks {

    private int issued_id;
    private int member_id;
    private int book_id;
    private String book_name;
    private Date issued_date;

     // setter constructor
    public IssuedBooks(int member_id, String book_name, Date issued_date){
         this.member_id = member_id;
         this.book_name = book_name;
         this.issued_date = issued_date;
    }
    
    // getter constructor
    public IssuedBooks(int issued_id, int member_id, int book_id, String book_name, Date issued_date){
       this.issued_id = issued_id;
       this.member_id = member_id;
       this.book_id = book_id;
       this.book_name = book_name;
       this.issued_date = issued_date;
    }
      
    // setter method
    public void setIssuedBook(int member_id, String book_name, Date issued_date){
        this.member_id = member_id;
        this.book_name = book_name;
        this.issued_date = issued_date;
    }


     public int get_issued_id(){
        return issued_id;
     }

     public int get_member_id(){
        return member_id;
     }

     public int get_book_id(){
        return book_id;
     }
     public String get_book_name(){
        return book_name;
     }
     public Date get_issued_date(){
        return issued_date;
     }

}

