package com.notification.notification_services.orderManagement.orderModules;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
@Getter
public class SimpleOrder extends Order{
    private List<Product> products;

    public SimpleOrder(String customerName, int totalPrice, int shipFees, List<Product> products) {
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.shipFees = shipFees;
        this.products = products;
    }

    public SimpleOrder() {
        super();
    }
    public void setProducts(List<Product> products) {
        this.products = (products != null) ? new ArrayList<>(products) : new ArrayList<>();
    }



}
