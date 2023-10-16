package dev.sarangan.productservicettseve.inheritanceExamples.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_ta")
public class TpcTA extends TpcUser {
    private double averageRating;
}
