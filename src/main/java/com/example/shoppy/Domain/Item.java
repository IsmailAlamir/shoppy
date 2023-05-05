package com.example.shoppy.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@JsonIgnoreProperties({"cart"}) //to Ignore the error that cause infinite loop between cart and item in createNewItem method
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Item {

    @Setter (value = AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private BigDecimal cost; // for money

    @ManyToOne
    Cart cart;  // the name "cart" should be same as in Item class

    @ManyToMany(mappedBy = "likedItems")
    private Set<Shopper> shoppers;
}
