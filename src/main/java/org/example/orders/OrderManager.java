package org.example.orders;

import org.example.price.PriceManager;
import org.example.report.ByerWithReport;
import org.example.service.ParseStringOrder;
import org.example.service.ReadFile;
import org.example.service.WriteFile;
import org.example.сustomer.Customer;
import java.util.List;

public class OrderManager {
    public void orderManager() {
        ReadFile readFile = new ReadFile();
        ParseStringOrder parseStringOrder = new ParseStringOrder();
        List<String> strings = readFile.readFileForBase();
        OrdersBase ordersBase = new OrdersBase();
        List<Customer> arrayListCustomers = ordersBase.getArrayListCustomers();
        for (String customer : strings) {
            arrayListCustomers.add(parseStringOrder.OrderParsing(customer));
        }
        PriceManager priceManager = new PriceManager();
        List<ByerWithReport> priceForList = priceManager.getPriceForList(arrayListCustomers);
        WriteFile writeFile = new WriteFile();
        writeFile.writeFileForBase(priceForList);
    }
}
