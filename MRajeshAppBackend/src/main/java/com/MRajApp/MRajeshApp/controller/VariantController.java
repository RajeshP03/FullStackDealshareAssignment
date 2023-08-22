package com.MRajApp.MRajeshApp.controller;

import com.MRajApp.MRajeshApp.Model.Variant;
import com.MRajApp.MRajeshApp.DAO.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class VariantController {
    @Autowired
    private VariantService variantService;

    @PostMapping("/save-variant")
    public Variant saveVariant(@RequestBody Variant variant) {
        return variantService.saveVariant(variant);
    }

    @GetMapping("/get-variant")
    public List<Variant> fetchVariantList() {
        return variantService.fetchVariantList();
    }

}
