//Class: Product
//Represents a product from the store, has a product number, name,
//quantity, model, manufacturer, description, clearance status, and price
//User creates products by entering the qualities listed above.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Product <T>{

    int productNumber;
    String productName;
    int productQty;
    String productModel;
    String productManufacturer;
    String productDescription;
    Boolean isClearance;
    double productPrice;

    //Generic List
//    private List<T> products;

    //Scanner class to read input from user
    Scanner userInput;

    //Constructor
//    public Product() {
//
//        //Sentinel for while loop
//        boolean end = false;
//
//        //Figure out how to make these attributes be reenter-able when the user enters a nonvalid character.
//        while(!end){
//            userInput = new Scanner(System.in);
//            try {
//                System.out.print("Enter product number (Enter a value between 0000000 and 9999999, integers only): ");
//                this.productNumber = userInput.nextInt();
//                userInput.nextLine();
//
//                System.out.print("Enter product name: ");
//                this.productName = userInput.nextLine();
//
//                System.out.print("Enter product quantity (integers only): ");
//                this.productQty = userInput.nextInt();
//                userInput.nextLine();
//
//                System.out.print("Enter product model: ");
//                this.productModel = userInput.nextLine();
//
//                System.out.print("Enter product manufacturer: ");
//                this.productManufacturer = userInput.nextLine();
//
//                System.out.print("Enter product description: ");
//                this.productDescription = userInput.nextLine();
//
//                System.out.print("Is this product on clearance? (True / False): ");
//                this.isClearance = userInput.nextBoolean();
//
//                System.out.print("Enter product price (Enter a value between $0000.00 and $9999.99): ");
//                this.productPrice = userInput.nextDouble();
//                userInput.nextLine();
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input");
//                userInput.nextLine();
//                continue;
//            }
//            end = true;
//            userInput.close();
//        }
//
//    }//end of public class Product

    //New Constructor for the text file upload method
    public Product(int productNumber, String productName, int productQty, String productModel, String productManufacturer, String productDescription, boolean isClearance, double productPrice) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.productQty = productQty;
        this.productModel = productModel;
        this.productManufacturer = productManufacturer;
        this.productDescription = productDescription;
        this.isClearance = isClearance;
        this.productPrice = productPrice;
    }

    //Getters
    public int getProductNumber() {
        return productNumber;
    }
    public String getProductName() {
        return productName;
    }
    public int getProductQty() {
        return productQty;
    }
    public String getProductModel() {
        return productModel;
    }
    public String getProductManufacturer() {
        return productManufacturer;
    }
    public String getProductDescription() {
        return productDescription;
    }
    //boolean Getters use isBoolean instead of getBoolean
    public boolean  isIsClearance() {
        return isClearance;
    }
    public double getProductPrice() {
        return productPrice;
    }

    //Setters
    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }
    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }
    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public void setIsClearance(boolean isClearance) {
        this.isClearance = isClearance;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        System.out.println("Product " + "productNumber " +" productName " + " productModel: " + " productQty " +" productManufacturer " + " productDesc " + " productClearanceStatus " + " productPrice ");
        return productNumber + " | " + productName + " | " + productQty + " | " +  productModel + " | " + productManufacturer + " | " + productDescription + " | " + isClearance + " | " + productPrice;
    }

}
