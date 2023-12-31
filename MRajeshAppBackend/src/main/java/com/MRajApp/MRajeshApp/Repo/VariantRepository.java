package com.MRajApp.MRajeshApp.Repo;

import com.MRajApp.MRajeshApp.Model.Category;
import com.MRajApp.MRajeshApp.Model.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Long> {
}
