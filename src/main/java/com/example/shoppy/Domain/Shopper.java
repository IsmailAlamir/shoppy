package com.example.shoppy.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@JsonIgnoreProperties({"likedItems"})
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Shopper {

    @Setter (value = AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    private String name;

    @ManyToMany
    @JoinTable(
            name = "liked_item",
            joinColumns = @JoinColumn(name = "Shopper_id"),
            inverseJoinColumns = @JoinColumn(name = "Item_id")
    )

    Set<Item> likedItems;

    public void setLikedItems(Item item){
        likedItems.add(item);
    }

}
