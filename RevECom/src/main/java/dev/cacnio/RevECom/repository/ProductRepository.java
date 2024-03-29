package dev.cacnio.RevECom.repository;

import dev.cacnio.RevECom.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("FROM Product WHERE name = :name")
    Product findByName (@Param("name") String name);

    @Query("FROM Product WHERE category = :category")
    List<Product> findByCategory (@Param("category") String category);
}
