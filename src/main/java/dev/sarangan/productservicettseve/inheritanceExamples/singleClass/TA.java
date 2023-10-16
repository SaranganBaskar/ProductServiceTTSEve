package dev.sarangan.productservicettseve.inheritanceExamples.singleClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "sc_ta")
@DiscriminatorValue("1")
public class TA extends ScUser {
    private double averageRating;
}
