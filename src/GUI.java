import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private static JLabel label;
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel userLabel;
    private static JLabel passwordLabel;
    private static JTextField userInput;
    private static JPasswordField passwordInput;
    private static JButton loginButton;
    private static JLabel successLabel;

    public GUI(){

        //frame initialization
        frame = new JFrame();

        //loginButton initialization
        loginButton = new JButton("Login");

        //label initialization
        label = new JLabel();

        //The content inside the frame
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(null);
        panel.add(loginButton);
        panel.add(label);

        //first text field that asks for username
        userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        //second text field that asks for password
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        //Window that pops out when you run the program
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Retail Database Management System");
        frame.pack();
        frame.setVisible(true);
        frame.setContentPane(panel);
        frame.setSize(400,400);

        //Login Button
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(this);


        //success label that pops up when the user successfully logs in
        successLabel = new JLabel();
        successLabel.setBounds(10, 110, 300, 25);
        panel.add(successLabel);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userInput.getText();
        String password = passwordInput.getText();
        System.out.println("Valid username and password.");

        if(username.equals("admin") || password.equals("admin")){
            successLabel.setText("Successful Login.");
        }
        else {
            successLabel.setText("Incorrect username or password.");
        }
    }
}
