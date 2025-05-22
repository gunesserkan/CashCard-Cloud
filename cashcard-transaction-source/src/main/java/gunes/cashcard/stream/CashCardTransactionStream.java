package gunes.cashcard.stream;

import gunes.cashcard.service.DataSourceService;
import gunes.domain.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class CashCardTransactionStream {


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

}
