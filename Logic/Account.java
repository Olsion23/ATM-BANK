package Logic;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;

    private double savingBalance = 0;
    private double checkingBalance = 0;
    Scanner accountInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }


    /* Set customer number*/
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getCustomerNumber() {
        return this.customerNumber;
    }
    /* Calculate Checking Account Withdraw */
    public double calculateCheckingWithdraw(double amount){
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }
    /* Calculate Saving Account Withdraw */
    public double calculateSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }
    /* Calculate Account Deposit */
    public double calculateCheckingDeposit(double amount) {
        checkingBalance = (savingBalance - amount);
        return checkingBalance;
    }
    /* Calculate Saving Account Deposit */
    public double calculateSavingDeposit(double amount){
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }
    /* Customer Checking Account Withdraw Input */
    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking Account: ");
        double amount = accountInput.nextDouble();

        if ((checkingBalance - amount) > 0) {
            calculateCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("You Dont Have Enough Money" + "\n");
        }
    }
    /* Customer Saving Account Withdraw Input */
    public void getSavingWithdrawInput(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount You Want To Withdraw From Saving Account: ");
        double amount = accountInput.nextDouble();

        if ((savingBalance - amount) > 0){
            calculateSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: " + savingBalance + "\n");
        }else {
            System.out.println("Balance Can Not Be Negative");
        }
    }
    /*Customer Checking Account Deposit Input */
    public void getCheckingDepositInput(){
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount You Want To Deposit From Checking Account: ");
        double amount = accountInput.nextDouble();

        if ((checkingBalance + amount) >= 0){
            calculateCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        }else {
            System.out.println("Balance Can Not Be Negative" + "\n");
        }
    }
    /*Customer Saving Account Deposit Input */
    public void getSavingDepositInput(){
        System.out.println("Save Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount You Want To Deposit From Saving Account: ");
        double amount = accountInput.nextDouble();

        if ((savingBalance + amount) >= 0){
            calculateSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        }else {
            System.out.println("Balance Can Not Be Negative" + "\n");
        }
    }
}
