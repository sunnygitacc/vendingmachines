package com.target.vendingmachines;

import com.target.vendingmachines.objects.Supplier;
import com.target.vendingmachines.objects.Tray;
import com.target.vendingmachines.state.*;

import java.util.Scanner;

/**
 * Created by Sunil Kata on 7/14/2017.
 */
public class VendingMachine implements VendingMachineState {
    public Supplier supplier;
    public int rows;
    public int columns;
    public Tray[][] trays;
    private static String YES_RESPONSE = "yes";
    public static VendingMachineState state = null;
    public CashManager cashManager = null;
    public int dispensingRow = -1;
    public int dispensingColumn = -1;
    public int dispensingQuantity = -1;
    public StatementManager statementManager = null;

    public VendingMachine() {
        this.state = new StartState(this);
    }

    public static void main(String[] args) throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        // do init.
        vendingMachine.state.initVendingMachine();
        vendingMachine.state = new IdleState(vendingMachine);

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Welcome! Are you here for the purchase? type yes if consumer and type no if supplier. yes/no");
            String response = sc.nextLine();
            if( YES_RESPONSE.compareToIgnoreCase(response) == 0 ) {
                if( vendingMachine.isVendingMachineEmpty() ) {
                    System.out.println("Sorry, nothing to sell for today!");
                } else {
                    state = new CashInsertState(vendingMachine);
                    boolean next = state.takeInputFromCustomer(sc);
                    if( next ) {
                        state = new DispenseState(vendingMachine);
                        state.dispenseProduct();
                        state.dispenseCash();
                    }
                }
            } else {
                System.out.println("Well, if you are supplier, please type our identification:");
                String supplierPassword = sc.nextLine();
                if( vendingMachine.supplier.getSupplierIdentification().compareToIgnoreCase(supplierPassword) == 0 ) {
                    System.out.println("What do you want? 1. Refill Vending Machine 2. Ask for statement 3. Take cash 4. Reset");
                    int option = sc.nextInt();
                    switch (option) {
                        case 1: //TODO: fill partially.
                            state = new RefillState(vendingMachine);
                            state.takeInputFromSupplier(sc);
                            break;
                        case 2: vendingMachine.statementManager.printStatement();
                            break;
                        case 3: // TODO clear cash?
                            break;
                        case 4: // reset
                            state = new ResetState(vendingMachine);
                            state.reset();
                            break;
                    }
                } else {
                    System.out.println("Your password is wrong");
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

    public boolean doesProductExistsInQuantity(int row, int column, int quantity) {
        if( this.trays[row][column].getProductQueue().size() >= quantity ) {
            return true;
        }
        return false;
    }

    @Override
    public void initVendingMachine() throws Exception {
        state.initVendingMachine();
    }

    @Override
    public boolean takeInputFromCustomer(Scanner scanner) throws Exception {
        return state.takeInputFromCustomer(scanner);
    }

    @Override
    public void takeInputFromSupplier(Scanner scanner) throws Exception {
        state.takeInputFromSupplier(scanner);
    }

    @Override
    public void dispenseProduct() throws Exception {
        state.dispenseProduct();
    }

    @Override
    public void dispenseCash() throws Exception {
        state.dispenseCash();
    }

    @Override
    public void reset() throws Exception {
        state.reset();
    }
}
