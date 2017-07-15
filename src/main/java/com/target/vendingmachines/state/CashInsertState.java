package com.target.vendingmachines.state;

import com.target.vendingmachines.VendingMachine;
import com.target.vendingmachines.VendingMachineState;
import com.target.vendingmachines.objects.Product;

import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Sunil Kata on 7/15/2017.
 */
public class CashInsertState implements VendingMachineState {
    VendingMachine vendingMachine;

    public CashInsertState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void initVendingMachine() throws Exception {
        throw new Exception("Already initialized");
    }

    @Override
    public boolean takeInputFromCustomer(Scanner scanner) throws Exception {
        System.out.println("Enter a number corresponding to tray matrix in the range (0,0) to " +
                " ("+(vendingMachine.rows-1)+","+ (vendingMachine.columns-1)+")");
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        vendingMachine.dispensingRow = row;
        vendingMachine.dispensingColumn = column;
        System.out.println("Also please enter the quantity ");
        int quantity = scanner.nextInt();
        vendingMachine.dispensingQuantity = quantity;
        if( vendingMachine.doesProductExistsInQuantity(row, column, quantity) ) {
            int cashToEnter = vendingMachine.trays[row][column].getProductQueue().element().getPrice() * quantity;
            System.out.println("Please enter cash for: " + cashToEnter);
            int cashEntered = scanner.nextInt();
            int cashAvailable = vendingMachine.cashManager.getCashAvailable();
            int diff = cashEntered - cashToEnter;
            recordThisEntry(row, column, cashEntered, cashAvailable, diff);
            if( diff < 0 ) {
                System.out.println("Not sufficient cash to buy these products");
            } else if( diff == 0 ) {
                vendingMachine.cashManager.setCashAvailable(cashAvailable+cashToEnter);
            } else  {
                vendingMachine.cashManager.setCashAvailable(cashAvailable+cashToEnter);
                vendingMachine.cashManager.setCashToDispense(diff);
            }
        } else {
            System.out.println("Not enough quantity in the vending machine");
            return false;
        }
        return true;
    }

    private void recordThisEntry(int row, int column, int cashEntered, int cashAvailable, int diff) {
        StringBuffer sb = new StringBuffer();
        Queue<Product> queue = vendingMachine.trays[row][column].getProductQueue();
        for(Product product : queue) {
            sb.append(product.getProductId()+",");
        }
        vendingMachine.statementManager.addRecord(sb.toString(), cashEntered, diff, false, cashAvailable);
    }

    @Override
    public void takeInputFromSupplier(Scanner scanner) throws Exception {
        throw new Exception("Customer is trying to input");
    }

    @Override
    public void dispenseProduct() throws Exception {
        throw new Exception("Not yet ready to dispense");
    }

    @Override
    public void dispenseCash() throws Exception {
        throw new Exception("Not yet ready to dispense");

    }

    @Override
    public void reset() throws Exception {
        throw new Exception("Cannot reset while inserting");
    }
}
