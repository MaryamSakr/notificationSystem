package com.notification.notification_services.ProductManagement.ProductController;

import com.notification.notification_services.ProductManagement.ProductBSL.ProductBSL;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    public ProductBSL productBsl;

    public ProductController (ProductBSL productBsl)
    {
        this.productBsl = productBsl;
    }
    @PostMapping("/product/add")
    public String addProduct (@RequestBody Product product)
    {
        return productBsl.add(product);
    }
    @PostMapping("/product/addd")
    public String addProductt (@RequestBody Product product)
    {
        return productBsl.addProduct(product);
    }

    @GetMapping("/product/{serialNumber}")
    public Product getProduct (@PathVariable ("serialNumber")  int serialNumber)
    {
        return productBsl.getProduct(serialNumber);
    }
    @GetMapping("/product/search/{serialNumber}")
    public Product searchProduct (@PathVariable ("serialNumber")  int serialNumber)
    {
        return productBsl.searchProduct(serialNumber);
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