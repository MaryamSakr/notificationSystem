package com.notification.notification_services.orderManagement.orderController;
import com.notification.notification_services.orderManagement.orderBsl.CompoundOrderBsl;
import com.notification.notification_services.orderManagement.orderModules.CompoundOrder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CompoundOrderController {
    private CompoundOrderBsl compoundOrderBsl = new CompoundOrderBsl();
    @PostMapping("/compoundOrder/add")
    public String addSimpleOrder(@RequestBody CompoundOrder order){
        return compoundOrderBsl.addOrder(order);
    }
}
