package gunes.domain;

public record CashCard(
        Long id,
        String owner,
        Double amountRequestedForAuth
){}
