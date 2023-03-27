package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, double balance, String  institutionName) {
        //minimum balance is 0 by default
        super.setBalance(balance);
        super.setName(name);
        super.setMinBalance(0);
        this.institutionName = institutionName;
    }

}
