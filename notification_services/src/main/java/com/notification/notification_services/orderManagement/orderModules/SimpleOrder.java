package com.notification.notification_services.orderManagement.orderModules;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
<<<<<<< HEAD
import lombok.Getter;
=======

>>>>>>> e2e9aec172082c7213142bcd70b6677aebdae11f
import java.util.ArrayList;
import java.util.List;
@Getter
public class SimpleOrder extends Order{
<<<<<<< HEAD
    private List<Product> products;
    private String customerName;
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

    public void setCustomerId(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
=======
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
>>>>>>> e2e9aec172082c7213142bcd70b6677aebdae11f
    }
}
