package com.baal.WebShop.controller;

import com.baal.WebShop.DTO.CreateOrderLineDTO;
import com.baal.WebShop.DTO.GivenUpdateOrdeLineDTO;
import com.baal.WebShop.DTO.OrderLineWithProductNameDTO;
import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.DTO.UpdateOrderlineDTO;
import com.baal.WebShop.service.OrderLineService;
import com.baal.WebShop.service.ProductService;
import com.baal.WebShop.repository.service.OrderLineService;
import com.baal.WebShop.repository.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("numberOfOrderLines", numberOfOrdersLine);

        return "index";
    }

    @GetMapping("/addtocart")
    public String getToCart(@RequestParam Long productId) {

        orderLineService.createOrderLine(new CreateOrderLineDTO(productId));
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String getCart(Model model) {
        long numberOfOrderLines = orderLineService.numberOfOrderLines();
        List<OrderLineWithProductNameDTO> orderLinesWithProductNames = orderLineService.getOrderLinesWithProductNames();
        model.addAttribute("updateDTO",new GivenUpdateOrdeLineDTO(null,null,null,null));
        model.addAttribute("numberOfOrderLines", numberOfOrderLines);
        model.addAttribute("orderLines", orderLinesWithProductNames);
        return "cart";
    }

    @PostMapping("/cart")
    public String updateOrderLine(@ModelAttribute("orderLines") List<OrderLineWithProductNameDTO> orderLineWithProductNameDTOS) {


        return "redirect:/cart";
    }

    @PostMapping("/addQuantity")
    public String updateQuantity(@ModelAttribute UpdateOrderlineDTO updateOrderlineDTO) {
        orderLineService.updateOrderQuantity(updateOrderlineDTO);
        return "redirect:/cart";
    }


}
