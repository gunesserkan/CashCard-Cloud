package com.gunes.enricher.service;

import gunes.domain.ApprovalStatus;
import gunes.domain.CardHolderData;
import gunes.domain.EnrichedTransaction;
import gunes.domain.Transaction;

import java.util.UUID;

public class EnrichmentService {

    public EnrichedTransaction enrichTransaction(Transaction transaction) {
        return new EnrichedTransaction(transaction.id(), transaction.cashCard(), ApprovalStatus.APPROVED,
                new CardHolderData(UUID.randomUUID(), transaction.cashCard().owner(), "123 Main street"));
    }

}
