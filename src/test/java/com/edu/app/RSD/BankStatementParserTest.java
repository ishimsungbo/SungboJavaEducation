package com.edu.app.RSD;

import com.edu.app.RSD.ch02.BankStatementCSVParser;
import com.edu.app.RSD.ch02.BankStatementParser;

import com.edu.app.RSD.ch02.BankTransaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BankStatementParserTest {

    private final BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParserOneCorrectLine() throws Exception{
        final String line = "30-01-2017,-50,Tesco";
        final BankTransaction result = statementParser.parseFrom(line);

        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30),-50,"Tesco");
        final double tolerance = 0.0d;

        assertEquals(expected.getDate(), result.getDate());
        assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        assertEquals(expected.getDescription(),result.getDescription());
        //assertEquals(expected.getDescription(),"Testccc");
    }

}
