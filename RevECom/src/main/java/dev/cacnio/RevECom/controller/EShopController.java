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
    ShopItemService shopItemService;

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
    public ResponseEntity<List<ShopItem>> allItems(){
        return ResponseEntity.status(200).body(shopItemService.getAllShopItems());
    }

    @GetMapping("/store/{item_name}")
    public ResponseEntity<ShopItem> findItem(@PathVariable String name){
        ShopItem target = shopItemService.findByName(name);
        return ResponseEntity.status(200).body(target);
    }
}
