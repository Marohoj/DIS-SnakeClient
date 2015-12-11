package GUI;

/**
 * Created by Mathias on 30-11-2015.
 */
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionListener;

//Class that extends a panel for the cardlayout
public class UserScreen extends JPanel{

    private JLabel lblInfo;
    private JButton btnCreate;
    private JButton btnJoin;
    private JButton btnDelete;
    private JButton btnHighscore;
    private JButton btnLogout;

    //Constructor class
    public UserScreen() {

        //Sets the background color, layout and bounds for the panel
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setBounds(100, 100, 600, 500);

        //Initiates JLabel
        //Sets bounds and background color and adds the label to the panel
        lblInfo = new JLabel("SnakeClient DIS 2015");
        lblInfo.setBackground(Color.WHITE);
        lblInfo.setBounds(208, 13, 132, 26);
        add(lblInfo);

        //Initiates JButton for create game
        btnCreate = new JButton("Create Game");
        btnCreate.setBounds(220, 100, 115, 23);
        add(btnCreate);

        //Initiates JButton for join game
        btnJoin = new JButton("Join Game");
        btnJoin.setBounds(220, 150, 115, 23);
        add(btnJoin);

        //Initiates JButton for delete game
        btnDelete = new JButton("Delete Game");
        btnDelete.setBounds(220, 200, 115, 23);
        add(btnDelete);

        //Initiates JButton for highscore
        btnHighscore = new JButton("Highscore");
        btnHighscore.setBounds(220, 250, 115, 23);
        add(btnHighscore);

        //Initiates JButton for Logout
        btnLogout = new JButton("Logout");
        btnLogout.setBounds(404, 407, 115, 23);
        add(btnLogout);
    }

    //Creates getters for the buttons to be called in controller class
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

    //Adds actionlisteners to buttons which is implemented in controller
    public void addActionListener(ActionListener l) {
        btnCreate.addActionListener(l);
        btnJoin.addActionListener(l);
        btnDelete.addActionListener(l);
        btnHighscore.addActionListener(l);
        btnLogout.addActionListener(l);
    }
}
