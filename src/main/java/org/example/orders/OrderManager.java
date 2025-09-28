package org.example.orders;

import org.example.price.PriceManager;
import org.example.report.ByerWithReport;
import org.example.parseStringForBase.ParseStringOrder;
import org.example.io.ReadFile;
import org.example.io.WriteFile;
import org.example.сustomer.Customer;
import java.util.List;

public class OrderManager {
    public void orderManager() {
        ReadFile readFile = new ReadFile();
        PriceManager priceManager = new PriceManager();
        ParseStringOrder parseStringOrder = new ParseStringOrder();
        WriteFile writeFile = new WriteFile();

        List<String> strings = readFile.readFileForBase();
        List<Customer> customers = parseStringOrder.OrderParsing(strings);
        List<ByerWithReport> priceForList = priceManager.getPriceForList(customers);
        writeFile.writeFileForBase(priceForList);
    }
}
