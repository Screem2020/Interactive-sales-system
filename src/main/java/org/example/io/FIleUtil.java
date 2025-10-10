package org.example.io;

import org.example.exception.IORuntimeException;
import org.example.model.Order;
import org.example.model.OrderReport;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FIleUtil {
    public List<String> readFileForBase(File file) {
        ArrayList<String> lines = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String stringLine;
            while (bufferedReader.ready()) {
                stringLine = bufferedReader.readLine();
                lines.add(stringLine);
            }
            return lines;
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    public void writeFileForBase(List<OrderReport> orderReportList, File file) {
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (OrderReport order : orderReportList) {
                bufferedWriter.write(order.toString());
            }
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }
}
