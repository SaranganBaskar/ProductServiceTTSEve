package dev.sarangan.productservicettseve.inheritanceExamples.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_instructor")
public class MscInstructor extends User {
    private boolean isHandSome;
}
