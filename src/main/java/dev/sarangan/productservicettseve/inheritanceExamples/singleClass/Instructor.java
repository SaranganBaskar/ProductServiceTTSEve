package dev.sarangan.productservicettseve.inheritanceExamples.singleClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "sc_instructor")
@DiscriminatorValue("3")
public class Instructor extends ScUser {
    private boolean isHandSome;
}
