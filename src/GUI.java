import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {

    ProductList product_List = new ProductList();

    //Attribute initialization
    //Login Page
    private static JLabel loginLabel;
    private static JFrame loginFrame;
    private static JPanel loginPanel;
    private static JLabel userLabel;
    private static JLabel passwordLabel;
    private static JTextField userInput;
    private static JPasswordField passwordInput;
    private static JButton loginButton;
    private static JLabel loginSuccessLabel;

    //DMS Page
    private static JLabel DMSLabel;
    private static JFrame DMSFrame;
    private static JPanel DMSPanel;

    //addProduct Page
    private static JFrame addProductFrame;
    private static JPanel addProductPanel;
    private static JLabel addProductLabel;

    //addProduct Text Fields
    private static JTextField addProductNumInput;
    private static JTextField addProductNameInput;
    private static JTextField addProductQtyInput;
    private static JTextField addProductModelInput;
    private static JTextField addProductManufacturerInput;
    private static JTextField addProductDescInput;
    private static JCheckBox ClearanceCheckBox;
    private static JTextField addProductPriceInput;

    //addProduct Buttons
    private static JButton addNewProductButton;
    private static JButton addProductButton;

    //modifyProduct Page
    private static JFrame modifyProductFrame;
    private static JPanel modifyProductPanel;
    private static JLabel modifyProductLabel;

    //modifyProduct Buttons
    private static JButton modifyExistingProductButton;
    private static JButton modifyProductButton;

    private static JButton deleteProductButton;
    private static JButton addClearanceStatButton;
    private static JButton uploadProductFileButton;
    private static JButton displayProductsButton;
    private static JButton logoutButton;
    private static JLabel logoutSuccessLabel;

    //back Button
    private static JButton backButton;

    //JTextArea that will display all products
    private static JTextArea productDisplayArea;

    public GUI() {

        //loginFrame initialization
        loginFrame = new JFrame();

        //DMSFrame initialization
        DMSFrame = new JFrame();

        //addProductFrame initialization
        addProductFrame = new JFrame();

        //modifyProductFrame initialization
        modifyProductFrame =  new JFrame();

        //DMSLabel initialization
        DMSLabel = new JLabel();

        //loginButton initialization
        loginButton = new JButton("Login");

        //loginLabel initialization
        loginLabel = new JLabel();

        //addProductLabel initialization
        addProductLabel =  new JLabel();

        //modifyProductLabel initialization
        modifyProductLabel = new JLabel();

        //productDisplayArea initialization
        productDisplayArea = new JTextArea(10,20);
        productDisplayArea.setEditable(false);

        //DMS Menu Button Initialization
        addNewProductButton = new JButton("Add New Product");
        modifyExistingProductButton = new JButton("Modify Existing Product");
        deleteProductButton = new JButton("Delete Product");
        addClearanceStatButton = new JButton("Add Clearance Status to Product");
        uploadProductFileButton = new JButton("Upload New Products from File");
        displayProductsButton = new JButton("Display Products");
        logoutButton = new JButton("Logout");

        //addNewProduct page Button initialization
        addProductButton = new JButton("Add Product");

        //modifyProductButton page Button initialization
        modifyProductButton = new JButton("Modify Product");

        //The content inside the loginFrame and loginPanel initialization
        loginPanel = new JPanel();
        loginPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        loginPanel.setLayout(null);
        loginPanel.add(loginButton);
        loginPanel.add(loginLabel);

        //The content inside the DMSFrame and DMSPanel initialization
        DMSPanel = new JPanel();
        DMSPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        DMSPanel.setLayout(null);
        DMSPanel.add(DMSLabel);
        DMSPanel.add(addNewProductButton);
        DMSPanel.add(modifyExistingProductButton);
        DMSPanel.add(deleteProductButton);
        DMSPanel.add(addClearanceStatButton);
        DMSPanel.add(uploadProductFileButton);
        DMSPanel.add(displayProductsButton);
        DMSPanel.add(logoutButton);

        //The content inside the addProductFrame and addProductPanel initialization
        addProductPanel = new JPanel();
        addProductPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        addProductPanel.setLayout(null);
        addProductPanel.add(addProductLabel);
        addProductPanel.add(addProductButton);

        //first text field that asks for username
        userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        loginPanel.add(userLabel);
        userInput = new JTextField(20);
        userInput.setBounds(100, 20, 160, 25);
        loginPanel.add(userInput);

        //second text field that asks for password
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        loginPanel.add(passwordLabel);
        passwordInput = new JPasswordField(20);
        passwordInput.setBounds(100, 50, 160, 25);
        loginPanel.add(passwordInput);

        //Login Window that pops out when you run the program
        loginFrame.add(loginPanel, BorderLayout.CENTER);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.setTitle("Retail Database Management System Login");
        loginFrame.pack();
        loginFrame.setVisible(true);
        loginFrame.setContentPane(loginPanel);
        loginFrame.setSize(400, 400);

        //DMS menu that the user proceeds to after logging in
        DMSFrame.add(DMSPanel, BorderLayout.CENTER);
        DMSFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DMSFrame.setTitle("Retail Database Management System Menu");
        DMSFrame.pack();
        DMSFrame.setVisible(false);
        DMSFrame.setContentPane(DMSPanel);
        DMSFrame.setSize(400, 400);

        //addProduct menu that the user proceeds to after clicking on the addNewProductButton
        addProductFrame.add(addProductPanel, BorderLayout.CENTER);
        addProductFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addProductFrame.setTitle("Add New Product Menu");
        addProductFrame.pack();
        addProductFrame.setVisible(false);
        addProductFrame.setContentPane(addProductPanel);
        addProductFrame.setSize(400, 400);

        //first text field that asks for Product Number in addProduct
        addProductLabel = new JLabel("Product Number");
        addProductLabel.setBounds(50, -5, 160, 25);
        addProductPanel.add(addProductLabel);
        addProductNumInput = new JTextField(20);
        addProductNumInput.setBounds(50, 20, 160, 25);
        addProductPanel.add(addProductNumInput);

        //Second text field that asks for Product Name in addProduct
        addProductLabel = new JLabel("Product Name");
        addProductLabel.setBounds(10, 45, 160, 25);
        addProductPanel.add(addProductLabel);
        addProductNameInput = new JTextField(20);
        addProductNameInput.setBounds(150, 45, 160, 25);
        addProductPanel.add(addProductNameInput);

        //Third text field that asks for Product Quantity in addProduct
        addProductLabel = new JLabel("Product Quantity");
        addProductLabel.setBounds(10, 70, 160, 25);
        addProductPanel.add(addProductLabel);
        addProductQtyInput = new JTextField(20);
        addProductQtyInput.setBounds(150, 70, 160, 25);
        addProductPanel.add(addProductQtyInput);

        //Fourth text field that asks for Product Model in addProduct
        addProductLabel = new JLabel("Product Model");
        addProductLabel.setBounds(10, 95, 160, 25);
        addProductPanel.add(addProductLabel);
        addProductModelInput = new JTextField(20);
        addProductModelInput.setBounds(150, 95, 160, 25);
        addProductPanel.add(addProductModelInput);

        //Fifth text field that asks for Product Manufacturer in addProduct
        addProductLabel = new JLabel("Product Manufacturer");
        addProductLabel.setBounds(10, 120, 160, 25);
        addProductPanel.add(addProductLabel);
        addProductManufacturerInput = new JTextField(20);
        addProductManufacturerInput.setBounds(150, 120, 160, 25);
        addProductPanel.add(addProductManufacturerInput);

        //Sixth text field that asks for Product Description in addProduct
        addProductLabel = new JLabel("Product Description");
        addProductLabel.setBounds(10, 145, 160, 25);
        addProductPanel.add(addProductLabel);
        addProductDescInput = new JTextField(20);
        addProductDescInput.setBounds(150, 145, 160, 25);
        addProductPanel.add(addProductDescInput);

        //Seventh field that asks for Product Clearance status in addProduct
        addProductLabel = new JLabel("Is this Product on Clearance?");
        addProductLabel.setBounds(10, 170, 160, 25);
        addProductPanel.add(addProductLabel);
        ClearanceCheckBox = new JCheckBox("Clearance");
        ClearanceCheckBox.setBounds(175, 170, 160, 25);
        ClearanceCheckBox.setSelected(false);
        addProductPanel.add(ClearanceCheckBox);

        //Eighth field that asks for Product Price in addProduct
        addProductLabel = new JLabel("Product Price");
        addProductLabel.setBounds(10, 195, 160, 25);
        addProductPanel.add(addProductLabel);
        addProductPriceInput = new JTextField(20);
        addProductPriceInput.setBounds(150, 195, 160, 25);
        addProductPanel.add(addProductPriceInput);

        //Screen that displays each new product that the user enters
        addProductPanel.add(new JScrollPane(productDisplayArea));
        productDisplayArea.setBounds(175, 210, 400, 400);

        //modifyProduct stuff
        //The content inside the modifyProductFrame and modifyProductPanel initialization
        modifyProductPanel = new JPanel();
        modifyProductPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        modifyProductPanel.setLayout(null);
        modifyProductPanel.add(modifyProductLabel);
        modifyProductPanel.add(modifyProductButton);
        modifyProductPanel.add(new JScrollPane(productDisplayArea));

        //modifyProduct menu that the user proceeds to after clicking on the addNewProductButton
        modifyProductFrame.add(modifyProductPanel, BorderLayout.CENTER);
        modifyProductFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        modifyProductFrame.setTitle("Modify Existing Product Menu");
        modifyProductFrame.pack();
        modifyProductFrame.setVisible(false);
        modifyProductFrame.setContentPane(modifyProductPanel);
        modifyProductFrame.setSize(400, 400);

        //Login Button
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userInput.getText();
                String password = passwordInput.getText();

                if(username.equals("admin") && password.equals("admin")){
                    loginSuccessLabel.setText("Successful Login.");
                    DMSFrame.setVisible(true);
                    loginFrame.setVisible(false);
                    }
                else {
                 loginSuccessLabel.setText("Incorrect username or password.");
                }
            }
        });

        //Menu Buttons
        //Add New Product Button
        addNewProductButton.setBounds(30, 50, 240, 25);
        addNewProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProductFrame.setVisible(true);
                DMSFrame.setVisible(false);

                productDisplayArea.setVisible(true);
                updateProductDisplayArea();
            }
        });

        //modifyExistingProduct Menu Button
        modifyExistingProductButton.setBounds(55,  50, 240, 25);
        modifyExistingProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyProductFrame.setVisible(true);
                DMSFrame.setVisible(false);

                productDisplayArea.setText("");
                updateProductDisplayArea();

            }
        });

        //button that the user would click to finalize their product entry
        addProductButton.setBounds(30, 250, 240, 25);
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int productNumToAdd = Integer.parseInt(addProductNumInput.getText());
                String productNameToAdd = addProductNameInput.getText();
                int productQtyToAdd = Integer.parseInt(addProductQtyInput.getText());
                String productModelToAdd = addProductModelInput.getText();
                String productManufacturerToAdd = addProductManufacturerInput.getText();
                String productDescToAdd = addProductDescInput.getText();
                Boolean productClearanceStatusToAdd = ClearanceCheckBox.isSelected();
                double productPrice = Double.parseDouble(addProductPriceInput.getText());

                product_List.GUIAddProduct(productNumToAdd, productNameToAdd, productQtyToAdd, productModelToAdd, productManufacturerToAdd, productDescToAdd, productClearanceStatusToAdd, productPrice);

                addProductFrame.setVisible(false);
                DMSFrame.setVisible(true);

            }
        });

        modifyExistingProductButton.setBounds(30, 75, 240, 25);

        deleteProductButton.setBounds(30, 100, 240, 25);
        addClearanceStatButton.setBounds(30, 125, 240, 25);
        uploadProductFileButton.setBounds(30, 150, 240, 25);
        displayProductsButton.setBounds(30, 175, 240, 25);

        //Logout Button and Action
        logoutButton.setBounds(30, 200, 240, 25);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.setVisible(true);
                DMSFrame.setVisible(false);
                logoutSuccessLabel.setText("Successful Logout.");
            }
        });

        //success label that pops up when the user successfully logs in
        loginSuccessLabel = new JLabel();
        loginSuccessLabel.setBounds(10, 110, 300, 25);
        loginPanel.add(loginSuccessLabel);

        //success logoutLabel that pops up when the user successfully logs out
        logoutSuccessLabel = new JLabel();
        logoutSuccessLabel.setBounds(10, 110, 300, 25);
        loginPanel.add(logoutSuccessLabel);

    }

    //method that closes the previous Frame
    private void closeFrame () {
        WindowEvent windowEvent = new WindowEvent(loginFrame, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowEvent);
    }

    //method that updates the productDisplayArea
    public void updateProductDisplayArea(){
        //clear the previous content from the fields
//        addProductNumInput.setText("");
//        addProductNameInput.setText("");
//        addProductQtyInput.setText("");
//        addProductModelInput.setText("");
//        addProductManufacturerInput.setText("");
//        addProductDescInput.setText("");
//        addProductPriceInput.setText("");

        //Make it so that products are displayed to the user after being added.
        for(Product product : product_List.GetProducts())
        {
            productDisplayArea.append(product + "\n");
        }

    }

}
