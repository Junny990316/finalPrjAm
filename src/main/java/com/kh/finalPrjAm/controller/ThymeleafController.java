package com.kh.finalPrjAm.controller;

import com.kh.finalPrjAm.dto.ItemDTO;
import com.kh.finalPrjAm.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafController {
    @GetMapping("/item")
    public String thymeleafItem(Model model) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setItemNm("LG AirConditional");
        itemDTO.setItemDetail("this is air conditional");
        itemDTO.setPrice(2000000);
        itemDTO.setRegTime(LocalDateTime.now());
        model.addAttribute("itemDto", itemDTO);
        return "thymeleaf/thymeleafItem";
    }
    @GetMapping("item-list")
    public String thymeleafItemList(Model model) {
        List<ItemDTO> itemDTOList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setItemNm("test product" + i);
            itemDTO.setItemDetail("test product description" + i);
            itemDTO.setPrice(1000 * i);
            itemDTO.setRegTime(LocalDateTime.now());
            itemDTOList.add(itemDTO);
        }
        model.addAttribute("itemDTOList", itemDTOList);
        return "thymeleaf/thymeleafItemList";
    }

    @GetMapping("link-test")
    public String thymeleafLinkTest() {
        return "thymeleaf/thymeleafLinkTest";
    }

    @GetMapping("link-param")
    public String thymeleafLinkTest(String param1, String param2, Model model) {
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "thymeleaf/thymeleafLinkParam";
    }
}
