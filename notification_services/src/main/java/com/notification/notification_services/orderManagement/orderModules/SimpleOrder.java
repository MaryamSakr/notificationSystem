package com.notification.notification_services.orderManagement.orderModules;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import java.util.List;

public class SimpleOrder extends Order{
    private List<Product> products;
    private int customerId;
    public SimpleOrder(){
        super(0);

    }
    public SimpleOrder(int id, int customerId, List<Product> products){
        super(id);
        this.customerId = customerId;
        this.products = products;
    }
    public void setProducts(Product product) {
        this.products.add(product);
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public List<Product> getProducts() {
        return products;
    }
}
