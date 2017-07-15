package com.target.vendingmachines.state;

import com.target.vendingmachines.VendingMachine;
import com.target.vendingmachines.VendingMachineState;
import com.target.vendingmachines.objects.Product;

import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Sunil Kata on 7/15/2017.
 */
public class DispenseState implements VendingMachineState {
    VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void initVendingMachine() throws Exception {
        throw new Exception("Inited already");
    }

    @Override
    public boolean takeInputFromCustomer(Scanner scanner) throws Exception {
        throw new Exception("Dispensing state, cannot input at the moment");
    }

    @Override
    public void takeInputFromSupplier(Scanner scanner) throws Exception {
        throw new Exception("Dispensing state, cannot input at the moment");
    }

    @Override
    public void dispenseProduct() throws Exception {
        int row = vendingMachine.dispensingRow;
        int column = vendingMachine.dispensingColumn;
        int quantity = vendingMachine.dispensingQuantity;
        Queue<Product> queue = vendingMachine.trays[row][column].getProductQueue();
        for(int i=0;i<quantity;i++) {
            queue.remove();
        }
        System.out.println("Dispensing products");
    }

    @Override
    public void dispenseCash() throws Exception {
        // TODO: Give out in denominations
        int cashToDispense = vendingMachine.cashManager.getCashToDispense();
        if( cashToDispense > 0 ) {
            System.out.println("Please take the change of " + cashToDispense);
            vendingMachine.cashManager.setCashToDispense(0);
        }
    }
}
