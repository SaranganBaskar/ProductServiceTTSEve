package dev.sarangan.productservicettseve.inheritanceExamples.singleClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="sc_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
public class ScUser {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
}
