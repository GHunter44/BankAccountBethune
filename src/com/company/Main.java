package com.company;

public class Main {

    public static void main(String[] args) {

        var myAccount = new BankAccount();
        myAccount.deposit(1000);
        var newBalance = myAccount.addInterest();

        var succeeded = myAccount.withdraw(2000);
        if(succeeded)
            System.out.println("You withdrew successfully");
        else
            System.out.println("You failed to withdraw! Current Balance is: "+myAccount.checkBalance());
    }
}
