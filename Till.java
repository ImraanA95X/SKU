/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sku;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author imraa
 */
public class Till {
    
    ArrayList<SKU> basket = new ArrayList<SKU>();
            
    public void scan(String productCode) {
        boolean flag = false; // boolean flag to execute error code if searched product does not exist and boolean remains false after searching ArrayList of SKU's.
        if (!productCode.equals("*")) { // '*' as input terminates user input and generates receipt
        SKU tempScan = new SKU(); // create new instance of SKU and set user input product code to productCode of this
        tempScan.setProductCode(productCode);
        SKU storeContained = new SKU(); // another instance of SKU object to reference to searched SKU, if it is found in ArrayList of SKU's.
              for (int i = 0; i < Store.mySkuArrayList.size(); i++) {
                  if(Store.mySkuArrayList.get(i).getProductCode().contains(tempScan.getProductCode())) {
                    flag = true;
                    System.out.println("Product added to basket!");
                    storeContained = (SKU) Store.mySkuArrayList.get(i);
                    basket.add(storeContained);
                    break;
        }
              }
        } else {
            getReceipt();
        }
        if (!productCode.equals("*") && flag == false) {
            System.out.println("That product does not exist!");
        }
    }
    
    
    public void getReceipt() {
        if(!basket.isEmpty()) {
        System.out.println("Your receipt:");
        for (int x = 0; x < basket.size(); x++)
        System.out.println(basket.get(x));
        BigDecimal sum = basket.stream().map(SKU::getPrice).reduce(BigDecimal::add).get(); // lambda expression to iterate through basket and sum BigDecimal prices of SKU objects
        System.out.println("Total Price: " + sum);
        } else {
            System.out.println("Your basket is empty!");
        }

}
    
    public void userInput() {
        Scanner scanner = new Scanner(System.in); // takes user input
        String input = ("1");
        while(!input.equals("*")){
            System.out.println("Please enter a product code (case-sensitive). To total your basket, input '*':");
            input = scanner.nextLine();
            scan(input);
        }
        
    }
}
