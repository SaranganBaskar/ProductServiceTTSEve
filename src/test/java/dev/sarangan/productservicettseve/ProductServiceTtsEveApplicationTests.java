package dev.sarangan.productservicettseve;

import dev.sarangan.productservicettseve.inheritanceExamples.joinedTables.JtMentor;
import dev.sarangan.productservicettseve.inheritanceExamples.joinedTables.JtMentorRepository;
import dev.sarangan.productservicettseve.inheritanceExamples.joinedTables.JtUser;
import dev.sarangan.productservicettseve.inheritanceExamples.joinedTables.JtUserRepository;
import dev.sarangan.productservicettseve.inheritanceExamples.mappedSuperClass.MscMentorRepository;
import dev.sarangan.productservicettseve.inheritanceExamples.singleClass.Sc_MentorRepository;
import dev.sarangan.productservicettseve.inheritanceExamples.singleClass.Sc_UserRepository;
import dev.sarangan.productservicettseve.inheritanceExamples.tablePerClass.Tpc_MentorRepository;
import dev.sarangan.productservicettseve.inheritanceExamples.tablePerClass.Tpc_UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTtsEveApplicationTests {
    @Test
    void contextLoads() {
    }

}
