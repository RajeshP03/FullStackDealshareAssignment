package com.MRajApp.MRajeshApp.DAO;
import com.MRajApp.MRajeshApp.Model.Product;
import com.MRajApp.MRajeshApp.Repo.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplementation implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchProductList() {
        return (List<Product>)productRepository.findAll();
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }
    @Override
    public List<Product> fetchProductAllList() {
        return (List<Product>)productRepository.findAll();
    }
    @Override
    public List<Product> fetchProductListByCI(Long productCategoryID){
         List<Product> allProducts = (List<Product>)productRepository.findAll();
         List<Product> idProduct = new ArrayList<Product>();
         for(Product product: allProducts){
             if(Objects.equals(productCategoryID, product.getPoductCategoryId())) {
                 idProduct.add(product);
             }
         }
         return idProduct;
    }
}