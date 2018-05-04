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
public interface Offer {
    BigDecimal totalSavings(int quantity, BigDecimal itemPrice);
}
