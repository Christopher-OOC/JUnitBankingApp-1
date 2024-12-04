package org.example.fx.service;

import org.example.fx.data.User;
import org.example.fx.exceptiion.NotARegularUserException;

public class AccountService {

    public AccountService() {

    }

    public boolean login(User user, String accNum, int myPin) {

        if (!user.getAccount().getAccountNumber().equals(accNum)) {
            return false;
        }
        else if (user.getAccount().getPin() != myPin) {
            return false;
        }

        else {
            return true;
        }
    }

    public boolean deposit(User user, double amount, boolean isUserLoggedIn) {

        boolean isSuccessful = false;

        if (isUserLoggedIn) {

            if (user.getAge() < 18 && amount >= 50000) {
                throw new NotARegularUserException();
            }

            user.getAccount().getDeposits().add(amount);
            isSuccessful = true;

            return isSuccessful;

        }
        else {
            return isSuccessful;
        }
    }

}
