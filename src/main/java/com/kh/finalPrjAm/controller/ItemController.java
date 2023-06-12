package com.kh.finalPrjAm.controller;

import com.kh.finalPrjAm.constant.ItemSellStatus;
import com.kh.finalPrjAm.dto.ItemDTO;
import com.kh.finalPrjAm.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
@Slf4j
public class ItemController {
    ItemService itemService;
    public ItemController (ItemService itemServie) {
        this.itemService = itemServie;
    }
    // 제품 등록
    @PostMapping("/new")
    public ResponseEntity<Boolean> itemCreate(@RequestBody Map<String, Object> data) {
        String name = (String) data.get("name");
        int price = (Integer) data.get("price");
        String detail = (String) data.get("detail"); // key를 넣어서 해당하는 값을 반환받음
        int stock = (Integer) data.get("stock");
        String status = (String) data.get("status");
        boolean result = itemService.createItem(name, price, detail,
                ItemSellStatus.SELL, stock);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<List<ItemDTO>> itemList(@RequestParam String name) {
        List<ItemDTO> list = itemService.getItemList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
