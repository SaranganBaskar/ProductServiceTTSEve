package dev.sarangan.productservicettseve.inheritanceExamples.singleClass;


import org.springframework.data.jpa.repository.JpaRepository;

public interface Sc_UserRepository extends JpaRepository<ScUser, Long> {

    ScUser save(ScUser scUser);

    ScUser findUsersById(Long id);
}
