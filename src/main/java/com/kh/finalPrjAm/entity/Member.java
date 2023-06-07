package com.kh.finalPrjAm.entity;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // JPA에 Entity 클래스임을 알려줌, DB테이블로 만들어져야 할 클래스
@Table(name = "member") // 생략 가능, 자바는 카멜 표기법을 사용하기 때문에 본인이 테이블 이름을 지정하고 싶을 때 사용
public class Member {
    @Id // 해당 필드가 primary key임을 지정
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO) // 값에 대한 생성전략, ID에 대한 생성 전략을 자동으로 따르겠다는 것
    private Long id;
    // 아이디 생성 조건
    private String userId;
    private String name;
    private String password;
    @Column(unique = true) // 유일한 값
    private String email;
    private LocalDateTime joinTime;
}
