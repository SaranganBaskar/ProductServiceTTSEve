package dev.sarangan.productservicettseve.dtos;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {
    @Nullable
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    @Nullable
    private RatingDto ratingDto;
}
