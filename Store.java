/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sku;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author imraa
 */
public class Store {
    public static List<SKU> mySkuArrayList = new ArrayList<SKU>();
    
    public void addSKU(SKU sku) {
    mySkuArrayList.add(sku);
}
    
}
