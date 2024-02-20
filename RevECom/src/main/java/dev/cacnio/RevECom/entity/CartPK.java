package dev.cacnio.RevECom.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartPK implements Serializable {

    private Integer account_id;
    private Integer item_id;

    public CartPK() {}

    public CartPK(Integer account_id, Integer item_id) {
        this.account_id = account_id;
        this.item_id = item_id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartPK cartPK = (CartPK) o;
        return Objects.equals(account_id, cartPK.account_id) && Objects.equals(item_id, cartPK.item_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_id, item_id);
    }
}
