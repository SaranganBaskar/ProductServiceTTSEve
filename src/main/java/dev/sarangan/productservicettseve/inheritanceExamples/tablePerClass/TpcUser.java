package dev.sarangan.productservicettseve.inheritanceExamples.tablePerClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TpcUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
}
