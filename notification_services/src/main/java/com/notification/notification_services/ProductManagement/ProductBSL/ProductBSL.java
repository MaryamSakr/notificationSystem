package com.notification.notification_services.ProductManagement.ProductBSL;

import com.notification.notification_services.ProductManagement.ProductModules.Product;
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

        }return null;
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