package dev.sarangan.productservicettseve.inheritanceExamples.joinedTables;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class JtMentor extends JtUser {
    private int numberOfSessions;
    private int numberOfMentees;

}
