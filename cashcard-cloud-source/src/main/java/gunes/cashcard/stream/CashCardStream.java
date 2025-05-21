package gunes.cashcard.stream;

import gunes.cashcard.domain.Transaction;
import gunes.cashcard.service.DataSourceService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class CashCardStream {

    private final StreamBridge streamBridge;

    public CashCardStream(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Bean
    public Supplier<Transaction> approvalRequest(DataSourceService dataSource){
        return ()->{
            return dataSource.getData();
        };
    }

    @Bean
    public DataSourceService dataSourceService(){
        return new DataSourceService();
    }

    public void publishOnDemand(Transaction transaction){
        this.streamBridge.send("approval-request-out-0", transaction);
    }
}
