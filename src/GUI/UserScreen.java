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
    private JButton btnCreate;
    private JButton btnJoin;
    private JButton btnDelete;
    private JButton btnHighscore;
    private JButton btnLogout;

    public UserScreen() {

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setBounds(100, 100, 600, 500);

        lblInfo = new JLabel("SnakeClient DIS 2015");
        lblInfo.setBackground(Color.WHITE);
        lblInfo.setBounds(208, 13, 132, 26);
        add(lblInfo);

        btnCreate = new JButton("Create Game");
        btnCreate.setBounds(220, 100, 107, 23);
        add(btnCreate);

        btnJoin = new JButton("Join Game");
        btnJoin.setBounds(220, 150, 107, 23);
        add(btnJoin);

        btnDelete = new JButton("Delete Game");
        btnDelete.setBounds(220, 200, 107, 23);
        add(btnDelete);

        btnHighscore = new JButton("Highscore");
        btnHighscore.setBounds(220, 250, 107, 23);
        add(btnHighscore);

        btnLogout = new JButton("Logout");
        btnLogout.setBounds(404, 407, 84, 23);
        add(btnLogout);
    }

    public JButton getBtnCreate() {
        return btnCreate;
    }

    public JButton getBtnJoin() {
        return btnJoin;
    }

    public JButton getBtnDelete(){
        return btnDelete;
    }

    public JButton getBtnHighscore() {
        return btnHighscore;
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }

    public void addActionListener(ActionListener l) {
        btnCreate.addActionListener(l);
        btnJoin.addActionListener(l);
        btnDelete.addActionListener(l);
        btnHighscore.addActionListener(l);
        btnLogout.addActionListener(l);
    }
}
