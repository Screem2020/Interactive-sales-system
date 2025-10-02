package org.example.orders;

import org.example.price.PriceManager;
import org.example.report.ByerWithReport;
import org.example.parseStringForBase.ParseStringOrder;
import org.example.io.IoLines;
import org.example.сustomer.Customer;
import java.util.List;

public class OrderManager {
    public void orderManager() {
        IoLines IoLines = new IoLines();
        PriceManager priceManager = new PriceManager();
        ParseStringOrder parseStringOrder = new ParseStringOrder();

        List<String> strings = IoLines.readFileForBase();
        List<Customer> customers = parseStringOrder.OrderParsing(strings);
        List<ByerWithReport> priceForList = priceManager.getPriceForList(customers);
        IoLines.writeFileForBase(priceForList);
    }
}
