package com.target.vendingmachines.state;

import com.target.vendingmachines.VendingMachine;
import com.target.vendingmachines.VendingMachineState;
import com.target.vendingmachines.objects.Product;

import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Sunil Kata on 7/15/2017.
 */
public class CancelState implements VendingMachineState {
    VendingMachine vendingMachine;

    public CancelState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void initVendingMachine() throws Exception {

    }

    @Override
    public boolean takeInputFromCustomer(Scanner scanner) throws Exception {
        return false;
    }

    @Override
    public void takeInputFromSupplier(Scanner scanner) throws Exception {

    }

    @Override
    public void dispenseProduct() throws Exception {

    }

    @Override
    public void dispenseCash() throws Exception {

    }

    @Override
    public void reset() throws Exception {

    }

    @Override
    public void cancelTransaction() throws Exception {
        // Get the list of products, add them back to the product queue
        int row = vendingMachine.dispensingRow;
        int column = vendingMachine.dispensingColumn;
        int quantity = vendingMachine.dispensingQuantity;
        Queue<Product> queue = vendingMachine.trays[row][column].getProductQueue();
        int cashToGiveBack = 0;
        for(Product product : vendingMachine.productsRemovedLastTransaction) {
            cashToGiveBack += product.getPrice();
            queue.add(product);
        }
        int cashAvailable = vendingMachine.cashManager.getCashAvailable();
        vendingMachine.cashManager.setCashToDispense(cashToGiveBack);
        vendingMachine.cashManager.setCashAvailable(cashAvailable-cashToGiveBack);
    }
}
