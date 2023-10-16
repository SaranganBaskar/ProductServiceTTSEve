package dev.sarangan.productservicettseve.inheritanceExamples.mappedSuperClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MscMentorRepository extends JpaRepository<Mentor, Long> {

    Mentor save(Mentor mentor);

    Mentor findMentorById(Long id);
}
