package com.kh.finalPrjAm.repository;

import com.kh.finalPrjAm.constant.ItemSellStatus;
import com.kh.finalPrjAm.entity.Item;
//import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import java.time.LocalDateTime;
import java.util.List;


//@Slf4j // 디버깅하거나 로그 파일을 저장해야 할 때 사용
@SpringBootTest // 단위 테스트 및 통합 테스트를 위해 스프링부트에서 제동하는 어노테이션
@TestPropertySource(locations = "classpath:application-test.properties") // 테스트 코드 실행 시 해당 설정 파일을 우선적으로 불러옴
class ItemRepositoryTest {
    @Autowired // 의존성을 주입 받음
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {
        for (int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setItemNm("테스트 상품" + i);
            item.setPrice(10000 + i*10);
            item.setItemDetail("테스트 상품 상세 설명" + i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            itemRepository.save(item); // 저장 테스트
        }
    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNmTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemNm("테스트 상품5"); // select * 과 같음
        for (Item e : itemList) {
            System.out.println("결과 : " + e.toString());
        }
    }

    @Test
    @DisplayName("상품명  or 상품상세설명 테스트")
    public void findByItemNmOrItemDetailTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품5", "테스트 상품 상세 설명7");
        for (Item e : itemList) {
            System.out.println("결과 : " + e.toString());
        }
    }

    @Test
    @DisplayName("입력 받은 가격보다 작은 상품 조회")
    public void findByPriceLessThanTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findByPriceLessThan(10025);
        for (Item e : itemList) {
            System.out.println("결과 : " + e.toString());
        }
    }

    @Test
    @DisplayName("가격 내림차순 조회 테스트")
    public void findByPriceLessThanOrderByPriceDescTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10075);
        for (Item e : itemList) {
            System.out.println("결과 : " + e.toString());
        }
    }

    @Test
    @DisplayName("Query를 이용한 상품 조회 테스트")
    public void findByItemDetailTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemDetail("테스트 상품의");
        for (Item e : itemList) {
            System.out.println("결과 : " + e.toString());
        }
    }
}