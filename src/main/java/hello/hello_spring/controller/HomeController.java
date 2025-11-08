package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home"; //템플릿 폴어에 home.html 파일 생성하기
    }
}

//기본으로 브라우저에 들어가면, home.html 실행됨
//기존 welcomepage보다 더 우선순위가 높음 (welcompage는 실행 X)



