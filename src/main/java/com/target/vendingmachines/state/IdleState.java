package com.target.vendingmachines.state;

import com.target.vendingmachines.VendingMachine;
import com.target.vendingmachines.VendingMachineState;

import java.util.Scanner;

/**
 * Created by Sunil Kata on 7/14/2017.
 */
public class IdleState implements VendingMachineState {

    VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void initVendingMachine() throws Exception {
        throw new Exception("Nothing to init at Idle state");
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
        throw new Exception("Cannot dispense at Idle State");
    }

    @Override
    public void dispenseCash() throws Exception {
        throw new Exception("Cannot dispense cash at Idle State");
    }

    @Override
    public void reset() throws Exception {

    }

    @Override
    public void cancelTransaction() throws Exception {

    }
}
