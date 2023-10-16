package dev.sarangan.productservicettseve.inheritanceExamples.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_instructor")
public class TpcInstructor extends TpcUser {
    private boolean isHandSome;
}
