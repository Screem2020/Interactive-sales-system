package org.example.parser;

import org.example.model.Order;

import java.io.File;
import java.util.List;

public class OrderParserRegister {

    public List<Order> registrCheck(File fileRead, List<String> stringList) {
        String[] split = fileRead.getName().split("\\.");
        return split.length > 1 ? new StringOrderParser().txtOrderParsing(stringList) : new StringOrderParser().noneOrderParsing(stringList);
    }
}
