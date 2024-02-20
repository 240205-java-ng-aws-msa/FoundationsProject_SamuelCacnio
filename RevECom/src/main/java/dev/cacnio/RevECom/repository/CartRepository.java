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
    List<Cart> findByAccount_id (@Param("account_id") Integer account_id);
}
