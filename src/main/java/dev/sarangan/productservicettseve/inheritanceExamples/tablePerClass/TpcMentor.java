package dev.sarangan.productservicettseve.inheritanceExamples.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_mentor")
public class TpcMentor extends TpcUser {
    private int numberOfSessions;
    private int numberOfMentees;

}
