package com.target.vendingmachines.state;

import com.target.vendingmachines.*;
import com.target.vendingmachines.objects.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Sunil Kata on 7/14/2017.
 */
public class StartState implements VendingMachineState {

    private static int SMALL_CAPACITY = 10;
    private static int MEDIUM_CAPACITY = 20;
    private static int LARGE_CAPACITY = 30;
    private static int EXTRA_LARGE_CAPACITY = 40;

    VendingMachine vendingMachine;

    public StartState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void initVendingMachine() throws Exception {
        vendingMachine.supplier = new Supplier("password");
        vendingMachine.rows = 5;
        vendingMachine.columns = 4;
        vendingMachine.cashManager = new CashManager(100);
        vendingMachine.trays = new Tray[vendingMachine.rows][];
        for(int i = 0; i < vendingMachine.rows; i++) {
            vendingMachine.trays[i] = new Tray[vendingMachine.columns];
            for(int j = 0 ; j < vendingMachine.columns; j++) {
                Queue<Product> productQueue = new LinkedList<Product>();
                Button button = new Button(i*j);
                Tray tray=null;
                switch(i) {
                    case 0: tray = new Tray(TraySize.SMALL, productQueue, SMALL_CAPACITY, button); break;
                    case 1: tray = new Tray(TraySize.SMALL, productQueue, MEDIUM_CAPACITY, button); break;
                    case 2: tray = new Tray(TraySize.SMALL, productQueue, MEDIUM_CAPACITY, button); break;
                    case 3: tray = new Tray(TraySize.SMALL, productQueue, LARGE_CAPACITY, button); break;
                    case 4: tray = new Tray(TraySize.SMALL, productQueue, EXTRA_LARGE_CAPACITY, button); break;
                }
                vendingMachine.trays[i][j] = tray;
            }
        }
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
}
