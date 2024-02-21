package dev.cacnio.RevECom.controller;

import dev.cacnio.RevECom.service.*;
import dev.cacnio.RevECom.entity.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class EShopController {
    @Autowired
    AccountService accountService;
    @Autowired
    ProductService productService;
    @Autowired
    CartService cartService;
    /*
    * TODO
    *  register
    *  login
    *  view Item
    *  browse (must implement keywords)
    *  cart interaction(?)
    *  checkout
    */

    @PostMapping("/register")
    public ResponseEntity<Account> registerNewUser(@RequestBody Account account){
        Boolean alreadyExists = accountService.emailMatch(account.getEmail());
        if (!alreadyExists){
            return ResponseEntity.status(200).body(accountService.registerAccount(account));
        }
        return ResponseEntity.status(400).body(account);
    }
    @PostMapping("/login")
    public ResponseEntity<Account> userLogin(@RequestBody Account account){
        Account user = accountService.login(account);
        if (user!=null){
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(401).body(account);
    }

    @GetMapping("/store")
    @ResponseBody
    public ResponseEntity<List<Product>> allItems(){
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @GetMapping("/store/nations/{category}")
    @ResponseBody
    public ResponseEntity<List<Product>> findCategory(@PathVariable String category){
        return ResponseEntity.status(200).body(productService.getCategory(category));
    }

    @GetMapping("/store/names/{name}")
    public ResponseEntity<Product> findItem(@PathVariable String name){
        Product target = productService.findByName(name);
        return ResponseEntity.status(200).body(target);
    }

    @GetMapping("/users/{account_id}")
    @ResponseBody
    public ResponseEntity<List<Cart>> getUserCart(@PathVariable Integer account_id){
        return ResponseEntity.status(200).body(cartService.getUserCart(account_id));
    }

    @GetMapping("/users/{account_id}/count")
    @ResponseBody
    public ResponseEntity<Integer> getUserCartQuantity(@PathVariable String account_id){
        return ResponseEntity.status(200).body(cartService.getUserCartQuantity(Integer.parseInt(account_id)));
    }
    @PostMapping("/carts")
    public ResponseEntity<Cart> initCart(@RequestBody Cart cart){
        return ResponseEntity.status(200).body(cartService.createCart(cart));
    }

    @PatchMapping("/carts")
    public ResponseEntity<Integer> updateCart(@RequestBody Cart cart){
        return ResponseEntity.status(200).body(cartService.updateCartQuantity(cart));
    }

}
