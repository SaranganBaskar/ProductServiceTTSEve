package dev.sarangan.productservicettseve.models;

import java.util.List;

public class Category extends BaseModel {
    private String name;
    private String description;
    private List<Product> productList;
}