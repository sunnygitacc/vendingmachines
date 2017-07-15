package com.target.vendingmachines.state;

import com.target.vendingmachines.objects.Product;
import com.target.vendingmachines.objects.ProductType;
import com.target.vendingmachines.VendingMachine;
import com.target.vendingmachines.VendingMachineState;

import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Sunil Kata on 7/14/2017.
 */
public class RefillState implements VendingMachineState {
    VendingMachine vendingMachine;

    public RefillState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void initVendingMachine() throws Exception {
        throw new Exception("At Refill, should have inited already");
    }

    @Override
    public boolean takeInputFromCustomer(Scanner scanner) throws Exception {
        throw new Exception("Cannot honor customers when refilling");
    }

    @Override
    public void takeInputFromSupplier(Scanner scanner) throws Exception {
        refillVendingMachine(scanner);
    }

    @Override
    public void dispenseProduct() throws Exception {
        throw new Exception("Cannot dispense at refill state");
    }

    @Override
    public void dispenseCash() throws Exception {
        throw new Exception("Cannot dispense at refill state");
    }

    @Override
    public void reset() throws Exception {
        throw new Exception("Cannot reset while refilling");
    }

    @Override
    public void cancelTransaction() throws Exception {

    }

    private void refillVendingMachine(Scanner sc) {
        // TODO: variety of products could fit in, on a particular tray.
        for(int i=0;i<vendingMachine.rows;i++) {
            for(int j=0;j<vendingMachine.columns;j++) {
                int trayCapacity = vendingMachine.trays[i][j].getCapacity();
                System.out.println("We are at location "+i+" "+ j +" with capacity" + trayCapacity +
                        " product is created with " + ProductType.SMALL);
                System.out.println("Do you want to set quantity on this tray?");
                int quantity = sc.nextInt();
                System.out.println("What do you want it's price to be?");
                int price = sc.nextInt();
                Queue<Product> queue = vendingMachine.trays[i][j].getProductQueue();
                // for loop all products. Create products.
                quantity = quantity == 0 ? trayCapacity : quantity;
                for( int loop = 0; loop < quantity; loop++) {
                    Product product=null;
                    String productId = Integer.toString(i) + Integer.toString(j) + Integer.toString(loop);
                    switch (i) {
                        case 0: product = new Product(productId, ProductType.SMALL, price);
                        case 1: product = new Product(productId, ProductType.MEDIUM, price);
                        case 2: product = new Product(productId, ProductType.MEDIUM, price);
                        case 3: product = new Product(productId, ProductType.LARGE, price);
                        case 4: product = new Product(productId, ProductType.EXTRA_LARGE, price);
                    }
                    queue.add(product);
                }
            }
        }
    }
}
