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

    public String add(Product product)
    {
        for (Product productDb :productTable )
        {
            if (productDb.getSerialNumber() == product.getSerialNumber())
            {
                return "exist";
            }

        }productTable.add(product);
        return "done";
    }

    public Product getProduct(int serialNumber)
    {
        for (Product productDb :productTable )
        {

            if (productDb.getSerialNumber() == serialNumber)
            {
                return productDb;
            }

        }
        return null;
    }

    public String addProduct(Product product)
    {
        inMemory.products.add(product);
        return "done";
    }

    // Search for a product in the inMemory class based on some criteria
    public  Product searchProduct(int serialno) {
        for (Product product : inMemory.products) {
            if (product.getSerialNumber() == serialno) {
                return product;
            }
        }
        return null; // Product not found
    }


    public Product getProductname(String name)
    {
        for (Product productDb :productTable )
        {
            if (productDb.getName() == name)
            {
                return productDb;
            }

        }return null;
    }
}







//        for (int i = 0; i < Customer.customers.size(); i++){
//            Customer found = Customer.customers.get(i);
//            if(companyName.equals(found.getUserName())){
//                Customer receiverCompany =found;
//                receiverCompany.deposit(toPay);
//                return true;
//            }
//        for (int i=0; i < )
//
//        {
//            if (db.equals(serialNumber))
//            {
//                return db;
//            }
//        }