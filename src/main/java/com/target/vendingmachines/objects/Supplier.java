package com.target.vendingmachines.objects;

/**
 * Created by Sunil Kata on 7/14/2017.
 */
public class Supplier {
    String supplierIdentification;

    public String getSupplierIdentification() {
        return supplierIdentification;
    }

    public void setSupplierIdentification(String supplierIdentification) {
        this.supplierIdentification = supplierIdentification;
    }

    public Supplier(String supplierIdentification) {
        this.supplierIdentification = supplierIdentification;
    }
}
