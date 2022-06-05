package com.edu.app.RSD.ch02;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

@Slf4j
public class BankStatementAnalyzer {

    private static final String RESOURCES = "C:\\MyDevelop\\workspace\\SungboJavaEducation\\src\\main\\resources\\bank-data-simple.csv";

    public void analyze(final BankStatementParser bankStatementParser) throws IOException{

        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor){
        log.info("전체 거래 금액 : " +bankStatementProcessor.calculateTotalAmount());
        log.info("1월의 거래 금액 : " +bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        log.info("3월의 거래 금액 : " +bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        log.info("금여 거래 금액 : " +bankStatementProcessor.calculateTotalForCategory("Salary"));
    }

}
