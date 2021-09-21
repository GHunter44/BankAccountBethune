package com.company;

public class Main {

    public static void main(String[] args) {

        var myAccount = new BankAccount();
        var yourAccount = new BankAccount(2000, 0.05f);
        myAccount.deposit(1000);
        var newBalance = myAccount.addInterest();
        var yourBalance = yourAccount.addInterest();
        System.out.println("Account ID "+ yourAccount.getAccountID() +" has $"+ yourBalance + " after adding the interest.");
        var succeeded = myAccount.withdraw(2000);
        if(succeeded)
            System.out.println("You withdrew successfully");
        else
            System.out.println("You failed to withdraw! Current Balance off Account "+ myAccount.getAccountID() +" is : $"+myAccount.checkBalance());
    }
}
