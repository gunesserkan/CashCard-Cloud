package com.gunes.enricher.domain;

public record CashCard(
        Long id,
        String owner,
        Double amountRequestedForAuth
){}
