package dev.cacnio.RevECom.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;


/*
 * This class models an item in our eShop
 */
@Entity
@Table(name="product")
public class Product {
    /*
     * TODO: Fields
     *  id (autogenerate?)
     *  name
     *  image (path?)
     *  price
     *  description
     *  keywords/categories (stretch)
     *  user reviews (stretch goal?)
     * 
     * TODO: Methods
     *  Constructor
     *  Getters
     *  Setters
     *  equals override
     *  toString override
     */
    @Column (name="item_id")
    @Id @GeneratedValue
    private Integer item_id;

    @Column (name="name")
    private String name;

    @Column (name="image_path")
    private String image_path;

    @Column (name="price")
    private Double price;

    @Column (name="description")
    private String description;

    public Product(){}

    //constructor for new items (id autogenerated)
    public Product(String name, String image_path, Double price, String description){
        this.name = name;
        this.image_path = image_path;
        this.price = price;
        this.description = description;
    }

    //constructor for retrieved items
    public Product(Integer item_id, String name, String image_path, Double price, String description){
        this.item_id = item_id;
        this.name = name;
        this.image_path = image_path;
        this.price = price;
        this.description = description;
    }

    //accessor methods
    public Integer getItem_id() {
        return item_id;
    }
    public String getName(){
        return name;
    }
    public String getImage_path(){
        return image_path;
    }
    public Double getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }

    //mutator methods
    public void setItem_id(Integer item_id){
        this.item_id = item_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product shopItem = (Product) o;
        return Objects.equals(item_id, shopItem.item_id) && Objects.equals(name, shopItem.name) && Objects.equals(image_path, shopItem.image_path) && Objects.equals(price, shopItem.price) && Objects.equals(description, shopItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, name, image_path, price, description);
    }

    @Override
    public String toString() {
        return "ShopItem{"+
                "item_id="+ item_id +
                ", name="+ name +
                ", image_path="+ image_path +
                ", price="+ price +
                ", description="+ description +"}";
    }
}
