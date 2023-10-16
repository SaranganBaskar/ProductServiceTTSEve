package dev.sarangan.productservicettseve.inheritanceExamples.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Tpc_MentorRepository extends JpaRepository<TpcMentor, Long> {

    TpcMentor save(TpcMentor tpcMentor);

    TpcMentor findTpcMentorById(Long id);

}
