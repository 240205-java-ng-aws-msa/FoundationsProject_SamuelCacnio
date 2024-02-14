package dev.cacnio.RevECom.service;

import dev.cacnio.RevECom.entity.ShopItem;
import dev.cacnio.RevECom.repository.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ShopItemService {
    ShopItemRepository shopItemRepository;
    @Autowired
    public ShopItemService(ShopItemRepository shopItemRepository){
        this.shopItemRepository = shopItemRepository;
    }

    public ShopItem findByItem_id(Integer id){
        try{
            return shopItemRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException | IllegalArgumentException e){
            return null;
        }
    }

    public ShopItem findByName(String name){
        try{
            return shopItemRepository.findByName(name);
        } catch (NoSuchElementException | IllegalArgumentException e){
            return null;
        }
    }

    public List<ShopItem> getAllShopItems(){
        return shopItemRepository.findAll();
    }
}
