package com.gunes.enricher.service;

import com.gunes.enricher.domain.ApprovalStatus;
import com.gunes.enricher.domain.CardHolderData;
import com.gunes.enricher.domain.EnrichedTransaction;
import com.gunes.enricher.domain.Transaction;

import java.util.UUID;

public class EnrichmentService {

    public EnrichedTransaction enrichTransaction(Transaction transaction) {
        return new EnrichedTransaction(transaction.id(), transaction.cashCard(), ApprovalStatus.APPROVED,
                new CardHolderData(UUID.randomUUID(), transaction.cashCard().owner(), "123 Main street"));
    }

}
