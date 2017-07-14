package com.target.vendingmachines;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Sunil Kata on 7/14/2017.
 */
public class VendingMachine {
    private Supplier supplier;
    private int rows;
    private int columns;
    private static int SMALL_CAPACITY = 10;
    private static int MEDIUM_CAPACITY = 20;
    private static int LARGE_CAPACITY = 30;
    private static int EXTRA_LARGE_CAPACITY = 40;
    private Tray[][] trays;
    private static String YES_RESPONSE = "yes";

    public static void main(String[] args) {
        // do init.
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.initVendingMachine();

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Welcome! Are you here for the purchase? type yes if consumer and type no if supplier. yes/no");
            String response = sc.nextLine();
            if( YES_RESPONSE.compareToIgnoreCase(response) == 0 ) {
                if( vendingMachine.isVendingMachineEmpty() ) {
                    System.out.println("Sorry, nothing to sell for today!");
                } else {
                    // enter a number in the range (0,0) to (rows-1, columns-1)
                    // Corresponding to the tray matrix.
                    System.out.println("Enter a number corresponding to tray matrix in the range (0,0) to  ("+(vendingMachine.rows-1)+","+ (vendingMachine.columns-1)+")");
                    int row = sc.nextInt();
                    int column = sc.nextInt();
                    vendingMachine.vendProduct(sc, row, column);
                }
            } else {
                System.out.println("Well, if you are supplier, please type our identification:");
                String supplierPassword = sc.nextLine();
                if( vendingMachine.supplier.getSupplierIdentification().compareToIgnoreCase(supplierPassword) == 0 ) {
                    System.out.println("What do you want? 1. Refill Vending Machine 2. Ask for statement 3. Take cash 4. Reset");
                    int option = sc.nextInt();
                    switch (option) {
                        case 1: // Refill vending machine.. complete refill or first time fill. TODO: fill partially.
                            vendingMachine.refillVendingMachine(sc);
                            break;
                        case 2: // TODO Cash statement.
                            break;
                        case 3: // TODO clear cash?
                            break;
                    }
                } else {
                    System.out.println("Your password is wrong");
                }
            }
        }
    }

    private void vendProduct(Scanner sc, int row, int column) {
        // offer the price of the product.
        // ask for cash.
        // customer puts in something? scan the range of cash. Check available cash
        // Offer change.
        // cash manager, needs to check if he has change for the cash?
        // Otherwise, ask for exactly that price.
        //

    }


    private void refillVendingMachine(Scanner sc) {
        // TODO: variety of products could fit in, on a particular tray.
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                int trayCapacity = trays[i][j].getCapacity();
                System.out.println("We are at location "+i+" "+ j +" with capacity" + trayCapacity + " product is created with " + ProductType.SMALL);
                System.out.println("What do you want it's price to be?");
                int price = sc.nextInt();
                Queue<Product> queue = trays[i][j].getProductQueue();
                // for loop all products. Create products.
                for( int loop = 0; loop < trayCapacity; loop++) {
                    Product product=null;
                    switch (i) {
                        case 0: product = new Product(ProductType.SMALL, price);
                        case 1: product = new Product(ProductType.MEDIUM, price);
                        case 2: product = new Product(ProductType.MEDIUM, price);
                        case 3: product = new Product(ProductType.LARGE, price);
                        case 4: product = new Product(ProductType.EXTRA_LARGE, price);
                    }
                    queue.add(product);
                }
            }
        }
    }

    private boolean isVendingMachineEmpty() {
        for(int i=0;i<rows; i++) {
            for(int j=0;j<columns;j++) {
                if( ! trays[i][j].getProductQueue().isEmpty() ) {
                    return false;
                }
            }
        }
        return true;
    }

    private void initVendingMachine() {
        supplier = new Supplier("password");
        rows = 5;
        columns = 4;
        trays = new Tray[rows][];
        for(int i = 0; i < rows; i++) {
            trays[i] = new Tray[columns];
            for(int j = 0 ; j < columns; j++) {
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
                trays[i][j] = tray;
            }
        }
    }



}
