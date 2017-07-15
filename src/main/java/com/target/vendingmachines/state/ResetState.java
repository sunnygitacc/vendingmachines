package com.target.vendingmachines.state;

import com.target.vendingmachines.VendingMachine;
import com.target.vendingmachines.VendingMachineState;
import com.target.vendingmachines.objects.Product;

import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Sunil Kata on 7/15/2017.
 */
public class ResetState implements VendingMachineState {
    VendingMachine vendingMachine;

    public ResetState(VendingMachine vendingMachine) {
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
        for(int i=0;i<vendingMachine.rows;i++) {
            for(int j=0; j<vendingMachine.columns;j++) {
                // Remove all products from queues.
                Queue<Product> queue = vendingMachine.trays[i][j].getProductQueue();
                queue.clear();
            }
        }
    }

}
