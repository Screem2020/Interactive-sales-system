package org.example.process;

import org.example.io.FIleUtil;
import org.example.service.OrderService;
import org.example.model.OrderReport;
import org.example.parser.OrderParser;
import org.example.model.Order;
import java.io.File;
import java.util.List;

public class OrderManager {
    private final FIleUtil fIleUtil;
    private final OrderService orderService;
    private final OrderParser orderParser;

    public OrderManager(FIleUtil fIleUtil, OrderService orderService, OrderParser orderParser) {
        this.fIleUtil = fIleUtil;
        this.orderService = orderService;
        this.orderParser = orderParser;
    }

    public void orderManager(File fileWrite, File fileRead, int priceCementVal, int discountVal, int stepDiscount) {
        List<String> strings = fIleUtil.readFileForBase(fileRead);
        List<Order> orders = orderParser.OrderParsing(strings);
        List<OrderReport> priceForList = orderService.getPriceForList(orders, priceCementVal, discountVal, stepDiscount);
        fIleUtil.writeFileForBase(priceForList, fileWrite);
    }
}
