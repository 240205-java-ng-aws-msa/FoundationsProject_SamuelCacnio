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

    private ArrayList<Product> cart;

    public Cart(){
        cart = new ArrayList<Product>();
    }
    public Cart(ArrayList<Product> cart){
        this.cart = cart;
    }
    public Cart(Product item){
        cart = new ArrayList<Product>();
        cart.add(item);
    }

    //accessor
    public ArrayList<Product> getCart(){
        return cart;
    }

    //mutator
    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    //cart interaction
    public Product addToCart(Product item){
        cart.add(item);
        return item;
    }
    public Product removeFromCart(Product item){
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
        for (Product i:cart){
            items_list = items_list.concat(i.getName()+"\n");
        }
        return  items_list;
    }
}
