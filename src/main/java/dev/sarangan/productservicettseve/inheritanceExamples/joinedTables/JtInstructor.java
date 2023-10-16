package dev.sarangan.productservicettseve.inheritanceExamples.joinedTables;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_instructor")
@PrimaryKeyJoinColumn(name = "user_id")
public class JtInstructor extends JtUser {
    private boolean isHandSome;
}
