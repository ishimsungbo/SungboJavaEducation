package com.edu.app.RSD.ch01;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
public class BankTransactionSimple1 {

    private static final String RESOURCES = "C:\\MyDevelop\\workspace\\SungboJavaEducation\\src\\main\\resources\\bank-data-simple.csv";

    public static void main(String[] args) throws IOException {

        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for(final String line : lines){
            String[] colums = line.split(",");
            double amount = Double.parseDouble(colums[1]);
            total += amount;
        }
        log.info("The total for all transaction is " + total);
    }
}
