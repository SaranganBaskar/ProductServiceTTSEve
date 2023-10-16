package dev.sarangan.productservicettseve.inheritanceExamples.mappedSuperClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MscInstructorRepository extends JpaRepository<MscInstructor, Long> {

    MscInstructor save(MscInstructor instructor);

    MscInstructor findInstructorById(Long id);
}
