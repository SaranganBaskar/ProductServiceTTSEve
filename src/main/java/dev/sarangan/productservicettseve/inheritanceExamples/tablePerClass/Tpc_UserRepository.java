package dev.sarangan.productservicettseve.inheritanceExamples.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Tpc_UserRepository extends JpaRepository<TpcUser, Long> {

    TpcUser save(TpcUser tpcUser);

    TpcUser findTpcUserById(Long id);
}
