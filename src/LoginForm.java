import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginForm extends JFrame{

    private DataBase user = new DataBase();

    private Container container;
    private JLabel userLabel, passwordLabel, titleLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton, resetButton;
    private JCheckBox showPassword;
    private JButton signUpButton;

    private int total = 0;
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    
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

        JButton returnBtn = new JButton("Return");
        returnBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        returnBtn.setPreferredSize(new Dimension(150, 40));
        gbc.gridx = 3;
        gbc.gridy = 7;
        panel.add(returnBtn , gbc);  

        
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
        
        Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                j.dispose();
                additems();
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
         
        // return Button
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
        Employee employee = new Employee();
        ArrayList<Employee> employeeList = employee.getEmployeeList();
        
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

        JTextArea displayArea = new JTextArea(30, 70);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Arial", Font.PLAIN, 16));

        StringBuilder displayText = new StringBuilder();
        for (Employee emp : employeeList) {
            displayText.append("Employee Name: ").append(emp.getName()).append("\n")
                    .append("Contact No: ").append(emp.getContact()).append("\n")
                    .append("Designation: ").append(emp.getDesignation()).append("\n")
                    .append("Salary: ").append(emp.getSalary()).append("\n")
                    .append("Address: ").append(emp.getAddress()).append("\n")
                    .append("-----------------------------------------------\n");
        }
        
        displayArea.setText(displayText.toString());

        JScrollPane scroll = new JScrollPane(displayArea);
        scroll.setPreferredSize(new Dimension(500, 400));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        p.add(scroll, gbc);

        JButton returnBtn = new JButton("Return");
        returnBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        returnBtn.setPreferredSize(new Dimension(150, 40));
        gbc.gridy = 7;
        gbc.gridx = 4;
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
                    int contact = Integer.parseInt(contactField.getText());
                    int salary = Integer.parseInt(salaryField.getText());

                    Employee employee = new Employee();
                    employee.addEmployee(name, contact, address, designation, salary);
                    JOptionPane.showMessageDialog(addEmployeeFrame, "Employee Added Successfully");
                }
            }  
        });
        
        addEmployeeFrame.add(addPanel, BorderLayout.CENTER);
        addEmployeeFrame.setVisible(true);
    }


    void additems(){
        JFrame frame = new JFrame("Add Item Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 90, 900, 600);   
        frame.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel itemNameLabel = new JLabel("Item Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(itemNameLabel, gbc);

        JTextField itemNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(itemNameField, gbc);

        JLabel priceLabel = new JLabel("Price:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(priceLabel, gbc);

        JTextField priceField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(priceField, gbc);

        JButton addButton = new JButton("Add");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(addButton, gbc);

        frame.add(inputPanel, BorderLayout.CENTER);

        JButton returnButton = new JButton("Return");
        returnButton.setPreferredSize(new Dimension(100, 30));
        JPanel returnButtonPanel = new JPanel();
        returnButtonPanel.add(returnButton);
        frame.add(returnButtonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String itemName = itemNameField.getText();
                
                if (itemName.isEmpty() & priceField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    int price = Integer.parseInt(priceField.getText());

                    Items item = new Items();
                    item.addItems(itemName, price);
                    JOptionPane.showMessageDialog(frame, "Items Added Successfully");
                }
            }
        }); 
                

        // return button action listener
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                menu();
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    
    void recieptPanel(){

        JFrame frame = new JFrame("Boutique Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 90, 900, 600);   

        frame.setLayout(new GridLayout(1, 2, 30, 0)); 

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); 

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

        gbc.gridy = 2;
        leftPanel.add(new JLabel(" "), gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints buttonGBC = new GridBagConstraints();
        buttonGBC.fill = GridBagConstraints.HORIZONTAL;
        
        JButton submitButton = new JButton("Submit");
        JButton returnButton = new JButton("Return");

        buttonGBC.gridx = 0;
        buttonGBC.gridy = 0;
        buttonGBC.insets = new Insets(10, 5, 5, 5); 
        buttonPanel.add(submitButton, buttonGBC);

        buttonGBC.gridy = 1;
        buttonPanel.add(returnButton, buttonGBC);

        gbc.gridy = 3;
        gbc.gridwidth = 2;
        leftPanel.add(buttonPanel, gbc);

        JPanel rightPanel = new JPanel(new GridLayout(11, 1, 0, 15)); 

        JLabel itemLabel = new JLabel("Item", JLabel.CENTER);
        itemLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rightPanel.add(itemLabel);

        
        Items it = new Items();
        ArrayList<Items> itemList = it.getItemList();
        
        JLabel totalLabel = new JLabel("Total $ = " + getTotal(), JLabel.CENTER);
        for (Items i : itemList) {
            JPanel itemPanel = new JPanel(new GridLayout(1, 2)); 
            JCheckBox itemCheckBoxes = new JCheckBox(i.getitemName());
            itemCheckBoxes.setFont(new Font("Arial", Font.PLAIN, 14));
            JLabel itemRate = new JLabel("$"+i.getRate());
            itemPanel.add(itemCheckBoxes);
            itemPanel.add(itemRate);
            rightPanel.add(itemPanel);
            
            itemCheckBoxes.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (itemCheckBoxes.isSelected()) {
                        total += i.getRate();
                    } else if (!itemCheckBoxes.isSelected()) {
                        total -= i.getRate();
                    }
                    setTotal(total);

                    totalLabel.setText("Total $ = " + total);
                }
            });
        }
        
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rightPanel.add(new JLabel());
        rightPanel.add(totalLabel);

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                menu();
            }
        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String customerName = nameField.getText();
                int contact = Integer.parseInt(contactField.getText());
                
                if (customerName.isEmpty() & contactField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    Customer customer = new Customer();
                    customer.addCustomer(customerName, contact);
                }
                
                frame.dispose();
                submit(customerName,contact);
            }
        });
        
        frame.add(leftPanel);
        frame.add(rightPanel);

        frame.setVisible(true);
    }

    void submit (String name, int contact){

        JFrame f = new JFrame("Submit");
        f.setBounds(300, 90, 600, 400);   

         //add panel
         JPanel panel = new JPanel();
         
         panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        f.add(panel);
         f.setVisible(true);

         // Create a display area
         JLabel nameLabel = new JLabel("Name: " + name);
         nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
         panel.add(nameLabel);

         JLabel contactLabel = new JLabel("Contact: " + contact);
         contactLabel.setFont(new Font("Arial", Font.PLAIN, 20));
         panel.add(contactLabel);

         JLabel total = new JLabel("Total Bill = $" + getTotal());
         total.setFont(new Font("Arial", Font.PLAIN, 20));
         panel.add(total);

        //return button
        JButton returnBtn = new JButton("Return");
        returnBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        returnBtn.setPreferredSize(new Dimension(150, 40));
        panel.add(returnBtn,BorderLayout.SOUTH);  // add button to the bottom

        returnBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                f.dispose();
                recieptPanel();
            }
        });
    }

            
}


