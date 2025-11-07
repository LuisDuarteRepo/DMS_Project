//Class: ProductList, will work to store all the product objects made in the Products Class.
//ProductList class will store the product menu.

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;


public class ProductList {

    //array List full of Product Objects from Product Class
    private static List<Product> Products = new ArrayList<>();

    //Getter and setter for Products
    public List<Product> GetProducts(){
        return Products;
    }
    public void SetProducts(List<Product> product){
        this.Products = product;
    }

    //User input Scanner class object
    static Scanner input = new Scanner(System.in);

    //count attribute that keeps track of the current product count
    public static int count;

    //method 1: DisplayMenu
    public void DisplayMenu(){

        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("1. Add Product");
        System.out.println("2. Modify Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Add Clearance Status to Product");
        System.out.println("5. Upload Products from File");
        System.out.println("6. Display All Products");
        System.out.println("0. Exit Program");
        System.out.println("----------------------------------------------------------------------------------------------------------");

    }//end of public void displayMenu()

    //method 2: AddProduct
    public static void ConsoleAddProduct(){
//        int productNumInput = 0; figure out how to get the try catch exception to make the user reenter the input.
//
//        try {
//            System.out.print("Enter product number (Enter a value between 0000000 and 9999999, integers only): ");
//            productNumInput = input.nextInt();
//        } catch (InputMismatchException e){
//            System.out.println("Please enter a valid product number");
//        }

        System.out.print("Enter product number (Enter a value between 0000000 and 9999999, integers only): ");
        int productNumInput = input.nextInt();

        System.out.print("Enter product name: ");
        String productNameInput = input.next();

        System.out.print("Enter product quantity (integers only): ");
        int productQtyInput = input.nextInt();

        System.out.print("Enter product model: ");
        String productModelInput = input.next();

        System.out.print("Enter product manufacturer: ");
        String productManufacturerInput = input.next();

        System.out.print("Enter product description: ");
        String productDescriptionInput = input.next();

        System.out.print("Is this product on clearance? (True / False): ");
        boolean isClearanceInput = input.nextBoolean();

        System.out.print("Enter product price (Enter a value between $0000.00 and $9999.99): ");
        double productPriceInput = input.nextDouble();

        Product newProduct = new Product(productNumInput, productNameInput, productQtyInput, productModelInput, productManufacturerInput, productDescriptionInput, isClearanceInput,productPriceInput);
        Products.add(newProduct);

        System.out.println("Product " + Products.toString());
        System.out.println("Has been added successfully to the database.");
        count++;

        if (count == 30){
            System.out.println("Product database is full!");
        }//end of if else

    }//end of public void AddProduct(Product p)

    //method that adds product from GUI
    public static void GUIAddProduct(int productNumber, String productName, int productQty, String productModel, String productManufacturer, String productDescription, boolean isClearance, double productPrice){

        Product newProduct = new Product(productNumber, productName, productQty, productModel, productManufacturer, productDescription, isClearance,productPrice);
        Products.add(newProduct);

        System.out.println("Product " + Products.toString());
        System.out.println("Has been added successfully to the database.");
        count++;

        if (count == 30){
            System.out.println("Product database is full!");
        }//end of if else

    }//end of public void AddProduct(Product p)

    //method 3: modifyProduct
    public void modifyProduct(){

        int choice;
        Scanner ModifiedInput = new Scanner(System.in);
        Scanner attributeChoice = new Scanner(System.in);

        showAllProduct();

        input.nextLine(); //eating new line to get user input
        System.out.print("Enter product Number you wish to modify: ");
        String pNum = input.nextLine();

        for(int i = 0; i < Products.size(); i++){
            if(parseInt(pNum) == (Products.get(i).productNumber)){
                //once the number has been found, the user will choose what attribute to modify
                System.out.println(Products.get(i).productNumber + " has been found, what attribute would you like to modify?");

                do {

                    DisplayProductAttributes();
                    choice = attributeChoice.nextInt();

                    switch(choice){
                        case 1:
                            System.out.println("Current Product Number: " + Products.get(i).productNumber);
                            System.out.println("Enter new Product Number: ");
                            Products.get(i).productNumber = ModifiedInput.nextInt();
                            break;
                        case 2:
                            System.out.println("Current Product Name: " + Products.get(i).productName);
                            System.out.println("Enter new Product Name: ");
                            Products.get(i).productName = ModifiedInput.nextLine();
                            break;
                        case 3:
                            System.out.println("Current Product Quantity: " + Products.get(i).productQty);
                            System.out.println("Enter new Product Quantity: ");
                            Products.get(i).productQty = ModifiedInput.nextInt();
                            break;
                        case 4:
                            System.out.println("Current Product Model: " + Products.get(i).productModel);
                            System.out.println("Enter new Product Model: ");
                            Products.get(i).productModel = ModifiedInput.nextLine();
                            break;
                        case 5:
                            System.out.println("Current Product Manufacturer: " + Products.get(i).productManufacturer);
                            System.out.println("Enter new Product Manufacturer: ");
                            Products.get(i).productManufacturer = ModifiedInput.nextLine();
                            break;
                        case 6:
                            System.out.println("Current Product Description: " + Products.get(i).productDescription);
                            System.out.println("Enter new Product Description: ");
                            Products.get(i).productDescription = ModifiedInput.nextLine();
                            break;
                        case 7:
                            System.out.println("Current Product Clearance Status: " + Products.get(i).isClearance);
                            System.out.println("Enter new Product Clearance Status: ");
                            Products.get(i).isClearance = ModifiedInput.nextBoolean();
                            break;
                        case 8:
                            System.out.println("Current Product Price: " + Products.get(i).productPrice);
                            System.out.println("Enter new Product Price: ");
                            Products.get(i).productPrice = ModifiedInput.nextDouble();
                            break;
                        case 0:
                            System.out.println("0. Exit Modify Product");
                            return;
                        default:
                            System.out.println("Invalid choice, choose from choices 0-8.");
                    }

                }while(parseInt(pNum) == (Products.get(i).productNumber));

                return;

            }
        }
    }

    //method 4: deleteProduct
    public void deleteProduct(){

        showAllProduct();
        int targetProduct = 0;
        System.out.println("Enter the product number you want to delete: ");
        try {
            targetProduct = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid Product number.");
            return;
        }

        for(int i = 0; i < Products.size(); i++){
            try {
                if (targetProduct == Products.get(i).productNumber) {
                    Products.remove(i);
                    System.out.println(targetProduct + " deleted successfully from the database.");
                    input.nextLine();
                    return;
                }//end of if(productNumber == Products.get(i).productNumber)
                else {
                    System.out.println("Product " + Products.get(i).productNumber + " does not exist in the database.");
                }
            } catch(InputMismatchException e) {
                System.out.println("Please enter a valid Product Number.");
                input.nextLine();
            }
        }


    }//end of public void deleteProduct(String pNum)

    //method 5: showAllProduct
    public void showAllProduct(){

        System.out.println("Showing all products and their attributes from the database.");

        if(count == 0)
        {
            System.out.println("There are no products in the database.");
        }
        else{
            for(Product p : Products){
                System.out.println(p.toString());
            }
        }

    }

    //Method 6: DisplayProductAttributes menu for the modifyProduct method
    public void DisplayProductAttributes(){

        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("1. Product Number.");
        System.out.println("2. Product Name.");
        System.out.println("3. Product Quantity.");
        System.out.println("4. Product Model.");
        System.out.println("5. Product Manufacturer.");
        System.out.println("6. Product Description");
        System.out.println("7. Product Clearance Status.");
        System.out.println("8. Product Price.");
        System.out.println("9. Exit Modify Product.");
        System.out.println("----------------------------------------------------------------------------------------------------------");

    }//end of public void displayMenu()

    //Method 7: addClearanceStatus
    public void addClearanceStatus(){

        showAllProduct();

        System.out.println("Which product would you like to change the clearance status of?");
        int productChoice = input.nextInt();
        boolean clearance = true;

        for(int i = 0; i < Products.size(); i++ ) {
            try{

                //checks if the product selected exists in the database.
                if(clearance == Products.get(i).isClearance){
                    System.out.println("Product is already set to clearance.");
                    input.nextLine();
                    i--;
                }

                /*if the product selected exists in the database and is not set to clearance then the user
                inputs the product number they want to change clearance the status of*/
                if(productChoice == Products.get(i).productNumber){

                    Products.get(i).productPrice -= (Products.get(i).productPrice * .25);
                    Products.get(i).isClearance = true;
                    System.out.println("Product " + Products.get(i).productNumber + " has been set to be on clearance.");
                    return;

                }
            } catch(InputMismatchException e) {
                System.out.println("Please enter a valid Product Number."); //I want the user to have to reenter the product number unless there are none.
                input.nextLine();
                i--;
            }
            /* Infinite loop starts after user tries to change the clearance status of
             product that doesn't exist in the database*/
            catch(NullPointerException e){
                System.out.println("That product number is not in the database.");
                input.nextLine();
                break; //break fixes the infinite loop, but I want the user to have to reenter the product number unless there are none.
            }

        }

    }

    //Method 8: uploadProductFile
    public void uploadProductFile() throws FileNotFoundException {

        //"C:\Users\Luis\IdeaProjects\DMS_Project\123test.txt"
        System.out.println("Enter file name (Add .txt at the end): ");

        //Attribute where user will input filename
        String FilePath = input.nextLine();

        //Attribute that reads each line in the file
        String fileLine = " ";

        File productFile = new File(FilePath);

        try{

            BufferedReader br = new BufferedReader(new FileReader(FilePath));

            if(productFile.exists()){
                System.out.println("Product #: " + " Product Name: " + " Product Qty: " + " Product Model: " + " Product Manufacturer: " + " Product Clearance Status: " + " Product Price: ");
                while((fileLine = br.readLine()) != null)
                {

                    //reads and prints the information separated by commas from the text file
                    String[] ProductStringArray = fileLine.split(", ");
                    System.out.println((count + 1) + " " + ProductStringArray[0] + "," + ProductStringArray[1] + "," + ProductStringArray[2] +
                    "," + ProductStringArray[3] + "," + ProductStringArray[4] + "," + ProductStringArray[5] + "," + ProductStringArray[6] +
                    ", $" +  ProductStringArray[7]);

                    //Convert the data read from the text file into their respective data types
                    Products.add(new Product(parseInt(ProductStringArray[0]), ProductStringArray[1], parseInt(ProductStringArray[2]), ProductStringArray[3],
                        ProductStringArray[4], ProductStringArray[5], Boolean.parseBoolean(ProductStringArray[6]), Double.parseDouble(ProductStringArray[7])
                    ));

                    System.out.println(ProductStringArray[0] + " has been added to the database.");

                    count++;

                }

            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found");
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("Error reading file");
        }

    }

}//end of public class ProductList