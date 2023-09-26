package dev.sarangan.productservicettseve.dtos;

import dev.sarangan.productservicettseve.models.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class productDto {
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
}
