package org.example.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    private List<String> arrList = new ArrayList<>();

    public List<String> readFileForBase() {
        File file = new File("src/main/java/org/example/service/discount_day.txt");
        FileReader fileReader = null;
        try {
            String s = "";
            fileReader = new FileReader(file);
            BufferedReader bf = new BufferedReader(fileReader);
            while (bf.ready()) {
                s = bf.readLine();
                arrList.add(s);
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