package com.MRajApp.MRajeshApp.Repo;
import com.MRajApp.MRajeshApp.Model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
}