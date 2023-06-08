package com.kh.finalPrjAm.entity;
import com.kh.finalPrjAm.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // JPA에 Entity 클래스임을 알려줌, Entity 클래스는 반드시 기본키가 있어야 한다
@Getter @Setter @ToString
public class Item {
    @Id // 해당 키가 primary key임을 지정
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO) // JPA 구현체의 생성 전략을 따름
    private Long id; // pk

    @Column(nullable = false, length = 50) // null값을 허용하지 않겠다는 것
    private String itemNm; //상품코드

    @Column(nullable = false)
    private int price; // 상품 가격

    @Column(nullable = false)
    private int stockNumber; // 재고 수량

    @Lob // 기존의 문자열 보다 더 긴 문자열을 사용할 때 추가
    @Column(nullable = false)
    private String itemDetail; // 상품 상세 설명

    @Enumerated(EnumType.STRING) // 이름 자체를 문자열에 저장하는 것 (sold_out / sell)
    private ItemSellStatus itemSellStatus; // 상품 판매 상태

    private LocalDateTime regTime; // 등록 시간
    private LocalDateTime updateTime; // 수정 시간
}
