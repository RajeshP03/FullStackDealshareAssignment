package com.MRajApp.MRajeshApp.Repo;

import com.MRajApp.MRajeshApp.Model.Category;
import com.MRajApp.MRajeshApp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
