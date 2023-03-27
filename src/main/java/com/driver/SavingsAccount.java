package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super.setName(name);
        super.setBalance(balance);
        super.setMinBalance(0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if (this.maxWithdrawalLimit < amount) throw new Exception("Maximum Withdraw Limit Exceed");
        if (super.getBalance() < amount) throw new Exception("Insufficient Balance");
        else {
            super.setBalance(super.getBalance()-amount);
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return super.getBalance() * this.rate * years;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double middle = 1 + (this.rate / times);
        middle = Math.pow(middle, times*years);
        return super.getBalance()*middle;
    }

}
