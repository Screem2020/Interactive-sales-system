package org.example.process;

import org.example.service.OrderService;
import org.example.report.OrderReport;
import org.example.parseStringForBase.OrderParser;
import org.example.io.IoLines;
import org.example.сustomer.Order;
import java.io.File;
import java.util.List;

public class OrderManager {
    public void orderManager(File fileWrite, File fileRead, int priceCementVal, int discountVal, int packCement, int stepDiscount) {
        IoLines IoLines = new IoLines();
        OrderService orderService = new OrderService();
        OrderParser orderParser = new OrderParser();

        List<String> strings = IoLines.readFileForBase(fileRead);
        List<Order> orders = orderParser.OrderParsing(strings);
        List<OrderReport> priceForList = orderService.getPriceForList(orders, priceCementVal, discountVal, packCement, stepDiscount);
        IoLines.writeFileForBase(priceForList, fileWrite);
    }
}
