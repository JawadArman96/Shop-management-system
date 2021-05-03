/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author ASUS
 */
public class Products {
        public int productId;
        public int price;
        public String category;
        public String productName;
        public int quantity;

    public Products(int productId, int price, String category, String productName, int quantity) {
        this.productId=productId;
        this.price=price;
        this.category=category;
        this.productName=productName;
        this.quantity=quantity;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
