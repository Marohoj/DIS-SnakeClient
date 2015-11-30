package GUI;

/**
 * Created by Mathias on 30-11-2015.
 */
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ScreenFrame extends JFrame {
    public final String LOGIN = "login";
    public final String USERSCREEN = "userscreen";

    private LoginScreen login;
    private UserScreen userscreen;

    private JPanel contentPane;
    private CardLayout c;

    public ScreenFrame(){

        setTitle("Snake Client");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout(0, 0));
        setContentPane(contentPane);
        setVisible(true);

        login = new LoginScreen();
        login.setBackground(new Color(255, 255, 255));
        login.setBounds(100, 100, 600, 500);
        login.setLayout(null);
        login.setVisible(true);
        contentPane.add(login, LOGIN);

        userscreen = new UserScreen();
        userscreen.setBackground(new Color(255, 255, 255));
        userscreen.setBounds(100, 100, 600, 500);
        userscreen.setLayout(null);
        contentPane.add(userscreen, USERSCREEN);

        c = (CardLayout) getContentPane().getLayout();
    }

    public LoginScreen getLoginScreen(){
        return login;
    }

    public UserScreen getUserScreen(){
        return userscreen;
    }

    public void show(String card){
        c.show(this.getContentPane(), card);
    }
}
