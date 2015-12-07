package GUI;

import Logic.ClientMethods;
import Logic.Controller;
import Model.Game;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
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
    private JTable tableGames;

    public JoinScreen(){

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setBounds(100, 100, 600, 500);

        btnJoin = new JButton("Join game");
        btnJoin.setBounds(175,430,109,19);
        add(btnJoin);

        btnClose = new JButton("Return");
        btnClose.setBounds(343, 390, 107, 23);
        add(btnClose);

        lblGameName = new JLabel("Game name");
        lblGameName.setBounds(122,59,75,19);
        add(lblGameName);

        lblCreated = new JLabel("Created");
        lblCreated.setBounds(383,52,63,32);
        add(lblCreated);

        //tableGames = new JTable(cm.getData(), cm.getColumnNames());
        //tableGames = new JTable(new DefaultTableModel(new Object[]{"Game Id", "Gamename", "MapSize", "Hosted"}, 0));
        //tableGames.setBounds(61, 86, 490, 312);
        //add(tableGames);

    }

    public JButton getBtnJoin() {
        return btnJoin;
    }

    public JButton getBtnClose() {
        return btnClose;
    }

    /*public void tableGameModel (Game[] games){
        DefaultTableModel tableModel = (DefaultTableModel) tableGames.getModel();
        tableModel.setRowCount(0);
        for (Game game:games){
            tableModel.addRow(new Object[]{game.getName(),game.getMapSize(),game.getCreated()});
        }
    }*/

    public void addActionListeners(ActionListener l){
        btnJoin.addActionListener(l);
        btnClose.addActionListener(l);
        //tableGames.addActionListener(l);
    }

}