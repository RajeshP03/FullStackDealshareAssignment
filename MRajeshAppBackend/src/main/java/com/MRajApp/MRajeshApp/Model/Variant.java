package com.MRajApp.MRajeshApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long variantId;
    private String sku;
    private String name;
    private Long Price;
    private Long product_id;
    private String image_url1;
    private String image_url2;
    private String image_url3;

    private Long quantity;


}
