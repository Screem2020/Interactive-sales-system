package org.example.parser;

import org.example.model.Order;
import java.io.File;
import java.util.List;

public class OrderRegister {

    public List<Order> registrCheck(File fileRead, List<String> stringList) {
        String[] split = fileRead.getName().split("\\.");
        return split.length > 1 ? new TxtOrderParsing().parse(stringList) : new NoneExtensionOrderParser().parse(stringList);
    }
}
