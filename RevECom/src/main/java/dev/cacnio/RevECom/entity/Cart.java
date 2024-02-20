package dev.cacnio.RevECom.entity;

/*
* This class relates a user to a product said user wants to buy.
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.util.Objects;

@Entity
@IdClass(CartPK.class)
public class Cart {
    @Id
    private Integer account_id;
    @Id
    private Integer item_id;

    private Integer quantity;

    public Cart() {}

    public Cart(Integer account_id, Integer item_id, Integer quantity) {
        this.account_id = account_id;
        this.item_id = item_id;
        this.quantity = quantity;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(account_id, cart.account_id) && Objects.equals(item_id, cart.item_id) && Objects.equals(quantity, cart.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_id, item_id, quantity);
    }
}
