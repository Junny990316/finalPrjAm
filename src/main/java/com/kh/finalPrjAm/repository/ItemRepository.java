package com.kh.finalPrjAm.repository;

import com.kh.finalPrjAm.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//JpaRepositoty는 첫번째는 엔티티 타입 클래스를 넣어주고, 두번째는 기본 키
// 기본적인 CRUD 및 페이징 처리를 위한 메소드는 정의 되어 있음
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemNm(String itemNm);
    // or 조건 처리하기
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    // LessThan : 매개변수로 전달 받은 값보다 작은 상품 조회
    List<Item> findByPriceLessThan(Integer price);

    // OrderBy 로 정렬 : OrderBy + 속성명 + Asc or Desc
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    // JPQL(JPA Query Language) : 쿼리 메소드의 경우 조건이 복잡한 경우 쿼리 메소드를 선언하는 것이
    // 너무 복잡하거나 만들 수 없는 경우에 사용
    // JPQL은 실체 쿼리와는 다르게 JPA 엔티티에 사용됨
    @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price desc",
            nativeQuery = true)
    List<Item> findByItemDetail(@Param("itemDetail")String itemDetail);
}
