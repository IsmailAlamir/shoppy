package com.example.shoppy.web;

import com.example.shoppy.Domain.Cart;
import com.example.shoppy.Domain.Item;
import com.example.shoppy.Domain.Shopper;
import com.example.shoppy.infrastructure.CartRepository;
import com.example.shoppy.infrastructure.ItemRepository;
import com.example.shoppy.infrastructure.ShopperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ShoppingController {

//    @Autowired
//    CartRepository cartRepository;
//    or you can do this :

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final ShopperRepository shopperRepository;

    public ShoppingController(CartRepository cartRepository, ItemRepository itemRepository, ShopperRepository shopperRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        this.shopperRepository = shopperRepository;

    }

    @ResponseBody
    @PostMapping("/carts")
    Cart createNewCart(@RequestBody Cart cart){
        return cartRepository.save(cart);

    }

    @ResponseBody
    @PostMapping("/shoppers")
    Shopper createNewShopper(@RequestBody Shopper shopper){
        return shopperRepository.save(shopper);

    }


    @ResponseBody
    @PostMapping("/carts/{id}")
    Item createNewItem(@RequestBody Item item , @PathVariable Long id){
        Cart cart = cartRepository.findById(Math.toIntExact(id)).orElseThrow();
        item.setCart(cart);
        return itemRepository.save(item);

    }

    @ResponseBody
    @PutMapping("/shoppers/{shopperId}/items/{itemId}")
    Item likeAnItem(@PathVariable Long shopperId ,@PathVariable Long itemId){
        Shopper shopper= shopperRepository.findById(Math.toIntExact(shopperId)).orElseThrow();
        Item item = itemRepository.findById(Math.toIntExact(itemId)).orElseThrow();

        shopper.setLikedItems(item);

        shopperRepository.save(shopper);

        return item;
    }

    @ResponseBody
    @GetMapping("/carts")
    List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/carts/{id}/items")
    List<Item> findAllItemsOfCart(@PathVariable Long id){
        return itemRepository.findAllByCart_Id(id);
    }

    @ResponseBody
    @GetMapping("/items/cost/{cost}")
    List<Item> findAllItemsAboveCost(@PathVariable BigDecimal cost) {

        return itemRepository.findItemsGreatThanCost(cost);
    }






}

