package GUI;

/**
 * Created by Mathias on 30-11-2015.
 */
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class LoginScreen extends JPanel {

    private JTextField tfUsername;
    private JPasswordField tfPassword;
    private JLabel lblInfo;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JButton btnLogin;
    private JButton btnClose;

    public LoginScreen() {

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setBounds(100, 100, 600, 500);

        tfUsername = new JTextField();
        tfUsername.setColumns(10);
        tfUsername.setBounds(208, 312, 200, 26);
        add(tfUsername);

        tfPassword = new JPasswordField();
        tfPassword.setColumns(10);
        tfPassword.setBounds(208, 360, 200, 26);
        add(tfPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(208, 414, 84, 23);
        add(btnLogin);

        btnClose = new JButton("Close");
        btnClose.setBounds(324, 414, 84, 23);
        add(btnClose);

        lblInfo = new JLabel("SnakeClient DIS 2015");
        lblInfo.setBackground(Color.WHITE);
        lblInfo.setBounds(232, 167, 132, 26);
        add(lblInfo);

        lblUsername = new JLabel("Username:");
        lblUsername.setBounds(131, 318, 67, 14);
        add(lblUsername);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(131, 366, 67, 14);
        add(lblPassword);
    }

    public JTextField getTfUsername() {
        return tfUsername;
    }

    public void setTfUsername(JTextField tfUsername) {
        this.tfUsername = tfUsername;
    }

    public JTextField getTfPassword() {
        return tfPassword;
    }

    public void setTfPassword(JPasswordField tfPassword) {
        this.tfPassword = tfPassword;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnClose() {
        return btnClose;
    }

    public void addActionListener(ActionListener l) {
        btnLogin.addActionListener(l);
        btnClose.addActionListener(l);
    }

}
