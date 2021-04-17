package inflearn.inflearn;

import inflearn.inflearn.repository.JdbcMemberRepository;
import inflearn.inflearn.repository.JdbcTemplateMemberRepository;
import inflearn.inflearn.repository.JpaMemberRepository;
import inflearn.inflearn.repository.MemberRepository;
import inflearn.inflearn.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

//    private EntityManager em;
//
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
//
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//
//        //return new JdbcMemberRepository(dataSource);
//
//        return new JpaMemberRepository(em);
//    }

}
