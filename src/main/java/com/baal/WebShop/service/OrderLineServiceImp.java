package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CreateOrderLineDTO;
import com.baal.WebShop.DTO.OrderLineDTO;
import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.mapper.OrderLineModelMapper;
import com.baal.WebShop.model.OrderLine;
import com.baal.WebShop.model.Product;
import com.baal.WebShop.repository.OrderLineRepository;
import com.baal.WebShop.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
@Service
@RequiredArgsConstructor
public class OrderLineServiceImp implements OrderLineService{
    private final OrderLineRepository orderLineRepository;
    private final ProductRepository productRepository;
    private final OrderLineModelMapper orderLineModelMapper;

    @Override
    public OrderLineDTO createOrderLine(@Valid CreateOrderLineDTO createOrderLineDTO) {
        Product productById = productRepository.getReferenceById(createOrderLineDTO.productId());
        OrderLine orderLine = new OrderLine();
        orderLine.setNumberOfProducts(createOrderLineDTO.numberOfProducts());
        orderLine.setValueOfProduct(createOrderLineDTO.valueOfProduct());
        orderLine.setProduct(productById);
        OrderLine savedOrderLine = orderLineRepository.save(orderLine);
        return orderLineModelMapper.mapOrderLineEntityToOrderLineDTO(savedOrderLine);
    }

    @Override
    public List<OrderLineDTO> getOrderLines() {
        List<OrderLine> list = orderLineRepository.findAll();
        return list.stream().map(orderLineModelMapper::mapOrderLineEntityToOrderLineDTO).toList();
    }
}