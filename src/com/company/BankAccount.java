package com.company;

public class BankAccount {

    //Instance Variables(No value to start with)
    private double balance;
    private float interestRate;
    private int accountID;
    private static int nextID = 100;
    //End of defining instance variables

    //Constructor for Interest and Giving an ID to a Bank Account
    public BankAccount(){
        interestRate = 0.02f;
        accountID = nextID;
        nextID++; //Same thing as nextID = nextID + 1

    }

    //Second Constructor. Works because Parameters VV are different
    public BankAccount(double initialBalance, float initialRate){
        balance = initialBalance;
        interestRate = initialRate;
        accountID = nextID;
        nextID++; //Same thing as nextID = nextID + 1

    }


    //Deposit Method
    public void deposit(double amount){
        balance += amount;

    }

    //Withdraw Method
    public boolean withdraw(double amount){
        if(amount > balance){
            return false;
        }//No need to use an else statement. Only continues program if it is true.
        balance = balance - amount;
        return true;

    }

    //Interest Method
    public double addInterest(){

        balance += balance * interestRate;
        return balance;

    }

    //Check Balance Method
    public double checkBalance(){

        return balance;

    }

    public int getAccountID(){
        return accountID;

    }










}
