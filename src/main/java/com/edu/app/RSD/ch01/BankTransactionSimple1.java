package com.edu.app.RSD.ch01;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
public class BankTransactionSimple1 {

    private static final String RESOURCES = "C:\\MyDevelop\\workspace\\SungboJavaEducation\\src\\main\\resources\\bank-data-simple.csv";

    public static void main(String[] args) throws IOException {

        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;

        DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for(final String line : lines){
            String[] colums = line.split(",");

            LocalDate date = LocalDate.parse(colums[0], DATE_PATTERN);

            if(date.getMonth() == Month.JANUARY){  // 1월의 입출금만 추출
                double amount = Double.parseDouble(colums[1]);
                total += amount;
            }

        }
        log.info("2. 1월의 입출금 내역 :  " + total);
    }
}
