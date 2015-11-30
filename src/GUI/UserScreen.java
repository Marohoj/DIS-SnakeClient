package GUI;

/**
 * Created by Mathias on 30-11-2015.
 */
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionListener;

public class UserScreen extends JPanel{
    private JLabel lblInfo;
    private JButton btnStart;
    private JButton btnLoad;
    private JButton btnHighscore;
    private JButton btnCreate;
    private JButton btnDelete;
    private JButton btnLogout;

    public UserScreen() {

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setBounds(100, 100, 600, 500);

        lblInfo = new JLabel("SnakeClient DIS 2015");
        lblInfo.setBackground(Color.WHITE);
        lblInfo.setBounds(208, 13, 132, 26);
        add(lblInfo);

        btnStart = new JButton("Start Game");
        btnStart.setBounds(220, 100, 107, 23);
        add(btnStart);

        btnLoad = new JButton("Load Game");
        btnLoad.setBounds(220, 150, 107, 23);
        add(btnLoad);

        btnHighscore = new JButton("HighScore");
        btnHighscore.setBounds(220, 200, 107, 23);
        add(btnHighscore);

        btnCreate = new JButton("Create User");
        btnCreate.setBounds(220, 250, 107, 23);
        add(btnCreate);

        btnDelete = new JButton("Delete User");
        btnDelete.setBounds(220, 301, 107, 23);
        add(btnDelete);

        btnLogout = new JButton("Logout");
        btnLogout.setBounds(404, 407, 84, 23);
        add(btnLogout);
    }

    public JButton getBtnStart() {
        return btnStart;
    }

    public JButton getBtnLoad() {
        return btnLoad;
    }

    public JButton getBtnHighscore() {
        return btnHighscore;
    }

    public JButton getBtnCreate() {
        return btnCreate;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }

    public void addActionListener(ActionListener l) {
        btnStart.addActionListener(l);
        btnLoad.addActionListener(l);
        btnHighscore.addActionListener(l);
        btnCreate.addActionListener(l);
        btnDelete.addActionListener(l);
        btnLogout.addActionListener(l);
    }
}
