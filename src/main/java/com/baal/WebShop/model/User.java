package com.baal.WebShop.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String email;
    private String phoneNumber;
    @OneToMany(mappedBy = "user")
    private List<UserOrder> userOrderList;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
