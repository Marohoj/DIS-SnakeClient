package GUI;

import Logic.ClientMethods;
import Logic.Controller;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Mathias on 01-12-2015.
 */
public class JoinScreen extends JPanel {

    private JButton btnJoin;
    private JButton btnClose;
    private JLabel lblGameName;
    private JLabel lblCreated;
    private JList listGames;;

    public JoinScreen(){

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setBounds(100, 100, 600, 500);

        btnJoin = new JButton("Join game");
        btnJoin.setBounds(175,430,109,19);
        add(btnJoin);

        btnClose = new JButton("Return");
        btnClose.setBounds(296,430,109,19);
        add(btnClose);

        lblGameName = new JLabel("Game name");
        lblGameName.setBounds(122,59,75,19);
        add(lblGameName);

        lblCreated = new JLabel("Created");
        lblCreated.setBounds(383,52,63,32);
        add(lblCreated);

        listGames = new JList();
        listGames.setPreferredSize(new Dimension(473,277));
        listGames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listGames.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listGames.setVisibleRowCount(-1);
        add(listGames);

    }

    public JButton getBtnJoin() {
        return btnJoin;
    }

    public JButton getBtnClose() {
        return btnClose;
    }

    public void addActionisteners(ActionListener l){
        btnJoin.addActionListener(l);
        btnClose.addActionListener(l);
        //tableGames.addActionListener(l);
    }

}