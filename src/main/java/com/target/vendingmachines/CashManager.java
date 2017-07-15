package com.target.vendingmachines;

/**
 * Created by Sunil Kata on 7/15/2017.
 */
public class CashManager {
    int cashAvailable;
    //TODO: individual notes/coins denominations
    int cashToDispense;

    public int getCashToDispense() {
        return cashToDispense;
    }

    public void setCashToDispense(int cashToDispense) {
        this.cashToDispense = cashToDispense;
    }

    public CashManager(int cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    public int getCashAvailable() {
        return cashAvailable;
    }

    public void setCashAvailable(int cashAvailable) {
        this.cashAvailable = cashAvailable;
    }
}
