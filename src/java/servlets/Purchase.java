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
public class Purchase {
        public int purchaseId;
        public int productId;
        public int quantity;
        public String purchaseDate;
        public int customerId;
        public String purchaseName;

    public Purchase(int purchaseId, int productId, int quantity, String purchaseDate, int customerId) {
        this.purchaseId=purchaseId;
        this.productId=productId;
        this.quantity=quantity;
        this.purchaseDate=purchaseDate;
        this.customerId=customerId;
    }
}
