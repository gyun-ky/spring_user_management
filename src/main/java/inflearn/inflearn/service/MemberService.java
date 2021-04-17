package inflearn.inflearn.service;

import inflearn.inflearn.domain.Member;
import inflearn.inflearn.repository.MemberRepository;
import inflearn.inflearn.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    /**
     * 회원가입     */
    public Long join(Member member){

        validateDuplicateMember(member); //중복회원 검
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());// command + option + V : 리턴 자료형에 맞는 변수 선
        result.ifPresent(m-> {
                throw new IllegalStateException("이미 존재하는 회원 입니다");}); //null의 가능성이 있으면 optional로 감싼다. optional method 들이 있
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    //코드가 method로 뽑을 만 한것들은 control + t 후에 method 검색 (바로 단축키 : command option M)
}
