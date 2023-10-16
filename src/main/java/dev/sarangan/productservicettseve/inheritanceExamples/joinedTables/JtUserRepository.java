package dev.sarangan.productservicettseve.inheritanceExamples.joinedTables;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JtUserRepository extends JpaRepository<JtUser, Long> {

    JtUser save(JtUser jtUser);

    JtUser findUserById(Long id);
}
