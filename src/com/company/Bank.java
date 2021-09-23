package com.company;

import java.util.*;

public class Bank {
    private ArrayList<BankAccount> allAccounts;
    private ArrayList<Customer> allCustomers;

    //Constructor for doBanking
    private void printMenu() {
        System.out.println("What would you like to do next?(Select the Number) ");
        System.out.println(" [1] Exit the Program");
        System.out.println(" [2] Add a customer");
        System.out.println(" [3] Select customer by ID");
        System.out.println("Enter Choice: ");

    }
    //Constructor for doBanking
    private void addCustomer(Scanner inputReader) {
        System.out.println("Input Customer's Name: ");
        inputReader.nextLine(); //eat the orphan newline from previous nextInt call
        var customerName = inputReader.nextLine();
        System.out.println("Input Customer's SSN: ");
        var taxId = inputReader.nextInt();
        var newCustomer = new Customer(customerName, taxId);
        allCustomers.add(newCustomer);
    }
    private void doCustomerMenu(Scanner menuReader){
        System.out.println("Next Week Finish");
    }

    //Constructor for doBanking
    private Optional<Customer> selectCustomer(Scanner reader) {
        System.out.println("Input Customer ID to select: ");
        var idToFind = reader.nextInt();
        for(var currentCustomer:allCustomers){
            if(currentCustomer.getId() == idToFind)
                return Optional.of(currentCustomer);
        }
        return Optional.empty();
    }


    public Bank(){
        allAccounts = new ArrayList<BankAccount>();
        allCustomers = new ArrayList<Customer>();

    }

    public void doBanking() {
        var menuReader = new Scanner(System.in);
        while (true) {
            printMenu();
            var userChoice = menuReader.nextInt();
            switch (userChoice) {
                case 1:
                    System.exit(0);
                case 2:
                    addCustomer(menuReader);
                    break;
                case 3:
                    Optional<Customer> current = selectCustomer(menuReader);
                    break;
                default:
                    System.out.println("You have not chosen an eligible option! ");
            }

        }

    }

}
