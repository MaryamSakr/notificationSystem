
package com.notification.notification_services.notificationManagment.notificationModules.controller;

import com.notification.notification_services.notificationManagment.notificationModules.Bsl.ProductBSL;
import com.notification.notification_services.notificationManagment.notificationModules.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private ProductBSL productBsl;
    public ProductController (ProductBSL productBsl)
    {
        this.productBsl = productBsl;
    }
    @PostMapping("/product/add")
    public String addProduct (@RequestBody Product product)
    {
        return productBsl.add(product);
    }


    @GetMapping("/product/{serialNumber}")
    public Product getProduct (@PathVariable ("serialNumber")  int serialNumber)
    {
        return productBsl.getProduct(serialNumber);
    }

//    @GetMapping("/product")
//    public Product getProduct ()
//    {
//        return productBsl.getProduct();
//    }

//    @GetMapping("/product/{name}")
//    public Product getProduct (@PathVariable ("name")  String name)
//    {
//        return productBsl.getProductname(name);
//    }
}



