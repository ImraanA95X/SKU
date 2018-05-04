/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sku;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author imraa
 */
public class SKU implements Serializable {
    
    private String productCode;
    private String description;
    BigDecimal price;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        // TODO code application logic here
        Store myStore = new Store();
        File f = new File(" "); // MODIFY PARAMETER TO SPECIFY FILE-PATH OF FILE FROM WHICH SKU PRODUCTS ARE TO BE READ.
        populateStore(parser(f)); // pass text file to parser method
        Till myTill = new Till();
        myTill.userInput();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return ("Product Code: " + this.getProductCode() + "    " + "Description: " + this.getDescription() + "     " + "Price: " + this.getPrice() + "\n"); // customer String representation of SKU object
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.productCode);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
		if (obj == null || obj.getClass() != getClass()) {
			result = false;
		} else {
                    final SKU other = (SKU) obj;
                    if (this.productCode == other.getProductCode()) { // allows equals method to check if objects match via property
                        result = true;
                    }
                }
                return result;
    }
    
    public static List<String[]> parser(File pathToTextFile) {
    List<String[]> tokenizeList = new ArrayList<>();
    try {
        // create a Buffered Reader object instance with a FileReader
            BufferedReader br = new BufferedReader(new FileReader(pathToTextFile));

            // read from first line from the text file
            String fileRead = br.readLine();
            // skip first line from sample file as it contains headings
            int lineNumber = 0;
            
        // loop until all lines are read
        while (fileRead != null)
        {
            if(lineNumber == 0) {
                            lineNumber++;
                            fileRead = br.readLine();
                            continue;
                        }
                 
                        lineNumber++;
                        
            // use string.split to load a string array with the values from each line of
            // the file, using a tab as the delimiter
            String[] tokenize = fileRead.split("\t");
            tokenizeList.add(tokenize);

            // read next line before looping
            // if end of file reached
            fileRead = br.readLine();
        }

        // close file stream
        br.close();
        
    }// handle exceptions
    catch (FileNotFoundException fnfe)
    {
        System.out.println("file not found");
    }
    catch (IOException ioe)
    {
        ioe.printStackTrace();
    }
    return tokenizeList;
}
    
    // method to loop through parsed data and store relevant values in SKU ArrayList
    public static void populateStore(List<String[]> tokenizeList) {
    for(String[] tokenize: tokenizeList) {
         String tempProductCode = tokenize[0];
         String tempDescription = tokenize[1];
         BigDecimal tempPrice = new BigDecimal(tokenize[2]);

         SKU tempObj = new SKU();
         tempObj.setProductCode(tempProductCode);
         tempObj.setDescription(tempDescription);
         tempObj.setPrice(tempPrice);

         // add to array list
         Store.mySkuArrayList.add(tempObj);
    }
}
}
