package com.company;
import java.util.*;

public class Customer {
    private int customerID;
    private String customerName;
    private ArrayList<BankAccount> accounts;

    public Customer(String name, int taxID){
        customerID = taxID;
        customerName = name;

    }

    public int getId(){
        return customerID;

    }

    public String getName(){
        return customerName;

    }

    public boolean openAccount(double initialDeposit){
        var newAccount = new BankAccount();
        newAccount.deposit(initialDeposit);
        var didSucceed = accounts.add(newAccount);
        return didSucceed;
    }
















}
