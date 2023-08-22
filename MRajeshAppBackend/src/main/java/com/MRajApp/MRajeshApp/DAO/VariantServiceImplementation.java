package com.MRajApp.MRajeshApp.DAO;

import com.MRajApp.MRajeshApp.Model.Variant;
import com.MRajApp.MRajeshApp.Repo.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VariantServiceImplementation implements VariantService {
    @Autowired
    private VariantRepository variantRepository;

    @Override
    public Variant saveVariant(Variant variant) {
        return variantRepository.save(variant);
    }

    @Override
    public List<Variant> fetchVariantList() {
        return (List<Variant>)variantRepository.findAll();
    }

    @Override
    public void deleteVariantBySkuId(Long variantId) {
        variantRepository.deleteById(variantId);
    }

}
