package com.kb.shop.controller;

import com.kb.shop.domain.Product;
import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShippingController {


    @Autowired
    private ShippingService service;
    // 배송 정보를 생성하는 POST 호출을 생성합니다. (path : /shipping)
    // 배송 Status를 변경하는 PUT 호출을 생성합니다. (path : /shipping)
    // 배송 정보를 확인하는 GET 호출을 생성합니다.  (path : /shipping)

    @ModelAttribute("ship")
    public ShippingInfo ship() {
        ShippingInfo ship = new ShippingInfo((long) 1, "ready");
        service.newShipping(ship);
//        if (service.checkShipping()) {
//            ShippingInfo ship = new ShippingInfo("ready");
//            service.newShipping(ship);
//        }
            return service.getShippingInfo(ship.getId());  // 변경 가능한 리스트 반환
    }
    @PostMapping("/shipping")
    public void create(ShippingInfo info) {
        service.newShipping(info);
    }

    @PutMapping("/shipping")
    public void change(String status, Long id) {
        service.change(status, id);
    }

    @GetMapping("/shipping")
    public void get(Long id, Model model) {
        ShippingInfo info = service.getShippingInfo(id);

        model.addAttribute("status", info.getStatus())
    }

    @GetMapping("/ship")
    public String viewCart(@ModelAttribute("ship") Model model) {
        model.addAttribute("ship", "test");
        return "ship";
    }
}
