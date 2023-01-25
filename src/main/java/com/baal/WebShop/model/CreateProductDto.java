package com.baal.WebShop.model;

import jakarta.validation.constraints.DecimalMin;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link Product} entity
 */
@Data
public class CreateProductDto implements Serializable {
    private final String name;
    private final String description;
    private final String pictureUrl;
    @DecimalMin("0.0")
    private final BigDecimal price;
    private final Long categoryId;
}