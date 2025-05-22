package gunes.cashcard.service;


import gunes.domain.CashCard;
import gunes.domain.Transaction;

import java.util.Random;

public class DataSourceService {

    public Transaction getData() {
        CashCard cashCard = new CashCard(
                new Random().nextLong(),
                "sarah1",
                new Random().nextDouble(100.00)
        );
        return new Transaction(new Random().nextLong(), cashCard);
    }
}