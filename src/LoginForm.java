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
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 30, 10);
        
        gbc.anchor = GridBagConstraints.CENTER;
        
        titleLabel = new JLabel("Boutique Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        container.add(titleLabel, gbc);
        
        gbc.insets = new Insets(40, 140, 10, 0);
        userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        container.add(userLabel, gbc);
        
        gbc.insets = new Insets(40, 10, 10, 0);
        userTextField = new JTextField(21);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        container.add(userTextField , gbc);
        
        gbc.insets = new Insets(10, 140, 10, 0);
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        container.add(passwordLabel, gbc);
        
        gbc.insets = new Insets(10, 10, 10, 0);
        passwordField = new JPasswordField(16);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        container.add(passwordField, gbc);
        
        gbc.insets = new Insets(0, 150, 0, 0);
        showPassword = new JCheckBox("Show Password");
        showPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        container.add(showPassword, gbc);

        gbc.insets = new Insets(40, 10, 40, 50);
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        container.add(loginButton, gbc);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.gridx = 1;
        gbc.gridy = 4;
        container.add(resetButton, gbc);
        
        signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.gridx = 2;
        gbc.gridy = 4;
        container.add(signUpButton, gbc);


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
                    frame.dispose();
                    new LoginForm();
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new LoginForm();
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

        Reciept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                j.dispose();
                recieptPanel();
            }
        });

        returnBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                j.dispose();
                new LoginForm();
            }
        });

        transact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                j.dispose();
                transaction();
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
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        employeePanel.add(titleLabel , gbc);

        // Add Button
        JButton addButton = new JButton("Add");
        addButton.setFont(new Font("Arial", Font.PLAIN, 18));
        addButton.setPreferredSize(new Dimension(150, 40));
        gbc.gridx = 0;
        gbc.gridy = 2;
        employeePanel.add(addButton, gbc);

        // View Button
        JButton viewButton = new JButton("View");
        viewButton.setFont(new Font("Arial", Font.PLAIN, 18));
        viewButton.setPreferredSize(new Dimension(150, 40));
        gbc.gridy = 3;
        employeePanel.add(viewButton, gbc);
         
        // View Button
        JButton returnBtn = new JButton("Return");
        returnBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        returnBtn.setPreferredSize(new Dimension(150, 40));
        gbc.gridy = 4;
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
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        p.add(titleLabel , gbc);


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
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        addPanel.add(titleLabel , gbc);
        
        // Employee Name
        JLabel name = new JLabel("Employee Name:");
        name.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        addPanel.add(name, gbc);
        
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JTextField nameField = new JTextField(15);
        addPanel.add(nameField, gbc);

        // Contact No
        JLabel contactNo = new JLabel("Contact No:");
        contactNo.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 3;
        addPanel.add(contactNo, gbc);

        gbc.gridx = 1;
        JTextField contactField = new JTextField(15);
        addPanel.add(contactField, gbc);

        // Designation
        JLabel designationLabel = new JLabel("Designation:");
        designationLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 4;
        addPanel.add(designationLabel, gbc);

        gbc.gridx = 1;
        JTextField designationField = new JTextField(15);
        addPanel.add(designationField, gbc);

        // Salary
        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 5;
        addPanel.add(salaryLabel, gbc);

        gbc.gridx = 1;
        JTextField salaryField = new JTextField(15);
        addPanel.add(salaryField, gbc);

        // Address
        JLabel adressLabel = new JLabel("Address:");
        adressLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 6;
        addPanel.add(adressLabel, gbc);

        gbc.gridx = 1;
        JTextField addressField = new JTextField(15);
        addPanel.add(addressField, gbc);

        // Add Button
        JButton addEmployeeButton = new JButton("Add");
        addEmployeeButton.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        addPanel.add(addEmployeeButton, gbc);

        JButton returnBtn = new JButton("Return");
        returnBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridy = 9;
        gbc.gridx = 0;
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
                String designation = designationField.getText();
                String address = addressField.getText();
                
                if (name.isEmpty() & contactField.getText().isEmpty() & designation.isEmpty() & salaryField.getText().isEmpty() & address.isEmpty()) {
                    JOptionPane.showMessageDialog(addEmployeeFrame, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    long contact = Integer.parseInt(contactField.getText());
                    long salary = Integer.parseInt(salaryField.getText());

                    Employee employee = new Employee();
                    employee.addEmployee(name, contact, address, designation, salary);
                    JOptionPane.showMessageDialog(addEmployeeFrame, "Employee Added Successfully");
                }
            }  
        });
        
        addEmployeeFrame.add(addPanel, BorderLayout.CENTER);
        addEmployeeFrame.setVisible(true);
    }
 
    void recieptPanel(){
        // Create the main frame
        JFrame frame = new JFrame("Boutique Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);

        // Create the main panel with GridLayout
        frame.setLayout(new GridLayout(1, 2, 30, 0)); 

        // Left panel for customer details and buttons
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); 

        // Customer name and text field
        JLabel nameLabel = new JLabel("Customer Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField nameField = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 0;
        leftPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2; 
        gbc.weightx = 1.0; 
        gbc.weighty = 0.3; 
        leftPanel.add(nameField, gbc);

        // Contact label and text field
        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField contactField = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 1;
        leftPanel.add(contactLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2; 
        gbc.weighty = 0.3; 
        leftPanel.add(contactField, gbc);

        // Empty space to push buttons lower
        gbc.gridy = 2;
        leftPanel.add(new JLabel(" "), gbc);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints buttonGBC = new GridBagConstraints();
        buttonGBC.fill = GridBagConstraints.HORIZONTAL;
        
        JButton submitButton = new JButton("Submit");
        JButton returnButton = new JButton("Return");

        // Add a little more space for buttons to appear smaller and lower
        buttonGBC.gridx = 0;
        buttonGBC.gridy = 0;
        buttonGBC.insets = new Insets(10, 5, 5, 5); 
        buttonPanel.add(submitButton, buttonGBC);

        buttonGBC.gridy = 1;
        buttonPanel.add(returnButton, buttonGBC);

        gbc.gridy = 3;
        gbc.gridwidth = 2; // Span both columns for button panel
        leftPanel.add(buttonPanel, gbc);

        // Right panel for items and total
        JPanel rightPanel = new JPanel(new GridLayout(11, 1, 0, 15)); 

        // Item label
        JLabel itemLabel = new JLabel("Item", JLabel.CENTER);
        itemLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rightPanel.add(itemLabel);

        // Checkboxes for items with text fields
        JCheckBox[] itemCheckBoxes = new JCheckBox[8];
        JTextField[] itemFields = new JTextField[8];
        for (int i = 0; i < 8; i++) {
            JPanel itemPanel = new JPanel(new GridLayout(1, 2)); 
            itemCheckBoxes[i] = new JCheckBox("Item" + (i + 1));
            itemCheckBoxes[i].setFont(new Font("Arial", Font.PLAIN, 14));
            itemFields[i] = new JTextField();
            itemPanel.add(itemCheckBoxes[i]);
            itemPanel.add(itemFields[i]);
            rightPanel.add(itemPanel);
        }

        // Total label
        JLabel totalLabel = new JLabel("Total $ = 0", JLabel.CENTER);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rightPanel.add(new JLabel()); // Placeholder
        rightPanel.add(totalLabel);

        // return button action listener
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                menu();
            }
        });

        // submit button action listener
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                submit();
            }
        });

        
        // Add panels to the frame
        frame.add(leftPanel);
        frame.add(rightPanel);


        // Make the frame visible
        frame.setVisible(true);
    }

    void submit (){

        JFrame f = new JFrame("Submit");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 300);

         //add panel
         JPanel panel = new JPanel();
         panel.setLayout(new BorderLayout());
         f.add(panel);

         // Create a display area
        JTextArea displayArea = new JTextArea(350, 250); 
        displayArea.setEditable(false);

        //adding scrollpanel to display area
        JScrollPane scroll = new JScrollPane(displayArea);

        panel.add(scroll);
        f.setVisible(true);

        //return button
        JButton returnBtn = new JButton("Return");
        returnBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        returnBtn.setPreferredSize(new Dimension(150, 40));
        panel.add(returnBtn,BorderLayout.SOUTH);  // add button to the bottom

        returnBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                f.dispose();
                menu();
            }
        });
    }

    void transaction(){
        JFrame f = new JFrame("Transaction");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 300);

         //add panel
         JPanel panel = new JPanel();
         panel.setLayout(new BorderLayout());
         f.add(panel);

         // Create a display area
        JTextArea displayArea = new JTextArea(350, 250); 
        displayArea.setEditable(false);

        //adding scrollpanel to display area
        JScrollPane scroll = new JScrollPane(displayArea);

        panel.add(scroll);
        f.setVisible(true);

        //return button
        JButton returnBtn = new JButton("Return");
        returnBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        returnBtn.setPreferredSize(new Dimension(150, 40));
        panel.add(returnBtn,BorderLayout.SOUTH);  // add button to the bottom

        returnBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                f.dispose();
                menu();
            }
        });
    }

}
