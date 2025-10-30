import java.io.FileNotFoundException;
import java.util.Scanner;

public class DMS_App {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner userInput = new Scanner(System.in);

        //creating object of ProductList
        ProductList product_List = new ProductList();

        //User's menu choice
        int choice;

        //do while loop for the menu
        do{
            product_List.DisplayMenu();
            choice = userInput.nextInt();

            switch(choice){
                case 1:
                    product_List.AddProduct();
                    break;
                case 2:
                    product_List.modifyProduct();
                    break;
                case 3:
                    String productNum = userInput.nextLine();
                    product_List.deleteProduct(productNum);
                    break;
                case 4:
                    product_List.addClearanceStatus();
                    break;
                case 5:
                    product_List.uploadProductFile();
                    break;
                case 6:
                    product_List.showAllProduct();
                    break;
            }
        }while(choice != 0);
    }

}
