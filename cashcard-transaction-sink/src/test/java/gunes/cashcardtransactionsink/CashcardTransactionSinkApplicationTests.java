package gunes.cashcardtransactionsink;

import gunes.domain.*;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.time.Duration;
import java.util.UUID;
import java.io.IOException;


@Import(TestChannelBinderConfiguration.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class CashcardTransactionSinkApplicationTests {

    private static final int AWAIT_DURATION = 10;


    @Test
    void cashCardSinkToConsole(@Autowired InputDestination inputDestination, CapturedOutput output) throws IOException {

        Transaction transaction = new Transaction(1L, new CashCard(123L, "Kumar Patel", 1.00));
        EnrichedTransaction enrichedTransaction = new EnrichedTransaction(
                transaction.id(),
                transaction.cashCard(),
                ApprovalStatus.APPROVED,
                new CardHolderData(UUID.randomUUID(), transaction.cashCard().owner(), "123 Main Street"));

        Message<EnrichedTransaction> message = MessageBuilder.withPayload(enrichedTransaction).build();
        inputDestination.send(message, "sinkToConsole-in-0");

        Awaitility.await().atMost(Duration.ofSeconds(AWAIT_DURATION))
                .until(() -> output.toString().contains("Transaction Received: " + enrichedTransaction.toString()));
    }

    @SpringBootApplication
    public static class App {

    }

}
