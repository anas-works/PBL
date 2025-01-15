import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{

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
        titleLabel.setSize(500, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gbc.gridx = 0;
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
                    frame.dispose();
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                LoginForm loginForm = new LoginForm();
                frame.dispose();
            }
        });

        frame.add(panel,BorderLayout.CENTER);
        frame.setVisible(true);
    }



    void menu(){
        JFrame j = new JFrame("Main Menu");
        j.setBounds(300, 90, 900, 600);   

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
         
        titleLabel = new JLabel("Boutique Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setSize(500, 30);
        titleLabel.setLocation(250, 10);
        panel.add(titleLabel);

        JButton employee = new JButton("Employee's Info");
        employee.setFont(new Font("Arial", Font.PLAIN, 20));
        employee.setPreferredSize(new Dimension(200, 50));
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(employee, gbc);

        JButton Item = new JButton("Items");
        Item.setFont(new Font("Arial", Font.PLAIN, 20));
        Item.setPreferredSize(new Dimension(200, 50));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(Item , gbc);

        JButton Reciept = new JButton("Reciept");
        Reciept.setFont(new Font("Arial", Font.PLAIN, 20));
        Reciept.setPreferredSize(new Dimension(200, 50));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(Reciept , gbc);

        JButton transact = new JButton("Transaction");
        transact.setFont(new Font("Arial", Font.PLAIN, 20));
        transact.setPreferredSize(new Dimension(200, 50));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(transact , gbc);

        JButton returnBtn = new JButton("Return");
        returnBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        returnBtn.setPreferredSize(new Dimension(150, 40));
        gbc.gridx = 3;
        gbc.gridy = 7;
        panel.add(returnBtn, gbc);


        
        employee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                j.dispose();
                employeePanel();
            }
        });

        returnBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                j.dispose();
                LoginForm login = new LoginForm();
            }
        });



        j.add(panel,BorderLayout.CENTER);
        j.setVisible(true);
    }


    void employeePanel(){
        JFrame employeeFrame = new JFrame("Employee Info");
        employeeFrame.setBounds(300, 90, 900, 600);   
        employeeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        JPanel employeePanel = new JPanel();
        employeePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        titleLabel = new JLabel("Boutique Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setSize(500, 30);
        titleLabel.setLocation(250, 10);
        employeeFrame.add(titleLabel);

        // Add Button
        JButton addButton = new JButton("Add");
        addButton.setFont(new Font("Arial", Font.PLAIN, 18));
        addButton.setPreferredSize(new Dimension(150, 40));
        gbc.gridx = 0;
        gbc.gridy = 0;
        employeePanel.add(addButton, gbc);

        // View Button
        JButton viewButton = new JButton("View");
        viewButton.setFont(new Font("Arial", Font.PLAIN, 18));
        viewButton.setPreferredSize(new Dimension(150, 40));
        gbc.gridy = 1;
        employeePanel.add(viewButton, gbc);
         
        // View Button
        JButton returnBtn = new JButton("Return");
        returnBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        returnBtn.setPreferredSize(new Dimension(150, 40));
        gbc.gridy = 2;
        employeePanel.add(returnBtn, gbc);

        viewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            employeeFrame.dispose();
            viewEmployee();
        }
        });

        addButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            employeeFrame.dispose();
            addEmployee();
        }
        });

        returnBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            employeeFrame.dispose();
            menu();
        }
        });


            // Add employeePanel to employeeFrame                                                                                                                                                                                                                                                                                                                                                                       
        employeeFrame.add(employeePanel, BorderLayout.CENTER);
        employeeFrame.setVisible(true);
                  
    }


    void viewEmployee(){
        JFrame viewEmployeeFrame = new JFrame("View Employees");
        viewEmployeeFrame.setBounds(300, 90, 900, 600);   
        viewEmployeeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        titleLabel = new JLabel("Boutique Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setSize(500, 30);
        titleLabel.setLocation(250, 10);
        gbc.gridy = 1;
        p.add(titleLabel);


        JButton returnBtn = new JButton("Return");
        returnBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        returnBtn.setPreferredSize(new Dimension(150, 40));
        gbc.gridy = 2;
        p.add(returnBtn, gbc);

        returnBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                viewEmployeeFrame.dispose();
                employeePanel();
            }
        });


        viewEmployeeFrame.add(p,BorderLayout.CENTER);
        viewEmployeeFrame.setVisible(true);
    }


    void addEmployee(){      
        JFrame addEmployeeFrame = new JFrame("Add Employee");
        addEmployeeFrame.setBounds(300, 90, 900, 600);   
        addEmployeeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel addPanel = new JPanel();
        addPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        titleLabel = new JLabel("Boutique Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setSize(500, 30);
        titleLabel.setLocation(250, 10);
        addEmployeeFrame.add(titleLabel);

        // Employee Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        addPanel.add(new JLabel("Employee Name:"), gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(15);
        addPanel.add(nameField, gbc);

        // Contact No
        gbc.gridx = 0;
        gbc.gridy = 2;
        addPanel.add(new JLabel("Contact No:"), gbc);

        gbc.gridx = 1;
        JTextField contactField = new JTextField(15);
        addPanel.add(contactField, gbc);

        // Designation
        gbc.gridx = 0;
        gbc.gridy = 3;
        addPanel.add(new JLabel("Designation:"), gbc);

        gbc.gridx = 1;
        JTextField designationField = new JTextField(15);
        addPanel.add(designationField, gbc);

        // Salary
        gbc.gridx = 0;
        gbc.gridy = 4;
        addPanel.add(new JLabel("Salary:"), gbc);

        gbc.gridx = 1;
        JTextField salaryField = new JTextField(15);
        addPanel.add(salaryField, gbc);

        // Address
        gbc.gridx = 0;
        gbc.gridy = 5;
        addPanel.add(new JLabel("Address:"), gbc);

        gbc.gridx = 1;
        JTextField addressField = new JTextField(15);
        addPanel.add(addressField, gbc);

        // Add Button
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        JButton addEmployeeButton = new JButton("Add");
        addPanel.add(addEmployeeButton, gbc);

        JButton returnBtn = new JButton("Return");
        returnBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        returnBtn.setPreferredSize(new Dimension(150, 40));
        gbc.gridy = 8;
        gbc.gridx = 4;
        addPanel.add(returnBtn, gbc);

        returnBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                addEmployeeFrame.dispose();
                employeePanel();
            }
        });

        // ActionListener for Add Employee Button
        addEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String name = nameField.getText();
                String contact = contactField.getText();
                String designation = designationField.getText();
                String salary = salaryField.getText();
                String address = addressField.getText();
        
                // You can process or save the data here
                JOptionPane.showMessageDialog(addEmployeeButton, "Data saved successfully!");
        
                // Clear fields after adding
                nameField.setText("");
                contactField.setText("");
                designationField.setText("");
                salaryField.setText("");
                addressField.setText("");
            }  
        });
        
        addEmployeeFrame.add(addPanel, BorderLayout.CENTER);
        addEmployeeFrame.setVisible(true);
    }


}
