package com.example.shoppy.infrastructure;

import com.example.shoppy.Domain.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopperRepository extends JpaRepository<Shopper,Integer> {

}
