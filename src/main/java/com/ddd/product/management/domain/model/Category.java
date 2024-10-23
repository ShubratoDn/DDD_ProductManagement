package com.ddd.product.management.domain.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    @JsonIgnore
	public List<Product> getProducts() {
		return products;
	}

    @JsonProperty
	public void setProducts(List<Product> products) {
		this.products = products;
	}    
    
}
