package dev.sarangan.productservicettseve.dtos;

import dev.sarangan.productservicettseve.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleProductResponseDto {
    private Product product;
}
