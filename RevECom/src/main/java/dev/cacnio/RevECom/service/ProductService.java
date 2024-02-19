package dev.cacnio.RevECom.service;

import dev.cacnio.RevECom.entity.Product;
import dev.cacnio.RevECom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product findByItem_id(Integer id){
        try{
            return productRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException | IllegalArgumentException e){
            return null;
        }
    }

    public Product findByName(String name){
        try{
            return productRepository.findByName(name);
        } catch (NoSuchElementException | IllegalArgumentException e){
            return null;
        }
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
