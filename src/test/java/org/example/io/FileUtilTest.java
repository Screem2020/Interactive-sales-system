package org.example.io;

import org.example.exception.IORuntimeException;
import org.example.model.OrderReport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {
    private FileUtil fileUtil = new FileUtil();
    private File tempFile;

    @AfterEach
    void tearDOwn(){
        tempFile.deleteOnExit();
    }
    @Test
    void readLineCorrectForBase() throws IOException {
        tempFile = File.createTempFile("test", ".txt").toPath().toFile();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))) {
            bufferedWriter.write("line1" + "\n");
        }

        List<String> strings = fileUtil.readFileForBase(tempFile);
        String actualString = strings.get(0);
        String expectedString = "line1";

        assertEquals(expectedString, actualString);
        assertEquals(1, strings.size());

    }

    @Test
    void readLineEmptyForBase() throws IOException {
        tempFile = File.createTempFile("test", ".txt").toPath().toFile();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))) {
            bufferedWriter.write("");
        }

        List<String> strings = fileUtil.readFileForBase(tempFile);

        assertTrue(strings.isEmpty());
    }

    @Test
    void readLineEmptyPrefixFile() throws IOException {
        tempFile = File.createTempFile("test", "").toPath().toFile();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))) {
            bufferedWriter.write("line");
        }
        List<String> strings = fileUtil.readFileForBase(tempFile);

        Assertions.assertEquals("line", strings.get(0));
    }

    @Test
    void readLineTrowsException() {
        tempFile = new File("test");
        assertThrows(IORuntimeException.class, () -> fileUtil.readFileForBase(tempFile));
    }

    @Test
    void writeCorrectFileForBase() {
        tempFile = new File("test.txt");
        OrderReport order = new OrderReport("test", 100);

        fileUtil.writeFileForBase(List.of(order), tempFile);
        OrderReport expectedOrderReport = new OrderReport("test", 100);
        String actualOrderReport = order.toString();

        Assertions.assertTrue(tempFile.exists());
        Assertions.assertEquals("test.txt", tempFile.getName());
        Assertions.assertEquals(expectedOrderReport.toString(), actualOrderReport);
    }
    @Test
    void writeEmptyLineInFile() {
        tempFile = new File("test.txt");
        OrderReport order = new OrderReport("", 0);

        fileUtil.writeFileForBase(List.of(order), tempFile);
        OrderReport expectedOrderReport = new OrderReport("", 0);
        String actualOrderReport = order.toString();

        Assertions.assertEquals(expectedOrderReport.toString(), actualOrderReport);
    }

    @Test
    void writeNullLineInFile(){
        tempFile = new File("test.txt");
        List<OrderReport> orders = new ArrayList<>();
        orders.add(null);

        Assertions.assertDoesNotThrow(() -> fileUtil.writeFileForBase(orders, tempFile));
    }

    @Test
    void writeThrowIORuntimeExceptionLine() {
        tempFile = new File("/root/test.txt");
        List<OrderReport> orders = List.of(new OrderReport("line", 10));

        Assertions.assertThrows(IORuntimeException.class, () -> fileUtil.writeFileForBase(orders, tempFile));
    }
}
