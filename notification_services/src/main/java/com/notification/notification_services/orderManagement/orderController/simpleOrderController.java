package com.notification.notification_services.orderManagement.orderController;
import com.notification.notification_services.orderManagement.orderBsl.SimpleOrderBsl;
import com.notification.notification_services.orderManagement.orderModules.Order;
import com.notification.notification_services.orderManagement.orderModules.SimpleOrder;
import org.springframework.web.bind.annotation.*;

@RestController
public class simpleOrderController {
    private SimpleOrderBsl simpleOrderBsl;
    simpleOrderController(SimpleOrderBsl simpleOrderBsl){
        this.simpleOrderBsl=simpleOrderBsl;
    }
    @PostMapping("/simpleOrder/add")
    public String addSimpleOrder(@RequestBody SimpleOrder order){
        return simpleOrderBsl.addOrder(order);
    }

    @GetMapping("/order/{id}")
    public Order getOrder (@PathVariable("id")  int id) {
        return simpleOrderBsl.display(id);
    }
    @DeleteMapping("/order/{id}")
    public String deleteOrder (@PathVariable("id")  int id) {
        return simpleOrderBsl.cancelOrder(id);
    }
}
