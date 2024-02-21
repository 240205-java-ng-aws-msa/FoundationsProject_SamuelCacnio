package dev.cacnio.RevECom.repository;

import dev.cacnio.RevECom.entity.Cart;
import dev.cacnio.RevECom.entity.CartPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartPK> {

    @Query("FROM Cart WHERE account_id = :account_id")
    List<Cart> findByAccount_id(@Param("account_id") Integer account_id);

    @Query("FROM Cart WHERE account_id = :account_id AND item_id = :item_id")
    Cart findByAccount_idAndItem_id(@Param("account_id") Integer account_id, @Param("item_id") Integer item_id);

    @Query("SELECT COALESCE(sum(quantity),0) FROM Cart WHERE account_id = :account_id")
    Integer sumQuantityByAccount_id(@Param("account_id") Integer account_id);

    @Modifying
    @Query("UPDATE Cart c SET c.quantity = :quantity WHERE c.account_id = :account_id AND c.item_id = :item_id")
    Integer updateCart(@Param("quantity") Integer quantity, @Param("account_id") Integer account_id, @Param("item_id") Integer item_id);
}
