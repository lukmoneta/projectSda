package com.baal.WebShop.controller.thymeleaf;

import com.baal.WebShop.DTO.UserOrderDTO;
import com.baal.WebShop.service.UserOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin/order")
public class UserOrderController {

    private final UserOrderService userOrderService;

    @GetMapping("")
    public ResponseEntity<List<UserOrderDTO>> getCategories() {
        List<UserOrderDTO> userOrders = userOrderService.getUserOrders();
        return new ResponseEntity<>(userOrders, HttpStatus.OK);
    }


}

