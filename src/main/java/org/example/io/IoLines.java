package org.example.io;

import org.example.report.OrderReport;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IoLines {

    public List<String> readFileForBase() {
        List<String> arrList = new ArrayList<>();
        File file = new File("src/main/java/org/example/base/discount_day.txt");
        try(FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader)) {
            String stringLine = "";
            while (br.ready()) {
                stringLine = br.readLine();
                arrList.add(stringLine);
            }
            return arrList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFileForBase(List<OrderReport> customerList) {
        File file = new File("src/main/java/org/example/base/discount_order_customer.txt");
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            for (OrderReport orderReport : customerList) {
                bufferedWriter.write(orderReport.getNameCompany());
                bufferedWriter.write("|");
                bufferedWriter.write(String.valueOf(orderReport.getPrice()));
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}