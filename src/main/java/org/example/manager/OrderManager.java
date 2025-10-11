package org.example.manager;

import org.example.io.FIleUtil;
import org.example.parser.OrderParserRegister;
import org.example.service.OrderService;
import org.example.model.OrderReport;
import org.example.model.Order;
import java.io.File;
import java.util.List;

public class OrderManager {
    private final FIleUtil fIleUtil;
    private final OrderService orderService;
    private final OrderParserRegister orderParserRegister;

    public OrderManager(FIleUtil fIleUtil, OrderService orderService, OrderParserRegister orderParserRegister) {
        this.fIleUtil = fIleUtil;
        this.orderService = orderService;
        this.orderParserRegister = orderParserRegister;
    }

    public void process(File fileWrite, File fileRead, int priceCementVal, int discountVal, int stepDiscount) {
        List<String> strings = fIleUtil.readFileForBase(fileRead);
        List<Order> orders = orderParserRegister.registrCheck(fileRead, strings);
        List<OrderReport> priceForList = orderService.getPriceForList(orders, priceCementVal, discountVal, stepDiscount);
        fIleUtil.writeFileForBase(priceForList, fileWrite);
    }
}
