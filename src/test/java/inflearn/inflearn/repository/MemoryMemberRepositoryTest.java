package inflearn.inflearn.repository;

import inflearn.inflearn.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // test를 main으로 돌렸을 때 각각의 test가 끝난 후 지워준다
    public void afterEach(){
        repository.clear();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("김기윤");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();//optional에서 값을 꺼내는 방법
//        System.out.println("결과 : "+ (result==member));
        // 이렇게 글로 하나씩 볼수 없으니 assert를 쓴다
        Assertions.assertEquals(member, null); // 기대하는 것을 앞에
        //Assertions.assertThat(member).isEqualTo(null);


    }

    @Test
    public void findById(){
        Member member1 = new Member();
        member1.setName("김기윤");
        repository.save(member1);

        Member member2 = new Member(); //shift + f6을 통해 바꿀 수 있다 변수의 이름
        member2.setName("임현종");
        repository.save(member2);

        Member result = repository.findByName("김기윤").get();

        Assertions.assertEquals(result, member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("김기윤");
        repository.save(member1);

        Member member2 = new Member(); //shift + f6을 통해 바꿀 수 있다 변수의 이름
        member2.setName("임현종");
        repository.save(member2);

        List<Member> memberList = repository.findAll();

        org.assertj.core.api.Assertions.assertThat(memberList.size()).isEqualTo(2);
    }
}
