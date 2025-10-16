package com.mycompany.app.model;

import java.util.Date;

public class TransactionDetails {
    private int transaction_id;
    private long account_number;
    private double transaction_amount;
    private TransactionType transaction_type;
    private TransactionStatus transaction_status;
    private Long related_account;
    private String remarks;
    private Date transaction_date_time;

    public TransactionDetails(long account_number, double transaction_amount,
            TransactionType transaction_type, TransactionStatus transaction_status,
            Date transaction_date_time, Long related_account, String remarks) {
        this.account_number = account_number;
        this.transaction_amount = transaction_amount;
        this.transaction_type = transaction_type;
        this.transaction_status = transaction_status;
        this.transaction_date_time = new Date();
        this.related_account = related_account; // can be null for deposit/withdrawal
        this.remarks = remarks;
    }

    public TransactionDetails(int transaction_id, long account_number, double transaction_amount,
            TransactionType transaction_type, TransactionStatus transaction_status, long related_account,
            String remarks, Date transaction_date_time) {
        this.transaction_id = transaction_id;
        this.account_number = account_number;
        this.transaction_amount = transaction_amount;
        this.transaction_type = transaction_type;
        this.transaction_status = transaction_status;
        this.related_account = related_account;
        this.transaction_date_time = transaction_date_time;
        this.remarks = remarks;
    }

    public void setTransactionDetails(long account_number, double transaction_amount,
            TransactionType transaction_type) {
        this.account_number = account_number;
        this.transaction_amount = transaction_amount;
        this.transaction_type = transaction_type;
    }

    public int get_transaction_id() {
        return transaction_id;
    }

    public long get_account_number() {
        return account_number;
    }

    public double get_transaction_amount() {
        return transaction_amount;
    }

    public TransactionType get_transaction_type() {
        return transaction_type;
    }

    public TransactionStatus get_transaction_status() {
        return transaction_status;
    }

    public long get_related_account() {
        return related_account;
    }

    public String get_remarks() {
        return remarks;
    }

    public Date get_transaction_date_time() {
        return transaction_date_time;
    }

    @Override
    public String toString() {
        return "Transaction details";
    }
}
