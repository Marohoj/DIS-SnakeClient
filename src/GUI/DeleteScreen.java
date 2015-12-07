package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Mathias on 01-12-2015.
 */
public class DeleteScreen extends JPanel {

    private JButton btnDelete;
    private JButton btnClose;
    private JLabel lblDeleteGames;
    private JLabel lblGameId;
    private JTextField tfGameId;

    public DeleteScreen(){

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setBounds(100, 100, 600, 500);

        btnDelete = new JButton("Delete game");
        btnDelete.setBounds(243, 390, 107, 23);
        add(btnDelete);

        btnClose = new JButton("Return");
        btnClose.setBounds(343, 390, 107, 23);
        add(btnClose);

        lblDeleteGames = new JLabel("Delete games");
        lblDeleteGames.setBounds(243, 58, 85, 25);
        add(lblDeleteGames);

        lblGameId = new JLabel("Game ID:");
        lblGameId.setBounds(221, 187, 56, 16);
        add(lblGameId);

        tfGameId = new JTextField();
        tfGameId.setBounds(289, 184, 116, 22);
        add(tfGameId);

    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnClose() {
        return btnClose;
    }

    public long getTfGameId(){
        return Long.parseLong(tfGameId.getText());
    }

    public void addActionListeners(ActionListener l){
        btnDelete.addActionListener(l);
        btnClose.addActionListener(l);
    }
}
