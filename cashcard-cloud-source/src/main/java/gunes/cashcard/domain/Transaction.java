package gunes.cashcard.domain;

public record Transaction(
    Long id,
    CashCard cashCard
) {}
