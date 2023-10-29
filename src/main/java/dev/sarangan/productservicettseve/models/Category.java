package dev.sarangan.productservicettseve.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
    private String description;
    /*C : P
      1 : M
      1 : 1
    ----------
      1 : M (On the M side, create the relation of the other side)
    */
    @OneToMany(mappedBy = "category")
    private List<Product> productList;
}
