package com.edu.app.RSD.ch02;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {

        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

        // 기존 CSV 에서 JSON 포멧으로 변경된다면  BankStatementJSONParser 을 만들어서 제공하면된다.
        // 기존 코드를 최대한 건들지 않고 추가함으로써 요구사항을 해결하게 된다.
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze(bankStatementParser);


    }
}
