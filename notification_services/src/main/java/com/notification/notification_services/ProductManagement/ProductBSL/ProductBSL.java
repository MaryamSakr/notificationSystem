package com.notification.notification_services.ProductManagement.ProductBSL;

import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.inMemory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class ProductBSL {
    private final List<Product> productTable;
    public ProductBSL()
    {
        this.productTable = new ArrayList<>();
    }

    public String addProduct(Product product)
    {
        for (Product product1 : inMemory.products){
            if(product.getName().equals(product1.getName())){
                return "this product is already exist";
            }
        }
        inMemory.products.add(product);
        return "Added successfully";
    }

    // Search for products in inMemory based on serialNumber
    public  Product searchProduct(int serialno) {
        for (Product product : inMemory.products) {
            if (product.getSerialNumber() == serialno) {
                return product;
            }
        }
        return null; // if Product not found
    }
}