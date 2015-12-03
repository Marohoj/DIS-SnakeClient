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
    private JLabel lblGameName;
    private JLabel lblCreated;
    private JTable tableGames;
    private JList listGames;

    public DeleteScreen(){

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setBounds(100, 100, 600, 500);

        btnDelete = new JButton("Delete game");
        btnDelete.setBounds(175,430,109,19);
        add(btnDelete);

        btnClose = new JButton("Return");
        btnClose.setBounds(296,430,109,19);
        add(btnClose);

        lblGameName = new JLabel("Game name");
        lblGameName.setBounds(122,59,75,19);
        add(lblGameName);

        lblCreated = new JLabel("Created");
        lblCreated.setBounds(383,52,63,32);
        add(lblCreated);

        tableGames = new JTable();
        add(tableGames);

        listGames = new JList();
        listGames.setBounds(62, 91, 473, 277);
        add(listGames);

    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnClose() {
        return btnClose;
    }

    public void addActionisteners(ActionListener l){
        btnDelete.addActionListener(l);
        btnClose.addActionListener(l);
        //tableGames.addActionListener(l);
    }



}



