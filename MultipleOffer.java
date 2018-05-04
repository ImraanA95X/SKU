/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sku;

import java.math.BigDecimal;

/**
 *
 * @author imraa
 */
public class MultipleOffer implements Offer {
    
    MultipleOffer (int c, int t) {
        int count = c;
        int totalPrice = t;
    }

    @Override
    public BigDecimal totalSavings(int quantity, BigDecimal itemPrice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
