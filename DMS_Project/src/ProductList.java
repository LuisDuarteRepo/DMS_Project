//Class: ProductList, will work to store all the product objects made in the Products Class.
//ProductList class will store the product menu.

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ProductList {

    //array full of Product Objects from Product Class
//    Product[] product_List = new Product[30];
    Product[] product_List;

    //User input Scanner class object
    Scanner input = new Scanner(System.in);

    //count attribute that keeps track of the current product count
    public static int count;


    public ProductList() {
        this.product_List = new Product[30];
    }

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
    public void AddProduct(){

        if(count < product_List.length){
            product_List[count] = new Product();
            System.out.println("Product " + product_List[count].productNumber + " added successfully to the database.");
            count++;
        } else if (count == 30){
            System.out.println("Product database is full!");
        }//end of if else

    }//end of public void AddProduct(Product p)

    //method 3: modifyProduct
    public void modifyProduct(){

        int choice;
        Scanner ModifiedInput = new Scanner(System.in);
        Scanner attributeChoice = new Scanner(System.in);

        System.out.print("Enter product Number you wish to modify: ");
        String pNum = input.nextLine();

        for(int i = 0; i < product_List.length - 1; i++ ){
            if(parseInt(pNum) == (product_List[i].productNumber)){

                //once the number has been found, the user will choose what attribute to modify
                System.out.println(pNum + " has been found, what attribute would you like to modify?");

                do {

                    DisplayProductAttributes();
                    choice = attributeChoice.nextInt();

                    switch(choice){
                        case 1:
                            System.out.println("Enter new Product Number: ");
                            product_List[i].productNumber = ModifiedInput.nextInt();
                            break;
                        case 2:
                            System.out.println("Enter new Product Name: ");
                            product_List[i].productName = ModifiedInput.nextLine();
                            break;
                        case 3:
                            System.out.println("Enter new Product Quantity: ");
                            product_List[i].productQty = ModifiedInput.nextInt();
                            break;
                        case 4:
                            System.out.println("Enter new Product Model: ");
                            product_List[i].productModel = ModifiedInput.nextLine();
                            break;
                        case 5:
                            System.out.println("Enter new Product Manufacturer: ");
                            product_List[i].productManufacturer = ModifiedInput.nextLine();
                            break;
                        case 6:
                            System.out.println("Enter new Product Description: ");
                            product_List[i].productDescription = ModifiedInput.nextLine();
                            break;
                        case 7:
                            System.out.println("Enter new Product Clearance Status: ");
                            product_List[i].isClearance = ModifiedInput.nextBoolean();
                            break;
                        case 8:
                            System.out.println("Enter new Product Price: ");
                            product_List[i].productPrice = ModifiedInput.nextDouble();
                            break;
                        case 0:
                            System.out.println("0. Exit Modify Product");
                            return;
                        default:
                            System.out.println("Invalid choice, choose from choices 0-8.");
                    }

                }while(parseInt(pNum) == (product_List[i].productNumber));

                return;

            }
        }
    }

    //method 4: deleteProduct
    public void deleteProduct(String pNum){

        showAllProduct();

        System.out.println("Enter the product number you want to delete: ");
        int productNumber  = input.nextInt();

        for(int i = 0; i < count; i++){

            try {
                if (productNumber == product_List[i].productNumber) {
                    product_List[count - 1] = null;
                    count--;
                    System.out.println("Product " + pNum + " deleted successfully from the database.");
                    return;
                }//end of if(productNumber == productList[i].productNumber)
                else {
                    System.out.println("Product " + pNum + " does not exist in the database.");
                }
            } catch(InputMismatchException e) {
                System.out.println("Please enter a valid Product Number.");
                input.nextLine();
                i--;
            }

        }//end of for(int i = 0; i < count; i++)

    }//end of public void deleteProduct(String pNum)

    //method 5: showAllProduct
    public void showAllProduct(){

        System.out.println("Showing all products and their attributes from the database.");
        System.out.print("Product Number - ");
        System.out.print("Product Name - ");
        System.out.print("Product Quantity - ");
        System.out.print("Product Model - ");
        System.out.print("Product Manufacturer - ");
        System.out.print("Product Description - ");
        System.out.print("Product Clearance Status - ");
        System.out.println("Product Price");

        if(count == 0)
        {
            System.out.println("There are no products in the database.");
        }
        else{
            for(int i = 0; i < count; i++){
                System.out.print(count + ". ");
                System.out.print(product_List[i].productNumber);
                System.out.print("\t" + product_List[i].productName);
                System.out.print("\t" + product_List[i].productQty);
                System.out.print("\t" + product_List[i].productModel);
                System.out.print("\t" + product_List[i].productManufacturer);
                System.out.print("\t" + product_List[i].productDescription);
                System.out.print("\t" + product_List[i].isClearance);
                System.out.println("\t" + "$" + product_List[i].productPrice);
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

        for(int i = 0; i < product_List.length - 1; i++ ) {
            try{

                //checks if the product selected exists in the database.
                if(productChoice == product_List[i].productNumber){
                    System.out.println("Product is already set to clearance.");
                    input.nextLine();
                    i--;
                }

                /*if the product selected exists in the database and is not set to clearance then the user
                inputs the product number they want to change clearance the status of*/
                if(productChoice == product_List[i].productNumber){

                    product_List[i].productPrice -= (product_List[i].productPrice * .25);
                    product_List[i].isClearance = true;
                    System.out.println("Product " + product_List[i].productNumber + " has been set to be on clearance.");
                    return;

                }
            } catch(InputMismatchException e) {
                System.out.println("Please enter a valid Product Number.");
                input.nextLine();
                i--;
            }


            //maybe make this work?
//            else if (productList[i].isClearance == true)
//            {
//                System.out.println(productList[i].productNumber + " is already in clearance, would you like to remove the clearance status?");
//
//            }
        }

    }

    //Method 8: uploadProductFile
    public void uploadProductFile() throws FileNotFoundException {

        //"C:\Users\Luis\IdeaProjects\DMS_Project\123test.txt"
        System.out.println("Enter file name (Add .txt at the end): ");

        //Attribute where user will input filename
        String FilePath = input.next();

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
                    product_List[count] = new Product(parseInt(ProductStringArray[0]), ProductStringArray[1], parseInt(ProductStringArray[2]), ProductStringArray[3],
                        ProductStringArray[4], ProductStringArray[5], Boolean.parseBoolean(ProductStringArray[6]), Double.parseDouble(ProductStringArray[7])
                    );

                    System.out.println(product_List[count].productNumber + " has been added to the database.");

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