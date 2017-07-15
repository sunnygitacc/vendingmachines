package com.target.vendingmachines.objects;

import java.util.Queue;

/**
 * Created by Sunil Kata on 7/14/2017.
 */
public class Tray {
    TraySize type;
    Queue<Product> productQueue;
    int capacity;
    Button associateButton;

    public Tray(TraySize type, Queue<Product> productQueue, int capacity, Button associateButton) {
        this.type = type;
        this.productQueue = productQueue;
        this.capacity = capacity;
        this.associateButton = associateButton;
    }

    public Button getAssociateButtons() {
        return associateButton;
    }

    public void setAssociateButtons(Button assoiateButton) {
        this.associateButton = associateButton;
    }

    public TraySize getType() {
        return type;
    }

    public void setType(TraySize type) {
        this.type = type;
    }

    public Queue<Product> getProductQueue() {
        return productQueue;
    }

    public void setProductQueue(Queue<Product> productQueue) {
        this.productQueue = productQueue;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
