import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPageWithGridLayout extends JFrame {

    private JLabel titleLabel, userLabel, passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JCheckBox showPassword;
    private JButton loginButton, resetButton;

    public LoginPageWithGridLayout() {
        setTitle("Login Page");
        setBounds(300, 90, 500, 300); // x, y, width, height
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Set GridLayout for the main content pane
        setLayout(new BorderLayout());

        // Title Section
        titleLabel = new JLabel("Login Page", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Form Section
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns, with gaps

        // Username Label and TextField
        userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(userLabel);

        userTextField = new JTextField();
        userTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(userTextField);

        // Password Label and PasswordField
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(passwordField);

        // Show Password Checkbox
        formPanel.add(new JLabel()); // Empty placeholder for alignment
        showPassword = new JCheckBox("Show Password");
        showPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(showPassword);

        add(formPanel, BorderLayout.CENTER);

        // Button Section
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        buttonPanel.add(loginButton);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 16));
        buttonPanel.add(resetButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        showPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0); // Show password
                } else {
                    passwordField.setEchoChar('*'); // Hide password
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userTextField.setText("");
                passwordField.setText("");
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userTextField.getText();
                String password = new String(passwordField.getPassword());

                // Example login logic (replace with actual verification)
                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(loginButton, "Login Successful");
                } else {
                    JOptionPane.showMessageDialog(loginButton, "Invalid Username or Password");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPageWithGridLayout();
    }
}
