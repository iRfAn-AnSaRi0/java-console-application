package com.mycompany.app.model;

import java.util.Date;

public class CreateAccount {
    private long account_number;
    private String ifc_code;
    private String account_holder_name;
    private String account_holder_phone;
    private double account_balance;
    private String account_status;
    private Date account_create_date;


    // account number generate method
    public long generate_account_number() {
        long min = 100000000000L;
        long max = 999999999999L;
        return min + (long) (Math.random() * (max - min));
    }

    // ifc code generate method

    public String generate_ifc_code() {
        String bank_code = "IFNA";
        int branch_code = (int) (Math.random() * 9000) + 1000;
        return bank_code + "000" + branch_code;
    }

    // setter constructor
    public CreateAccount(String account_holder_name, String account_holder_phone) {
        this.account_holder_name = account_holder_name;
        this.account_holder_phone = account_holder_phone;
        this.account_number = generate_account_number();
        this.ifc_code = generate_ifc_code();
        this.account_balance = 0.0;
        this.account_status = "ACTIVE";
        this.account_create_date = new Date();
    }

    // getter constructor
    public CreateAccount(long account_number, String ifc_code, String account_holder_name,
            String account_holder_phone) {
        this.account_number = account_number;
        this.ifc_code = ifc_code;
        this.account_holder_name = account_holder_name;
        this.account_holder_phone = account_holder_phone;
    }
    
     // Setter for balance (needed for deposit/withdraw)
    public void set_account_balance(double account_balance) {
        this.account_balance = account_balance;
    }

    // setter method
    public void setAccountDetails(String account_holder_name, String account_holder_phone) {
        this.account_holder_name = account_holder_name;
        this.account_holder_phone = account_holder_phone;
    }

    // getter method
    public long get_account_number() {
        return account_number;
    }

    public String get_ifc_code() {
        return ifc_code;
    }

    public String get_account_holder_name() {
        return account_holder_name;
    }

    public String get_account_holder_phone() {
        return account_holder_phone;
    }
    public double get_account_balance(){
        return account_balance;
    }
    public String get_account_status(){
        return account_status;
    }
    public Date get_account_create_date(){
        return account_create_date;
    }

    @Override
    public String toString() {
        return "Account Details {" +
                "\n  Account Number = " + account_number +
                ",\n  IFSC Code = '" + ifc_code + '\'' +
                ",\n  Name = '" + account_holder_name + '\'' +
                ",\n  Phone = '" + account_holder_phone + '\'' +
                ",\n  Balance = " + account_balance +
                ",\n  Created On = " + account_create_date +
                ",\n  Status = '" + account_status + '\'' +
                "\n}";
    }
}
