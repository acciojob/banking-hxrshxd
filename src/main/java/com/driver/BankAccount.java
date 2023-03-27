package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount() {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (digits*9 > sum) throw new Exception("Account Number can not be generated");
        int[] accountNo = new int[digits];
        sum--;
        for (int i=digits-1; i>=0; i++) {
            if (sum <= 9) {
                accountNo[i] = sum;
                sum = 0;
            } else  {
                accountNo[i] = 9;
                sum -= 9;
            }
        }
        accountNo[0] += sum;
        String account = "";
        for (int i=0; i<digits; i++) {
            account += accountNo[i];
        }
        return account;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if (this.balance - amount < minBalance) throw new Exception("Insufficient Balance");
        else this.balance -= amount;
    }

}