package org.example.io;

import org.example.exception.IORuntimeException;
import org.example.model.OrderReport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {
    private FileUtil fileUtil = new FileUtil();

    @Test
    void readLineCorrectForBase() throws IOException {
        File tempFile = File.createTempFile("test", ".txt").toPath().toFile();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))) {
            bufferedWriter.write("line1" + "\n");
        }

        List<String> strings = fileUtil.readFileForBase(tempFile);
        String actualString = strings.get(0);
        String expectedString = "line1";

        assertEquals(expectedString, actualString);
        assertEquals(1, strings.size());
        tempFile.deleteOnExit();
    }

    @Test
    void readLineEmptyForBase() throws IOException {
        File tempFile = File.createTempFile("test", ".txt").toPath().toFile();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))) {
            bufferedWriter.write("");
        }

        List<String> strings = fileUtil.readFileForBase(tempFile);

        assertTrue(strings.isEmpty());
        tempFile.deleteOnExit();
    }

    @Test
    void readLineEmptyPrefixFile() throws IOException {
        File tempFile = File.createTempFile("test", "").toPath().toFile();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))) {
            bufferedWriter.write("line");
        }
        List<String> strings = fileUtil.readFileForBase(tempFile);

        Assertions.assertEquals("line", strings.get(0));
        tempFile.deleteOnExit();
    }

    @Test
    void readLineTrowsException() {
        File nonExistFile = new File("test");
        assertThrows(IORuntimeException.class, () -> fileUtil.readFileForBase(nonExistFile));
    }

    @Test
    void writeCorrectFileForBase() {
        File file = new File("test.txt");
        OrderReport order = new OrderReport("test", 100);

        fileUtil.writeFileForBase(List.of(order), file);
        OrderReport expectedOrderReport = new OrderReport("test", 100);
        String actualOrderReport = order.toString();

        Assertions.assertTrue(file.exists());
        Assertions.assertEquals("test.txt", file.getName());
        Assertions.assertEquals(expectedOrderReport.toString(), actualOrderReport);
        file.deleteOnExit();
    }
    @Test
    void writeEmptyLineInFile() {
        File file = new File("test.txt");
        OrderReport order = new OrderReport("", 0);

        fileUtil.writeFileForBase(List.of(order), file);
        OrderReport expectedOrderReport = new OrderReport("", 0);
        String actualOrderReport = order.toString();

        Assertions.assertEquals(expectedOrderReport.toString(), actualOrderReport);
        file.deleteOnExit();
    }

    @Test
    void writeNullLineInFile(){
        File file = new File("test.txt");
        List<OrderReport> orders = new ArrayList<>();
        orders.add(null);

        Assertions.assertDoesNotThrow(() -> fileUtil.writeFileForBase(orders, file));
        file.deleteOnExit();
    }

    @Test
    void writeThrowIORuntimeExceptionLine() {
        File file = new File("/root/test.txt");
        List<OrderReport> orders = List.of(new OrderReport("line", 10));

        Assertions.assertThrows(IORuntimeException.class, () -> fileUtil.writeFileForBase(orders, file));
        file.deleteOnExit();
    }

}
