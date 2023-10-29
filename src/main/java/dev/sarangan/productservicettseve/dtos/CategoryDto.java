package dev.sarangan.productservicettseve.dtos;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryDto {
    @Nullable
    private Long id;
    private String categoryName;
    private String CategoryDescription;

}
