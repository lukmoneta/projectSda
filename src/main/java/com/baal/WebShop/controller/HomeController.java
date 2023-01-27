package com.baal.WebShop.controller;

import com.baal.WebShop.DTO.CreateOrderLineDTO;
import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.service.OrderLineService;
import com.baal.WebShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ProductService productService;
    private final OrderLineService orderLineService;

    @GetMapping("/")
    public String getHome(Model model) {
        long numberOfOrdersLine = orderLineService.numberOfOrderLines();
        List<ProductDTO> productList = productService.getProducts();
        model.addAttribute("products", productList);
        model.addAttribute("numberOfOrderLines",numberOfOrdersLine);

        return "index";
    }

    @GetMapping("/addtocart")
    public String getCart(@RequestParam Long productId) {

        orderLineService.createOrderLine(new CreateOrderLineDTO(productId));
        return "redirect:/";
    }


}
