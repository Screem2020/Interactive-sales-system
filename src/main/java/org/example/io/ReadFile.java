package org.example.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    private List<String> arrList = new ArrayList<>();

    public List<String> readFileForBase() {
        File file = new File("src/main/java/org/example/base/discount_day.txt");
        FileReader fileReader = null;
        try {
            String stringLine = "";
            fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            while (br.ready()) {
                stringLine = br.readLine();
                arrList.add(stringLine);
            }
            return arrList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert fileReader != null;
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}