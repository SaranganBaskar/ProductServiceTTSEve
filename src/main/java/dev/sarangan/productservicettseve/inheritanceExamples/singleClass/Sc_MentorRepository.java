package dev.sarangan.productservicettseve.inheritanceExamples.singleClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Sc_MentorRepository extends JpaRepository<ScMentor, Long> {

    ScMentor save(ScMentor scMentor);

    ScMentor findMentorById(Long id);

}
