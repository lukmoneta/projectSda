package com.baal.WebShop.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private BigDecimal totalCost;
    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Instant dateOfOrder;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "userOrder")
    private List<OrderLine> orderLineList;
}
