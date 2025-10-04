package org.example.orders;

import org.example.price.PriceManager;
import org.example.report.OrderReport;
import org.example.parseStringForBase.OrderParser;
import org.example.io.IoLines;
import org.example.сustomer.Customer;
import java.util.List;

public class OrderManager {
    public void orderManager() {
        IoLines IoLines = new IoLines();
        PriceManager priceManager = new PriceManager();
        OrderParser orderParser = new OrderParser();

        List<String> strings = IoLines.readFileForBase();
        List<Customer> customers = orderParser.OrderParsing(strings);
        List<OrderReport> priceForList = priceManager.getPriceForList(customers);
        IoLines.writeFileForBase(priceForList);
    }
}
