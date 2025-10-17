package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository(); //저장소 객체 생성

    @AfterEach //@Test가 끝난 다음에 매번 호출됨
    public void afterEach(){
        repository.clearStore(); //저장소 초기화 메서드 호출
    }
    //역할 :: 테스트 코드들이 순서에 의존하지 않고 테스트 실행 결과를 확인하기 위함!

    //테스트1
    @Test
    public void save(){
        //정보 생성
        Member member = new Member();
        member.setName("ALyeong");

        //저장소에 회원 저장하기
        repository.save(member);

        //findById()이용해서 꺼낸 값을 result 객체에 저장하기
        Member result = repository.findById(member.getId()).get();
        //get() : 옵셔널로 감싼값을 꺼내는 기능

        //두 객체가 동일한지 검증 코드
        assertThat(result).isEqualTo(member);
    }

    //테스트2
    @Test
    public void findByName(){
        //회원1 + 저장소에 등록
        Member member1 = new Member();
        member1.setName("ALyeong");
        repository.save(member1);

        //회원2 + 저장소에 등록
        Member member2 = new Member();
        member2.setName("Sumin");
        repository.save(member2);
        
        //findByName()로 꺼내온 값 result 객체에 저장
        Member result = repository.findByName("ALyeong").get();
        
        //result와 member1가 동일한지 검증하는 코드
        assertThat(result).isEqualTo(member1);
    }

    //테스트3
    @Test
    public void findAll() {
        //회원1 + 저장소에 등록
        Member member1 = new Member();
        member1.setName("Sohee");
        repository.save(member1);

        //회원2 + 저장소에 등록
        Member member2 = new Member();
        member2.setName("Hyeju");
        repository.save(member2);
        
        //findA;;()로 꺼내온 값 result 객체에 저장
        List<Member> result = repository.findAll();
        
        //result에 들어있는 회원수가 2인지 검증하는 코드
        assertThat(result.size()).isEqualTo(2);

    }
}
