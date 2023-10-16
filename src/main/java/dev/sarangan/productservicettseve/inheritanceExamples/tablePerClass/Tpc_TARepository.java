package dev.sarangan.productservicettseve.inheritanceExamples.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Tpc_TARepository extends JpaRepository<TpcTA, Long> {

    TpcTA save(TpcTA tpcTA);

   TpcTA findTpcTAById(Long id);

}
