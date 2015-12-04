package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Mathias on 01-12-2015.
 */
public class CreateScreen extends JPanel {

    private JButton btnCreate;
    private JButton btnClose;
    private JLabel lblGameName;
    private JLabel lblMapsize;
    private JLabel lblControls;
    private JTextField TfGameName;
    private JTextField TfMapSize;
    private JTextField TfControls;

    public CreateScreen(){

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setBounds(100, 100, 600, 500);

        btnCreate = new JButton("Create Game");
        btnCreate.setBounds(174, 390, 107, 23);
        add(btnCreate);

        btnClose = new JButton("Return");
        btnClose.setBounds(343, 390, 107, 23);
        add(btnClose);

        TfGameName = new JTextField("");
        TfGameName.setBounds(250, 150, 200, 26);
        add(TfGameName);

        TfMapSize = new JTextField("");
        TfMapSize.setBounds(250, 250, 200, 26);
        add(TfMapSize);

        TfControls = new JTextField("");
        TfControls.setBounds(250, 200, 200, 26);
        add(TfControls);

        lblGameName = new JLabel("Game name:");
        lblGameName.setBounds(164, 155, 74, 16);
        add(lblGameName);

        lblControls = new JLabel("Controls:");
        lblControls.setBounds(186, 205, 52, 16);
        add(lblControls);

        lblMapsize = new JLabel("Mapsize:");
        lblMapsize.setBounds(187, 255, 51, 16);
        add(lblMapsize);

    }

    public JButton getBtnCreate() {
        return btnCreate;
    }

    public JButton getBtnClose() {
        return btnClose;
    }

    public JTextField getTfGameName() {
        return TfGameName;
    }

    public int getTfMapSize() {

        return Integer.parseInt(TfMapSize.getText());

    }

    public JTextField getTfControls() {
        return TfControls;
    }

    public void addActionisteners(ActionListener l){
        btnCreate.addActionListener(l);
        btnClose.addActionListener(l);
    }
}
