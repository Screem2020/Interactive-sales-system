package org.example.manager;

import org.example.io.FileUtil;
import org.example.model.Order;
import org.example.model.OrderReport;
import org.example.parser.OrderRegister;
import org.example.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderManagerTest {
    @Mock
    private FileUtil fileUtil;
    @Mock
    private OrderRegister orderRegister;
    @Mock
    private OrderService orderService;
    @InjectMocks
    private OrderManager orderManager;
    @Captor
    private ArgumentCaptor<List<OrderReport>> captor;

    @Test
    void testProcess() {
        File fileRead = new File("BaseIN.txt");
        File fileWrite = new File("BaseOut.txt");

        List<String> strings = List.of("2021-02-09T16:00:22#Industrial#8800");
        List<Order> orders = List.of(
                new Order("Industrial", 1000, LocalDateTime.of(2021, 2, 9, 16, 0)));
        List<OrderReport> reportsList = List.of(
                new OrderReport("Industrial", 25000.0));

        when(fileUtil.readFileForBase(fileRead)).thenReturn(strings);
        when(orderService.getPriceForList(orders, 10, 50, 5)).thenReturn(reportsList);
        when(orderRegister.registrCheckOrderParser(fileRead, strings)).thenReturn(orders);

        orderManager.process(fileWrite, fileRead, 10, 50, 5);

        verify(fileUtil).readFileForBase(fileRead);
        verify(orderRegister).registrCheckOrderParser(fileRead, strings);
        verify(orderService).getPriceForList(orders, 10, 50, 5);
        verify(fileUtil).writeFileForBase(captor.capture(), eq(fileWrite));

        assertEquals(reportsList, captor.getValue());
    }
}