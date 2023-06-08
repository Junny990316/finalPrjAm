package com.kh.finalPrjAm.repository;

import com.kh.finalPrjAm.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepositoty는 첫번째는 엔티티 타입 클래스를 넣어주고, 두번째는 기본 키
// 기본적인 CRUD 및 페이징 처리를 위한 메소드는 정의 되어 있음
public interface ItemRepository extends JpaRepository<Item, Long> {

}
