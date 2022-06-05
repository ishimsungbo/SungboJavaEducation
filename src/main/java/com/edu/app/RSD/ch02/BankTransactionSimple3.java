package com.edu.app.RSD.ch02;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// 리펙토링. 입출금 내역 CSV 파서 사용하기
@Slf4j
public class BankTransactionSimple3 {

    private static final String RESOURCES = "C:\\MyDevelop\\workspace\\SungboJavaEducation\\src\\main\\resources\\bank-data-simple.csv";

    public static void main(String[] args) throws IOException {

        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);

        //리펙토링
        final BankStatementCSVParser parser = new BankStatementCSVParser();
        final List<BankTransaction> bankTransactions =  parser.parseLinesFrom(lines);

        //log.info("읽어 온 값 " + bankTransactions.get(0).toString());

    }

    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions){

        double total = 0d;
        for(final BankTransaction bankTransaction : bankTransactions){
            total += bankTransaction.getAmount();
        }
        return total;
    }

    // 입출금 내역 목록 처리
    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions,
                                                      final Month month){
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for(final BankTransaction bankTransaction: bankTransactions){
            if(bankTransaction.getDate().getMonth() == month){
                bankTransactionsInMonth.add(bankTransaction);
            }
        }

        return bankTransactionsInMonth;
    }

}
