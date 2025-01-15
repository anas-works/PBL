import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginForm extends JFrame implements ActionListener {

    private DataBase user = new DataBase();

    private Container container;
    private JLabel userLabel, passwordLabel, titleLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton, resetButton;
    private JCheckBox showPassword;
    private JButton signUpButton;
    
    LoginForm(){
        setTitle("Login Page");
        setBounds(300, 90, 900, 600);   
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        container = getContentPane();
        container.setLayout(null);

        titleLabel = new JLabel("Boutique Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setSize(500, 30);
        titleLabel.setLocation(250, 30);
        container.add(titleLabel);

        userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        userLabel.setSize(100, 20);
        userLabel.setLocation(250, 150);
        container.add(userLabel);

        userTextField = new JTextField();
        userTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        userTextField.setSize(190, 30);
        userTextField.setLocation(400, 150);
        container.add(userTextField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setSize(100, 20);
        passwordLabel.setLocation(250, 220);
        container.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setSize(190, 30);
        passwordField.setLocation(400, 220);
        container.add(passwordField);

        showPassword = new JCheckBox("Show Password");
        showPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        showPassword.setSize(150, 20);
        showPassword.setLocation(400, 250);
        showPassword.addActionListener(this);
        container.add(showPassword);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
        loginButton.setSize(100, 20);
        loginButton.setLocation(300, 300);
        container.add(loginButton);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
        resetButton.setSize(100, 20);
        resetButton.setLocation(450, 300);
        container.add(resetButton);
        
        signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Arial", Font.PLAIN, 15));
        signUpButton.setSize(100, 20);
        signUpButton.setLocation(600, 300);
        container.add(signUpButton);


        resetButton.addActionListener(new ActionListener() {
            public void  actionPerformed(ActionEvent e) {
                userTextField.setText("");
                passwordField.setText("");
            }
        });

        showPassword.addActionListener(new ActionListener() {
            public void  actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                signUp();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void  actionPerformed(ActionEvent e) {
                String userText = userTextField.getText();
                String pwdText = new String(passwordField.getPassword());

                
                if (user.verifyUser(userText, pwdText)){
                    menu();
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(loginButton, "Invalid Username or Password");
                }

            }
        });

        setVisible(true);
    }


    void signUp(){
        JFrame frame = new JFrame("Sign Up");
        frame. setBounds(300, 90, 900, 600);   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("SIGNUP PAGE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        JLabel usernameLabel1 = new JLabel("Username:");
        usernameLabel1.setFont(new Font("Arial", Font.BOLD, 18)); 
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(usernameLabel1, gbc);

        JTextField usernameField1 = new JTextField(15);
        usernameField1.setFont(new Font("Arial", Font.PLAIN, 18)); 
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(usernameField1, gbc);

        // Add password label and field
        JLabel passwordLabel1 = new JLabel("Password:");
        passwordLabel1.setFont(new Font("Arial", Font.BOLD, 18)); 
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(passwordLabel1, gbc);
    
        JPasswordField passwordField1 = new JPasswordField(15);
        passwordField1.setFont(new Font("Arial", Font.BOLD, 18)); 
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(passwordField1, gbc);

        // Add the create account button
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(createAccountButton, gbc);

        JButton returnButton = new JButton("Return login");
        returnButton.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(returnButton, gbc);

       
        
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userText = usernameField1.getText();
                String psdText = new String(passwordField1.getPassword());
                
                if (userText.isEmpty() & psdText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Both fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    user.insertUser(userText, psdText);
                    JOptionPane.showMessageDialog(frame, "Account Created Successfully");
                    LoginForm loginForm = new LoginForm();
                    dispose();
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                LoginForm loginForm = new LoginForm();
            }
        });

        frame.add(panel,BorderLayout.CENTER);
        frame.setVisible(true);
    }



    void menu(){
        JFrame j = new JFrame("home Page");
        j.setSize(900, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
         
        JButton Reciept = new JButton("Reciept");
        Reciept.setFont(new Font("Arial", Font.PLAIN, 20));
        Reciept.setPreferredSize(new Dimension(200, 50));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(Reciept , gbc);

        JButton Item = new JButton("Items");
        Item.setFont(new Font("Arial", Font.PLAIN, 20));
        Item.setPreferredSize(new Dimension(200, 50));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(Item , gbc);

        JButton employee = new JButton("Employee's Info");
        employee.setFont(new Font("Arial", Font.PLAIN, 20));
        employee.setPreferredSize(new Dimension(200, 50));
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(employee, gbc);

        JButton transact = new JButton("Transaction");
        transact.setFont(new Font("Arial", Font.PLAIN, 20));
        transact.setPreferredSize(new Dimension(200, 50));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(transact , gbc);

        j.add(panel,BorderLayout.CENTER);
        j.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


}
