package com.gunes.enricher.enricher;


import com.gunes.enricher.service.EnrichmentService;
import gunes.domain.EnrichedTransaction;
import gunes.domain.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class CashCardTransactionEnricher {

    @Bean
    public EnrichmentService enrichmentService() {
        return new EnrichmentService();
    }

    @Bean
    public Function<Transaction, EnrichedTransaction> enrichTransaction(EnrichmentService enrichmentService) {
        return transaction -> {
            return enrichmentService.enrichTransaction(transaction);
        };
    }
}
