package com.MRajApp.MRajeshApp.DAO;
import com.MRajApp.MRajeshApp.Model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> fetchProductList();
    List<Product> fetchProductAllList();

    void deleteProductById(Long productId);
    public List<Product> fetchProductListByCI(Long productCategoryID);
}