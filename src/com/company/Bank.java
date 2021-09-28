package com.company;

import java.util.*;

public class Bank {
    private ArrayList<BankAccount> allAccounts;
    private ArrayList<Customer> allCustomers;

    //Constructor for doBanking
    private void printMenu() {
        System.out.println("+++++++++++++++");
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
    private void printCustomerMenu() {
        System.out.println("******************");
        System.out.println("What do you want to do with this Customer? ");
        System.out.println("   [1] Open an account ");
        System.out.println("   [2] Close an account ");
        System.out.println("   [3] Return to Main Menu ");
        System.out.println("********************");
        System.out.println("Enter Choice: ");
    }

    private void doCustomerMenu(Scanner menuReader, Customer currentCustomer){
        while(true){
            printCustomerMenu();
            var customerChoice = menuReader.nextInt();
            switch (customerChoice){
                case 1:
                    openCustomerAccount(menuReader, currentCustomer);
                    break;
                case 2:
                    closeCustomerAccount(menuReader, currentCustomer);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid Input ");
            }
        }
    }

    private void closeCustomerAccount(Scanner menuReader, Customer currentCustomer) {
        //ask user what account number to close
        System.out.println("What account would you like to close? ");
        var accountCloser = menuReader.nextInt();
        //Call close account on the customer passing that number
        var closeAccount = currentCustomer.closeAccount(accountCloser);
        //if the close succeeded remove the account from allAccounts
        allAccounts.remove(closeAccount);
    }

    private void openCustomerAccount(Scanner menuReader, Customer currentCustomer) {
        //ask the user how much money the starting deposit is.
        System.out.println("How much is your starting deposit? ");
        var initialDeposit = menuReader.nextDouble();
        //call open account on the customer
        var newAccount = currentCustomer.openAccount(initialDeposit);
        //add the new account to allAccounts
        allAccounts.add(newAccount);
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
                    if(current.isPresent())
                        doCustomerMenu(menuReader, current.get());
                    break;
                default:
                    System.out.println("You have not chosen an eligible option! ");
            }

        }

    }

}
