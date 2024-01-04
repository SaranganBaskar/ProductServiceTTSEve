package dev.sarangan.productservicettseve;

import dev.sarangan.productservicettseve.inheritanceExamples.joinedTables.JtMentor;
import dev.sarangan.productservicettseve.inheritanceExamples.joinedTables.JtMentorRepository;
import dev.sarangan.productservicettseve.inheritanceExamples.joinedTables.JtUser;
import dev.sarangan.productservicettseve.inheritanceExamples.joinedTables.JtUserRepository;
import dev.sarangan.productservicettseve.inheritanceExamples.mappedSuperClass.MscInstructor;
import dev.sarangan.productservicettseve.inheritanceExamples.mappedSuperClass.MscInstructorRepository;
import dev.sarangan.productservicettseve.inheritanceExamples.mappedSuperClass.MscMentorRepository;
import dev.sarangan.productservicettseve.inheritanceExamples.singleClass.ScMentor;
import dev.sarangan.productservicettseve.inheritanceExamples.singleClass.Sc_MentorRepository;
import dev.sarangan.productservicettseve.inheritanceExamples.singleClass.Sc_UserRepository;
import dev.sarangan.productservicettseve.inheritanceExamples.tablePerClass.TpcTA;
import dev.sarangan.productservicettseve.inheritanceExamples.tablePerClass.Tpc_MentorRepository;
import dev.sarangan.productservicettseve.inheritanceExamples.tablePerClass.Tpc_TARepository;
import dev.sarangan.productservicettseve.inheritanceExamples.tablePerClass.Tpc_UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class InheritanceExamplesTests {

//    //region Joined Table repositories
//    @Autowired
//    private JtUserRepository jtUserRepository;
//    @Autowired
//    private JtMentorRepository jtMentorRepository;
//    //endregion
//
//    //region Mapped Super class Repositories
//    @Autowired
//    private MscMentorRepository mscMentorRepository;
//
//    @Autowired
//    private MscInstructorRepository mscInstructorRepository;
//
//    //endregion
//
//    //region Single Class Repositories
//    @Autowired
//    private Sc_MentorRepository scMentorRepository;
//    @Autowired
//    private Sc_UserRepository scUserRepository;
//    //endregion
//
//    //region Table Per Class Repositories
//    @Autowired
//    private Tpc_MentorRepository tpcMentorRepository;
//    @Autowired
//    private Tpc_UserRepository tpcUserRepository;
//    @Autowired
//    private Tpc_TARepository tpcTaRepository;
//    //endregion
//
//
//
//    //region Joined Table Test case
//    @Test
//    void JTUserInheritance(){
//        JtUser jtUser = new JtUser();
//        jtUser.setEmail("jtSarangan@gmail.com");
//        jtUser.setPassword("jtSaranganPwd");
//        jtUserRepository.save(jtUser);
//    }
//
//    @Test
//    void JTMentorInheritance(){
//        JtMentor jtMentor = new JtMentor();
//        jtMentor.setEmail("jtSaranganMentor@gmail.com");
//        jtMentor.setPassword("jtSaranganMentorPwd");
//        jtMentor.setNumberOfMentees(5);
//        jtMentor.setNumberOfSessions(50);
//        jtMentorRepository.save(jtMentor);
//    }
//    //endregion
//
//    //region Mapped Super class Test case
//    @Test
//    void MSCInstructorInheritance(){
//        MscInstructor mscInstructor=new MscInstructor();
//        mscInstructor.setEmail("mscSaranganInstructor2@gmail.com");
//        mscInstructor.setHandSome(true);
//        mscInstructor.setPassword("mscSaranganInstructor2Pwd");
//        mscInstructorRepository.save(mscInstructor);
//    }
//    //endregion
//
//    //region Super Class Test case
//    @Test
//    void ScMentorInheritance(){
//        ScMentor scMentor = new ScMentor();
//        scMentor.setEmail("ScSarangan@gmail.com");
//        scMentor.setPassword("ScSaranganPwd");
//        scMentor.setNumberOfMentees(50);
//        scMentor.setNumberOfSessions(100);
//        scMentorRepository.save(scMentor);
//    }
//    //endregion
//
//    //region Table Per class Test case
//    @Test
//    void TpcTaInheritance(){
//        TpcTA tpcTA = new TpcTA();
//        tpcTA.setEmail("tpcSarangan@gmail.com");
//        tpcTA.setPassword("tpcSaranganPwd");
//        tpcTA.setAverageRating(9.5);
//        tpcTaRepository.save(tpcTA);
//    }
//    //endregion

}
