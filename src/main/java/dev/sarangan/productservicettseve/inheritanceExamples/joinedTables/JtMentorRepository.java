package dev.sarangan.productservicettseve.inheritanceExamples.joinedTables;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JtMentorRepository extends JpaRepository<JtMentor, Long> {

    JtMentor save(JtMentor jtMentor);

    JtMentor findUserById(Long id);
}
