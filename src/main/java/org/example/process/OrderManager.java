package org.example.process;

import org.example.io.FIleUtil;
import org.example.service.OrderService;
import org.example.model.OrderReport;
import org.example.parser.OrderParser;
import org.example.model.Order;
import java.io.File;
import java.util.List;

public class OrderManager {
    public void orderManager(FIleUtil FIleUtil, OrderService orderService,OrderParser orderParser,
                             File fileWrite, File fileRead, int priceCementVal, int discountVal, int stepDiscount) {
        List<String> strings = FIleUtil.readFileForBase(fileRead);
        List<Order> orders = orderParser.OrderParsing(strings);
        List<OrderReport> priceForList = orderService.getPriceForList(orders, priceCementVal, discountVal, stepDiscount);
        FIleUtil.writeFileForBase(priceForList, fileWrite);
    }
}
