package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    //MemberService 객체를 필드로 선언
    private final MemberService memberService;

    //DI : 의존성 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //get방식
    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    //post방식
    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {

        //입력받아서 넘어온 값이 MemberForm의 name필드에 저장
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        //회원가입이 끝나면 홈 화면으로 보내버리기
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}



