import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private Container container;
    private JLabel userLabel, passwordLabel, titleLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton, resetButton;
    private JCheckBox showPassword;
    private JButton signUpButton;

     Main() {
        setTitle("Login Page");
        setBounds(300, 90, 900, 600);   
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        container = getContentPane();
        container.setLayout(null);

        titleLabel = new JLabel("Boutiquee Management System");
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
        loginButton.addActionListener(this);
        container.add(loginButton);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
        resetButton.setSize(100, 20);
        resetButton.setLocation(450, 300);
        resetButton.addActionListener(this);
        container.add(resetButton);

        signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Arial", Font.PLAIN, 15));
        signUpButton.setSize(100, 20);
        signUpButton.setLocation(600, 300);
        signUpButton.addActionListener(this);
        container.add(signUpButton);

        setVisible(true);
    }
   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton) {
        JFrame frame = new JFrame("Sign Up");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        JLabel titleLabel = new JLabel("SIGNUP PAGE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
         gbc.insets = new Insets(10, 10, 10, 10);

        JLabel usernameLabel1 = new JLabel("Username:");
        usernameLabel1.setFont(new Font("Arial", Font.BOLD, 18)); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(usernameLabel1, gbc);

        JTextField usernameField1 = new JTextField(25);
        usernameField1.setFont(new Font("Arial", Font.PLAIN, 18)); 
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(usernameField1, gbc);

        // Add password label and field
        JLabel passwordLabel1 = new JLabel("Password:");
        passwordLabel1.setFont(new Font("Arial", Font.BOLD, 18)); 
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(passwordLabel1, gbc);
    
        JPasswordField passwordField1 = new JPasswordField(25);
        passwordField1.setFont(new Font("Arial", Font.BOLD, 18)); 
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(passwordField1, gbc);

        // Add confirm password label and field
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(confirmPasswordLabel, gbc);

         JPasswordField confirmPasswordField = new JPasswordField(25);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(confirmPasswordField, gbc);

        // Add the create account button
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(createAccountButton, gbc);

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            String userText = usernameField1.getText();
            String pwdText = new String(passwordField1.getPassword());

            if (userText.isEmpty() || pwdText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Both fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Account Created Successfully");
                usernameField1.setText("");
                passwordField1.setText("");
            }
            }
        });

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(panel,BorderLayout.CENTER);
        
        frame.setVisible(true);

     }
        else if (e.getSource() == loginButton) {
            String userText = userTextField.getText();
            String pwdText = new String(passwordField.getPassword());
            if (userText.equalsIgnoreCase("admin") && pwdText.equals("admin")) {
                lobby();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        } else if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
            
        } else if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }

    void lobby(){
        JFrame j = new JFrame("Boutiquee Managemant System");
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

                // Add ActionListener to Employee's Info button
                employee.addActionListener(e -> {
                // Open a new panel with "Add" and "View" buttons
                JFrame employeeFrame = new JFrame("Employee Info");
                employeeFrame.setSize(400, 300);
                employeeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

                JPanel employeePanel = new JPanel();
                employeePanel.setLayout(new GridBagLayout());
                GridBagConstraints empGbc = new GridBagConstraints();
                empGbc.insets = new Insets(10, 10, 10, 10);

                // Add Button
                JButton addButton = new JButton("Add");
                addButton.setFont(new Font("Arial", Font.PLAIN, 18));
                addButton.setPreferredSize(new Dimension(150, 40));
                empGbc.gridx = 0;
                empGbc.gridy = 0;
                employeePanel.add(addButton, empGbc);

                 // View Button
                 JButton viewButton = new JButton("View");
                 viewButton.setFont(new Font("Arial", Font.PLAIN, 18));
                 viewButton.setPreferredSize(new Dimension(150, 40));
                 empGbc.gridy = 1;
                 employeePanel.add(viewButton, empGbc);

                 // Add ActionListener to Add button
                 addButton.addActionListener(ev -> {
                    // Open a new frame for adding employee details
                    JFrame addEmployeeFrame = new JFrame("Add Employee");
                    addEmployeeFrame.setSize(500, 400);
                    addEmployeeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
                    JPanel addPanel = new JPanel();
                    addPanel.setLayout(new GridBagLayout());
                    GridBagConstraints addGbc = new GridBagConstraints();
                    addGbc.insets = new Insets(10, 10, 10, 10);
    
                    // Employee Name
                    addGbc.gridx = 0;
                    addGbc.gridy = 0;
                    addPanel.add(new JLabel("Employee Name:"), addGbc);
    
                    addGbc.gridx = 1;
                    JTextField nameField = new JTextField(15);
                    addPanel.add(nameField, addGbc);
    
                    // Contact No
                    addGbc.gridx = 0;
                    addGbc.gridy = 1;
                    addPanel.add(new JLabel("Contact No:"), addGbc);
    
                    addGbc.gridx = 1;
                    JTextField contactField = new JTextField(15);
                    addPanel.add(contactField, addGbc);
    
                    // Designation
                    addGbc.gridx = 0;
                    addGbc.gridy = 2;
                    addPanel.add(new JLabel("Designation:"), addGbc);
    
                    addGbc.gridx = 1;
                    JTextField designationField = new JTextField(15);
                    addPanel.add(designationField, addGbc);
    
                    // Salary
                    addGbc.gridx = 0;
                    addGbc.gridy = 3;
                    addPanel.add(new JLabel("Salary:"), addGbc);
    
                    addGbc.gridx = 1;
                    JTextField salaryField = new JTextField(15);
                    addPanel.add(salaryField, addGbc);
    
                    // Address
                    addGbc.gridx = 0;
                    addGbc.gridy = 4;
                    addPanel.add(new JLabel("Address:"), addGbc);
    
                    addGbc.gridx = 1;
                    JTextField addressField = new JTextField(15);
                    addPanel.add(addressField, addGbc);
    
                    // Add Button
                    addGbc.gridx = 0;
                    addGbc.gridy = 5;
                    addGbc.gridwidth = 2;
                    JButton addEmployeeButton = new JButton("Add");
                    addPanel.add(addEmployeeButton, addGbc);
                    
                    addEmployeeFrame.add(addPanel, BorderLayout.CENTER);
                    addEmployeeFrame.setVisible(true);
                });

            // Add employeePanel to employeeFrame
            employeeFrame.add(employeePanel, BorderLayout.CENTER);
            employeeFrame.setVisible(true);

      });

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

    public static void main(String[] args) {
        new Main();
        
    }
}