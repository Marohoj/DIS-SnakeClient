package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Mathias on 01-12-2015.
 */
public class JoinScreen extends JPanel {

    private JButton btnJoin;
    private JButton btnClose;
    private JLabel lblGameId;
    private JLabel lblControls;
    private JTextField tfGameId;
    private JTextField tfControls;

    public JoinScreen(){

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setBounds(100, 100, 600, 500);

        btnJoin = new JButton("Join game");
        btnJoin.setBounds(173,390,107,23);
        add(btnJoin);

        btnClose = new JButton("Return");
        btnClose.setBounds(303, 390, 107, 23);
        add(btnClose);

        tfGameId = new JTextField();
        tfGameId.setBounds(282, 226, 116, 22);
        add(tfGameId);

        tfControls = new JTextField();
        tfControls.setBounds(282, 261, 116, 22);
        add(tfControls);

        lblGameId = new JLabel("Enter Game ID:");
        lblGameId.setBounds(182, 229, 88, 16);
        add(lblGameId);

        lblControls = new JLabel("Enter controls:");
        lblControls.setBounds(182, 264, 88, 16);
        add(lblControls);

        JLabel lblJoinAGame = new JLabel("Join a game today!");
        lblJoinAGame.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblJoinAGame.setHorizontalAlignment(SwingConstants.CENTER);
        lblJoinAGame.setBounds(200, 100, 183, 36);
        add(lblJoinAGame);

    }

    public JButton getBtnJoin() {
        return btnJoin;
    }

    public JButton getBtnClose() {
        return btnClose;
    }

    public JTextField getTfControls(){
        return tfControls;
    }

    public long getTfGameId(){
        return Long.parseLong(tfGameId.getText());
    }

    public void addActionListeners(ActionListener l){
        btnJoin.addActionListener(l);
        btnClose.addActionListener(l);

    }
}