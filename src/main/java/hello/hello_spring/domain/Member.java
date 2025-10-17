package hello.hello_spring.domain;

public class Member {
    private Long id; //회원 구별을 위해 임의로 지정되는 값
    private String name;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}


