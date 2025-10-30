//Class: Product
//Represents a product from the store, has a product number, name,
//quantity, model, manufacturer, description, clearance status, and price
//User creates products by entering the qualities listed above.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Product {


    int productNumber;
    String productName;
    int productQty;
    String productModel;
    String productManufacturer;
    String productDescription;
    Boolean isClearance;
    double productPrice;

    //Scanner class to read input from user
    Scanner userInput = new Scanner(System.in);

    //Constructor
    public Product() {

        //Figure out how to make these attributes be reenterable when the user enters a nonvalid character.
        try {
            System.out.print("Enter product number (Enter a value between 0000000 and 9999999, integers only): ");
            this.productNumber = userInput.nextInt();
            userInput.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid product number");
        }

        try {
            System.out.print("Enter product name: ");
            this.productName = userInput.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid product name");
        }

        try {
            System.out.print("Enter product quantity (integers only): ");
            this.productQty = userInput.nextInt();
            userInput.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid product quantity");
        }

        try {
            System.out.print("Enter product model: ");
            this.productModel = userInput.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid product model");
        }

        try {
            System.out.print("Enter product manufacturer: ");
            this.productManufacturer = userInput.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid product manufacturer");
        }

        try {
            System.out.print("Enter product description: ");
            this.productDescription = userInput.nextLine();
        }  catch (InputMismatchException e) {
            System.out.println("Please enter a valid product description");
        }

        //how would I change this from True / False to Yes / No?
        try {
            System.out.print("Is this product on clearance? (True / False): ");
            this.isClearance = userInput.nextBoolean();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid product clearance status");
        }

        try {
            System.out.print("Enter product price (Enter a value between $0000.00 and $9999.99): ");
            this.productPrice = userInput.nextDouble();
            userInput.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid product price");
        }

    }//end of public class Product

    //New Constructor for the text file upload method
    public Product(int productNumber, String productName, int productQty,  String productModel, String productManufacturer, String productDescription, boolean isClearance, double productPrice) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.productQty = productQty;
        this.productModel = productModel;
        this.productManufacturer = productManufacturer;
        this.productDescription = productDescription;
        this.isClearance = isClearance;
        this.productPrice = productPrice;
    }

}
