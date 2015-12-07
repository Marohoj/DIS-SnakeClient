package GUI;

/**
 * Created by Mathias on 01-12-2015.
 */

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionListener;


public class ScoreScreen extends JPanel {

    private JButton btnClose;
    private JLabel lblInfo;
    private JLabel lblFirst;
    private JLabel lblSecond;
    private JLabel lblThird;
    private JLabel lblFourth;
    private JLabel lblFifth;

    public ScoreScreen(){

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setBounds(100, 100, 600, 500);

        btnClose = new JButton("Return");
        btnClose.setBounds(343, 390, 107, 23);
        add(btnClose);

        lblInfo = new JLabel("Highscores");
        lblInfo.setBounds(221,40,108,25);
        add(lblInfo);

        lblFirst = new JLabel("");
        lblFirst.setBounds(221,115,108,19);
        add(lblFirst);

        lblSecond = new JLabel("");
        lblSecond.setBounds(221,147,108,19);
        add(lblSecond);

        lblThird = new JLabel("");
        lblThird.setBounds(221,176,108,19);
        add(lblThird);

        lblFourth = new JLabel("");
        lblFourth.setBounds(221,207,108,19);
        add(lblFourth);

        lblFifth = new JLabel("");
        lblFifth.setBounds(221,236,108,19);
        add(lblFifth);
    }

    public JButton getBtnClose(){
        return btnClose;
    }

    public JLabel getLblFirst() {
        return lblFirst;
    }

    public JLabel getLblSecond() {
        return lblSecond;
    }

    public JLabel getLblThird() {
        return lblThird;
    }

    public JLabel getLblFourth() {
        return lblFourth;
    }

    public JLabel getLblFifth() {
        return lblFifth;
    }

    public void addActionListeners(ActionListener l){

        btnClose.addActionListener(l);

    }

}
