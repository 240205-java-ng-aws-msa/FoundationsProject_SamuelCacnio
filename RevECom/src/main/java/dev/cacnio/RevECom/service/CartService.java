package dev.cacnio.RevECom.service;

import dev.cacnio.RevECom.entity.Cart;
import dev.cacnio.RevECom.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public Cart createCart(Cart cart){
        return cartRepository.save(cart);
    }

    public List<Cart> getUserCart(Integer account_id){
        return cartRepository.findByAccount_id(account_id);
    }

    public Integer getUserCartQuantity(Integer account_id){
        return cartRepository.sumQuantityByAccount_id(account_id);
    }

    public Integer updateCartQuantity(Cart cart){
        return cartRepository.updateCart(cart.getQuantity(), cart.getAccount_id(), cart.getItem_id());
    }
}
