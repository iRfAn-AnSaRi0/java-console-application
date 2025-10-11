package com.mycompany.app.model;

import java.sql.Date;

public class ReturnBooks {
    private int member_id;
    private int book_id;
    private Date return_date;


    public ReturnBooks(int member_id, int book_id, Date return_date){
       this.member_id = member_id;
       this.book_id = book_id;
       this.return_date = return_date;
    }

    public void setReturnBooks(int member_id, int book_id, Date return_date){
        this.member_id = member_id;
       this.book_id = book_id;
       this.return_date = return_date;
    }
}
