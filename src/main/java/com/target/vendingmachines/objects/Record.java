package com.target.vendingmachines.objects;

import java.time.LocalDateTime;

/**
 * Created by Sunil Kata on 7/15/2017.
 */
public class Record {
    String productIdPurchased;
    int cashEntered;
    int tenderedChange;
    LocalDateTime localDateTime;
    boolean isCancelled;
    int cashAvailable;


    public Record(String productIdPurchased, int cashEntered, int tenderedChange, LocalDateTime localDateTime, boolean isCancelled, int cashAvailable) {
        this.productIdPurchased = productIdPurchased;
        this.cashEntered = cashEntered;
        this.tenderedChange = tenderedChange;
        this.localDateTime = localDateTime;
        this.isCancelled = isCancelled;
        this.cashAvailable = cashAvailable;
    }

    @Override
    public String toString() {
        return "Record{" +
                "productIdPurchased='" + productIdPurchased + '\'' +
                ", cashEntered=" + cashEntered +
                ", tenderedChange=" + tenderedChange +
                ", localDateTime=" + localDateTime +
                ", isCancelled=" + isCancelled +
                ", cashAvailable=" + cashAvailable +
                '}';
    }

    public String getProductIdPurchased() {
        return productIdPurchased;
    }

    public void setProductIdPurchased(String productIdPurchased) {
        this.productIdPurchased = productIdPurchased;
    }

    public int getCashEntered() {
        return cashEntered;
    }

    public void setCashEntered(int cashEntered) {
        this.cashEntered = cashEntered;
    }

    public int getTenderedChange() {
        return tenderedChange;
    }

    public void setTenderedChange(int tenderedChange) {
        this.tenderedChange = tenderedChange;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public int getCashAvailable() {
        return cashAvailable;
    }

    public void setCashAvailable(int cashAvailable) {
        this.cashAvailable = cashAvailable;
    }
}
