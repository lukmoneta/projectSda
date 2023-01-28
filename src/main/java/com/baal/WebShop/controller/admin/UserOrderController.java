package com.baal.WebShop.controller.admin;

import com.baal.WebShop.DTO.UserOrderDTO;
import com.baal.WebShop.repository.service.UserOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin/order")
public class UserOrderController {

    private final UserOrderService userOrderService;

    @GetMapping("")
    public String getCategories(Model model) {
        List<UserOrderDTO> userOrders = userOrderService.getUserOrders();
        model.addAttribute("userOrders",userOrders);
        return "/admin/orderList";
    }


}

