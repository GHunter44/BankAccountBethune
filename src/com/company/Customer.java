package com.company;
import java.util.*;

public class Customer {
    private int customerID;
    private String customerName;
    private ArrayList<BankAccount> accounts;

    public Customer(String name, int taxID){
        customerID = taxID;
        customerName = name;
        accounts = new ArrayList<BankAccount>();

    }

    public int getId(){
        return customerID;

    }

    public String getName(){
        return customerName;

    }

    public Optional<BankAccount> closeAccount(int accountNumber){
        for(var account: accounts){
            if (account.getAccountID() == accountNumber){
                System.out.println("Removing account with account ID "+ accountNumber);
                accounts.remove(account);
                return Optional.of(account);
            }
        }
        System.out.println("Account with account ID "+ accountNumber + " was not removed.");
        return Optional.empty();
    }

    public BankAccount openAccount(double initialDeposit){
        var newAccount = new BankAccount();
        newAccount.deposit(initialDeposit);
        var didSucceed = accounts.add(newAccount);
        return newAccount;
    }
















}
