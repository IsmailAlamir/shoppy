package com.example.shoppy.infrastructure;

import com.example.shoppy.Domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {

    List<Item> findAllByCart_Id(Long id);// spring JPA/Hibernate generates


    @Query("select i from Item i where i.cost >= :#{#cost}")
    List<Item> findItemsGreatThanCost(@Param("cost") BigDecimal cost); // not best practice

}
