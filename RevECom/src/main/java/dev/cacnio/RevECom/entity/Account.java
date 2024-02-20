package dev.cacnio.RevECom.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

/*
 * This class models a user of our eShop
 */
@Entity
public class Account {
    /*
     * TODO: Fields
     *  id (autogenerate?) X
     *  email X
     *  password X
     *  cart (container class?) X
     *  order history (stretch goal)
     *  favorites list (stretch goal)
     * 
     * TODO: Methods
     *  Constructor X
     *  Getters X
     *  Setters X
     *  View Cart
     *  add to cart
     *  remove from cart
     *  checkout
     *  equals override X
     *  toString override X
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer account_id;

     private String email;

     private String password;

     public Account(){} //default constructor

     public Account(String email, String password){ //create new account from user input
         this.email = email;
         this.password = password;
     }
        /*cart = new Cart();
     }*/

     public Account(Integer account_id, String email, String password){ //retrieve account from database
        this.account_id = account_id;
        this.email = email;
        this.password = password;
     }

     //accessor methods
     public Integer getAccountId(){
        return account_id;
     }
     public String getEmail(){
        return email;
     }
     public String getPassword(){
        return password;
     }


     //mutator methods
     public void setAccountId(Integer account_id){
        this.account_id = account_id;
     }
     public void setUserEmail(String email){
        this.email = email;
     }
     public void setPassword(String password){
        this.password = password;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(account_id, account.account_id) && Objects.equals(email, account.email) && Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_id, email, password);
    }

    @Override
    public String toString() {
        return "Account{"+
                "account_id="+ account_id +
                ", email="+ email +
                ", password="+ password + "}";
    }
}
