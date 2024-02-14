package dev.cacnio.RevECom.repository;

import dev.cacnio.RevECom.entity.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemRepository extends JpaRepository<ShopItem, Integer> {

    @Query("FROM ShopItem WHERE name = :name")
    ShopItem findByName (@Param("name") String name);
}
