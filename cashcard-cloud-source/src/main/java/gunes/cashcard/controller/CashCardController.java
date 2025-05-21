package gunes.cashcard.controller;


import gunes.cashcard.domain.Transaction;
import gunes.cashcard.stream.CashCardStream;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashCardController {

    private CashCardStream cashCardStream;

    public CashCardController(CashCardStream cashCardStream) {
        this.cashCardStream = cashCardStream;
    }

    @PostMapping(path = "/publish/txn")
    public void publishTxn(@RequestBody Transaction transaction){
        System.out.println("POST for Transaction "+transaction);
    }
}
