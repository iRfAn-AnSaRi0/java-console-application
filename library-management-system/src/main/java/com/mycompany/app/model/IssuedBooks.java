package com.mycompany.app.model;

import java.sql.Date;

public class IssuedBooks {

   private int issued_id;
   private int member_id;
   private int book_id;
   private Date issued_date;
   private Date return_date;

   // setter constructor
   public IssuedBooks(int member_id, int book_id, Date issued_date) {
      this.member_id = member_id;
      this.book_id = book_id;
      this.issued_date = issued_date;
      this.return_date = null;

   }

   // getter constructor
   public IssuedBooks(int issued_id, int member_id, int book_id, Date return_date, Date issued_date) {
      this.issued_id = issued_id;
      this.member_id = member_id;
      this.book_id = book_id;
      this.issued_date = issued_date;
      this.return_date = return_date;
   }

   // setter method
   public void setReturnBook(Date return_date) {
      this.return_date = return_date;
   }

   public int get_issued_id() {
      return issued_id;
   }

   public int get_member_id() {
      return member_id;
   }

   public int get_book_id() {
      return book_id;
   }

   public Date get_issued_date() {
      return issued_date;
   }

   public Date get_return_date() {
      return return_date;
   }

   @Override
   public String toString() {
      return "issued_id : " + issued_id + " " + "member_id : " + member_id + " " + "book_id : " + book_id + " " + "issued_date : "
            + issued_date + " " + "return_date : " + return_date;
   }
}
