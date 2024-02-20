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

    public List<Cart> getUserCart(Integer account_id){
        return cartRepository.findByAccount_id(account_id);
    }
}
