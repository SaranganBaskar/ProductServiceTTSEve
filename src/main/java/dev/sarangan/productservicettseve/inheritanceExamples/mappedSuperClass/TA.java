package dev.sarangan.productservicettseve.inheritanceExamples.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_ta")
public class TA extends User {
    private double averageRating;
}
