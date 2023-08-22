package com.MRajApp.MRajeshApp.DAO;

import com.MRajApp.MRajeshApp.Model.Variant;

import java.util.List;

public interface VariantService {
    Variant saveVariant(Variant variant);

    List<Variant> fetchVariantList();

    void deleteVariantBySkuId(Long variantId);

}
