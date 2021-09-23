package com.company;

import java.util.*;

public class Bank {
    private ArrayList<BankAccount> allAccounts;
    private ArrayList<Customer> allCustomers;

    private void printMenu() {
        System.out.println("What would you like to do next?(Select the Number) ");
        System.out.println(" [1] Exit the Program");
        System.out.println(" [2] Add a customer");
        System.out.println(" Add more soon");

    }

    private void addCustomer() {
    }

    public Bank(){
        allAccounts = new ArrayList<BankAccount>();
        allCustomers = new ArrayList<Customer>();

    }

    public void doBanking(){
        var menuReader = new Scanner(System.in);
        while(true){
            printMenu();
            var userChoice = menuReader.nextInt();
            switch (userChoice){
                case 1:
                    System.exit(0);
                case 2:
                    addCustomer();
                    break;
            }

        }

    }




}
