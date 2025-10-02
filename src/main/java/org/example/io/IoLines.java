package org.example.io;

import org.example.report.ByerWithReport;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IoLines {

    private List<String> arrList = new ArrayList<>();

    public List<String> readFileForBase() {
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

    public void writeFileForBase(List<ByerWithReport> customerList) {
        File file = new File("src/main/java/org/example/base/discount_order_customer.txt");
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            for (ByerWithReport byerWithReport : customerList) {
                bufferedWriter.write(byerWithReport.getNameCompany());
                bufferedWriter.write("|");
                bufferedWriter.write(String.valueOf(byerWithReport.getPrice()));
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}