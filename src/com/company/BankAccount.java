package com.company;

public class BankAccount {

    //Instance Variables(No value to start with)
    private double balance;
    private float interestRate;
    //End of defining instance variables

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








}
