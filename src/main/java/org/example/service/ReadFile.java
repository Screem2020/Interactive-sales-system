package org.example.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    private List<String> arr = new ArrayList<>();

    public List<String> readFileForBase() {
        File file = new File("src/main/java/org/example/service/CustomerBase");
        FileReader fileReader = null;
        {
            try {
                fileReader = new FileReader(file);
                try {
                    int readInt = 0;
                    while ((readInt = fileReader.read()) != -1) {
                        arr.add(String.valueOf((char)readInt));
                    }
                    return arr;
                } finally {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "ReadFile{" +
                "arr=" + arr +
                '}';
    }
}