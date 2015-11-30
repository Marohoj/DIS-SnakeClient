import GUI.LoginScreen;
import GUI.ScreenFrame;

/**
 * Created by Mathias on 30-11-2015.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ActionListeners {

    private ScreenFrame frame = new ScreenFrame();

    public void run(){

        frame.show(frame.LOGIN);

        frame.getLoginScreen().addActionListener(new LoginAL());
        frame.getUserScreen().addActionListener(new UserAL());

    }

    private class LoginAL implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if (e.getSource()== frame.getLoginScreen().getBtnLogin()){

                frame.show(frame.USERSCREEN);

                //JOptionPane.showMessageDialog(frame, "Wrong username/password. Please try again.");

            } else if (e.getSource() == frame.getLoginScreen().getBtnClose()){

                System.exit(0);

            }
        }
    }

    private class UserAL implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if (e.getSource() == frame.getUserScreen().getBtnLogout()){

                frame.show(frame.LOGIN);

            } else if (e.getSource() == frame.getUserScreen().getBtnStart()){

                JOptionPane.showMessageDialog(frame, "Function unavailable");

            } else if (e.getSource() == frame.getUserScreen().getBtnLoad()){

                JOptionPane.showMessageDialog(frame, "Function unavailable");

            } else if (e.getSource() == frame.getUserScreen().getBtnHighscore()){

                JOptionPane.showMessageDialog(frame, "Function unavailable");

            } else if (e.getSource() == frame.getUserScreen().getBtnCreate()){

                JOptionPane.showMessageDialog(frame, "Function unavailable");

            } else if (e.getSource() == frame.getUserScreen().getBtnDelete()){

                JOptionPane.showMessageDialog(frame, "Function unavailable");

            }
        }
    }
}
