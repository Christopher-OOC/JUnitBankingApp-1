package org.example.fx.data;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountNumber;
    private int pin;
    private List<Double> deposits = new ArrayList<>();
    private List<Double> withdrawals = new ArrayList<>();

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public List<Double> getDeposits() {
        return deposits;
    }

    public List<Double> getWithdrawals() {
        return withdrawals;
    }
    
}
