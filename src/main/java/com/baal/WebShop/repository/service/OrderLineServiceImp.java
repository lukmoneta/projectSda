package com.baal.WebShop.repository.service;

import com.baal.WebShop.DTO.CreateOrderLineDTO;
import com.baal.WebShop.DTO.OrderLineDTO;
import com.baal.WebShop.DTO.OrderLineWithProductNameDTO;
import com.baal.WebShop.DTO.UpdateOrderlineDTO;
import com.baal.WebShop.mapper.OrderLineModelMapper;
import com.baal.WebShop.model.OrderLine;
import com.baal.WebShop.model.Product;
import com.baal.WebShop.repository.OrderLineRepository;
import com.baal.WebShop.repository.ProductRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.List;

@Validated
@Service
@RequiredArgsConstructor
public class OrderLineServiceImp implements OrderLineService {
    private final OrderLineRepository orderLineRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;
    private final OrderLineModelMapper orderLineModelMapper;

    @Override
    public OrderLineDTO createOrderLine(@Valid CreateOrderLineDTO createOrderLineDTO) {
        Product productById = productRepository.getReferenceById(createOrderLineDTO.productId());
        OrderLine orderLine = new OrderLine();
        orderLine.setNumberOfProducts(1);
        orderLine.setValueOfProduct(productById.getPrice());
        orderLine.setProduct(productById);
        OrderLine savedOrderLine = orderLineRepository.save(orderLine);
        return orderLineModelMapper.mapOrderLineEntityToOrderLineDTO(savedOrderLine);
    }

    @Override
    public List<OrderLineDTO> getOrderLines() {
        List<OrderLine> list = orderLineRepository.findAll();
        return list.stream().map(orderLineModelMapper::mapOrderLineEntityToOrderLineDTO).toList();
    }

    @Override
    public long numberOfOrderLines() {
        return orderLineRepository.findAll().size();

    }

    @Override
    public List<OrderLineWithProductNameDTO> getOrderLinesWithProductNames() {
        List<OrderLine> all = orderLineRepository.findAll();
        return all.stream().map(orderLine -> {
                    return new OrderLineWithProductNameDTO(orderLine.getId(), orderLine.getProduct().getName(),
                            orderLine.getProduct().getPrice(), orderLine.getNumberOfProducts(), orderLine.getValueOfProduct());
                }

        ).toList();
    }

    @Override
    public void updateOrderLine(List<OrderLineWithProductNameDTO> orderLineWithProductNameDTOList) {
        /*orderLineWithProductNameDTOList.stream().map(orderLineWithProductNameDTO -> {
            Product productByName = productService.getProductByName(orderLineWithProductNameDTO.productName());
            OrderLine orderLine = new OrderLine();
            orderLine.setNumberOfProducts();
            orderLine.setValueOfProduct();

        })
*/
    }


    @Override
    @Transactional
    public void updateOrderQuantity(UpdateOrderlineDTO updateOrderlineDTO) {

        OrderLine orderLine = orderLineRepository.findById(updateOrderlineDTO.id()).orElseThrow();
        BigDecimal value = (BigDecimal.valueOf(updateOrderlineDTO.quantity()).multiply(orderLine.getProduct().getPrice()));
        orderLine.setNumberOfProducts(updateOrderlineDTO.quantity());
        orderLine.setValueOfProduct(value);

    }

}
