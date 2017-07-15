package com.target.vendingmachines;

import com.target.vendingmachines.objects.Record;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunil Kata on 7/15/2017.
 */
//TODO: customize this to date and time
public class StatementManager {
    List<Record> statement=null;

    public StatementManager() {
        this.statement = new ArrayList<Record>();
    }

    public void addRecord(String productId, int cashEntered, int tenderedChange, boolean isCancelled, int cashAvailable) {
        statement.add(new Record(productId, cashEntered, tenderedChange, LocalDateTime.now(), isCancelled, cashAvailable));
    }

    public void printStatement() {
        for(Record record: statement) {
            System.out.println(record);
        }
    }

    public List<Record> getStatement() {
        return statement;
    }
}
