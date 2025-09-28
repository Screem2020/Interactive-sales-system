package org.example.io;

import org.example.report.ByerWithReport;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {

    public void writeFileForBase(List<ByerWithReport> customerList) {
        File file = new File("src/main/java/org/example/base/discount_order_customer.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (ByerWithReport byerWithReport : customerList) {
                bufferedWriter.write(byerWithReport.getNameCompany());
                bufferedWriter.write("|");
                bufferedWriter.write(String.valueOf(byerWithReport.getPrice()));
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

