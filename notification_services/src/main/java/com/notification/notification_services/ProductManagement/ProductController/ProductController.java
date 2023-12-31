package com.notification.notification_services.ProductManagement.ProductController;

import com.notification.notification_services.ProductManagement.ProductBSL.ProductBSL;
import com.notification.notification_services.ProductManagement.ProductModules.Product;
import com.notification.notification_services.inMemory;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
public class ProductController {
    public ProductBSL productBsl;

    public ProductController (ProductBSL productBsl)
    {
        this.productBsl = productBsl;
    }

    @PostMapping("/product/addInMemory")
    public String addProducttnMemory (@RequestBody Product product)
    {
        return productBsl.addProduct(product);
    }
    @GetMapping("/product/search/{serialNumber}")
    public Product searchProduct (@PathVariable ("serialNumber")  int serialNumber)
    {
        return productBsl.searchProduct(serialNumber);
    }
    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        return inMemory.products;
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


}
