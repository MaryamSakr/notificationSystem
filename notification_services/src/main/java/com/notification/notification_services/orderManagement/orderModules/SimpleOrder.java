package com.notification.notification_services.orderManagement.orderModules;
import com.notification.notification_services.ProductManagement.ProductModules.Product;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrder extends Order{
    private List<String> products;
    private int customerId;
    public SimpleOrder(){
        super(0);

    }
    public SimpleOrder(int id, int customerId, List<String> products){
        super(id);
        this.customerId = customerId;
        this.products = new ArrayList<>();
        this.products = products;
    }
    public void setProducts(String product) {
        this.products.add(product);
    }
    public void setProducts(List<String> products) {
        this.products = products;
    }
    public List<String> getProducts() {
        return products;
    }
}
