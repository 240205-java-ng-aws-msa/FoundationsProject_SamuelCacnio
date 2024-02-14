package dev.cacnio.RevECom.entity;

import java.util.ArrayList;
import java.util.Objects;

/*
* This class models a cart for a specific user in the eShop
* */
public class Cart {

    /*
    * TODO: Fields
    *  data structure: ArrayList
    *
    * TODO: Methods
    *  Constructor
    *  Getters
    *   findItem
    *  Setters
    *   addItem (append)
    *   checkout (empty)
    *  toString override
    */

    private ArrayList<ShopItem> cart;

    public Cart(){
        cart = new ArrayList<ShopItem>();
    }
    public Cart(ArrayList<ShopItem> cart){
        this.cart = cart;
    }
    public Cart(ShopItem item){
        cart = new ArrayList<ShopItem>();
        cart.add(item);
    }

    //accessor
    public ArrayList<ShopItem> getCart(){
        return cart;
    }

    //mutator
    public void setCart(ArrayList<ShopItem> cart) {
        this.cart = cart;
    }

    //cart interaction
    public ShopItem addToCart(ShopItem item){
        cart.add(item);
        return item;
    }
    public ShopItem removeFromCart(ShopItem item){
        cart.remove(item);
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart1 = (Cart) o;
        return Objects.equals(cart, cart1.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cart);
    }

    @Override
    public String toString() {
        String items_list = "";
        for (ShopItem i:cart){
            items_list = items_list.concat(i.getName()+"\n");
        }
        return  items_list;
    }
}
