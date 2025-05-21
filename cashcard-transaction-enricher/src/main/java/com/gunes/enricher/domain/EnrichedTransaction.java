package com.gunes.enricher.domain;

public record EnrichedTransaction(Long id,
                                  CashCard cashCard,
                                  ApprovalStatus approvalStatus,
                                  CardHolderData cardHolderData) {
}
