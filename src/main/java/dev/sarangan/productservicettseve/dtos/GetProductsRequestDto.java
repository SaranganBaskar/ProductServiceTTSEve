package dev.sarangan.productservicettseve.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductsRequestDto {
    private int numberOfResults;
    private int offset;
    private String titleQuery;
}
