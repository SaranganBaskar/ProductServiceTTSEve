package dev.sarangan.productservicettseve.inheritanceExamples.joinedTables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class JtUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
}
