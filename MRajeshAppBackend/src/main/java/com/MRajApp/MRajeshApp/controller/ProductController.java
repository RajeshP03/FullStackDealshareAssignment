package com.MRajApp.MRajeshApp.controller;
import com.MRajApp.MRajeshApp.Model.Product;
import com.MRajApp.MRajeshApp.DAO.ProductService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired private ProductService productService;

    @PostMapping("/save-product")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/get-products")
    public List<Product> fetchProductList() {
        return productService.fetchProductList();
    }
    //for getting product by categoryID
    @GetMapping("/products/{id}")
    public List<Product> fetchProductListByCI(@PathVariable("id") Long productCategoryID) {
        return productService.fetchProductListByCI(productCategoryID);
    }
    @GetMapping("/products/0")
    public List<Product> fetchProductAllList() {
        return productService.fetchProductAllList();
    }
    @DeleteMapping("products/{id}")
    public String deleteProductById(@PathVariable("id") Long productId) {
        productService.deleteProductById(productId);
        return "Delete Operation Successful!";
    }
}