package com.target.vendingmachines;

import java.util.Scanner;

/**
 * Created by Sunil Kata on 7/14/2017.
 */
public interface VendingMachineState {
    // Refill state
    // cash insert state
    // display state
    // dispatch state
    // refund state
    public void initVendingMachine() throws Exception;
    public boolean takeInputFromCustomer(Scanner scanner) throws Exception;
    public void takeInputFromSupplier(Scanner scanner) throws Exception;
    public void dispenseProduct() throws Exception;
    public void dispenseCash() throws Exception;
}
