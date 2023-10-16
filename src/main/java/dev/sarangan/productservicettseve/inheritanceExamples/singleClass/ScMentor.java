package dev.sarangan.productservicettseve.inheritanceExamples.singleClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "sc_mentor")
@DiscriminatorValue("2")
public class ScMentor extends ScUser {
    private int numberOfSessions;
    private int numberOfMentees;

}
