package com.kh.finalPrjAm.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ItemDTO {
    String itemNm;
    int price;
    String itemDetail;
    private LocalDateTime regTime;
}
