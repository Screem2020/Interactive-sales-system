package org.example.io;

import org.example.exception.IORuntimeException;
import org.example.report.OrderReport;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


    public List<String> readFileForBase(File file) {
        List<String> lines = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader br = new BufferedReader(fileReader)) {
            String stringLine = "";
            while (br.ready()) {
                stringLine = br.readLine();
                lines.add(stringLine);
            }
            return lines;
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    public void writeFileForBase(List<OrderReport> customerList, File file) {
        try (FileWriter fileWriter = new FileWriter(file);
            for (OrderReport orderReport : customerList) {
                bufferedWriter.write(orderReport.getNameCompany());
                bufferedWriter.write("|");
                bufferedWriter.write(String.valueOf(orderReport.getPrice()));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }
}