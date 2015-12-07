package Logic;

import GUI.JoinScreen;
import GUI.ScreenFrame;
import Model.*;
import SDK.ServerConnection;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created by Mathias on 30-11-2015.
 */

public class Controller {

    private ScreenFrame frame;
    private ServerConnection server;
    private Parsers parser;
    private User currentUser;
    private User user;
    private ClientMethods cm;
    private JoinScreen js;
    private Game game;
    private Highscore highscores;
    private Gamer gamer;

    public Controller(){

        frame = new ScreenFrame();
        server = new ServerConnection();
        parser = new Parsers();
        currentUser = new User();
        user = new User();
        cm = new ClientMethods();
        js = new JoinScreen();
        game = new Game();
        highscores = new Highscore();
        gamer = new Gamer();
        frame.setVisible(true);

    }

    public void run() {

        try {

            frame.getLoginScreen().addActionListener(new LoginAL());
            frame.getUserScreen().addActionListener(new UserAL());
            frame.getCreate().addActionListeners(new CreateAL());
            frame.getJoin().addActionListeners(new JoinAL());
            frame.getDelete().addActionListeners(new DeleteAL());
            frame.getHighscore().addActionListeners(new ScoreAL());

            frame.show(frame.LOGIN);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private class LoginAL implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == frame.getLoginScreen().getBtnLogin()) {

                currentUser = cm.Login(frame, server, currentUser, parser);


            } else if (e.getSource() == frame.getLoginScreen().getBtnClose()) {

                System.exit(0);

            }
        }
    }

    private class UserAL implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == frame.getUserScreen().getBtnLogout()) {

                frame.getLoginScreen().getTfPassword().setText("");
                frame.getLoginScreen().getTfUsername().setText("");
                frame.show(frame.LOGIN);

            } else if (e.getSource() == frame.getUserScreen().getBtnCreate()) {

                frame.show(frame.CREATE);

            } else if (e.getSource() == frame.getUserScreen().getBtnJoin()) {

                frame.show(frame.JOIN);

            } else if (e.getSource() == frame.getUserScreen().getBtnDelete()) {

                frame.show(frame.DELETE);

            } else if (e.getSource() == frame.getUserScreen().getBtnHighscore()) {

                cm.ShowHighscore(frame, highscores, server, parser);
                frame.show(frame.HIGHSCORE);

            }
        }
    }

    private class CreateAL implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == frame.getCreate().getBtnCreate()) {

                cm.CreateGame(frame, server, currentUser, parser);

            } else if (e.getSource() == frame.getCreate().getBtnClose()) {

                frame.getCreate().getTfGameName().setText("");
                frame.getCreate().getTfControls().setText("");
                frame.getCreate().getTfControls().setText("");
                frame.show(frame.USERSCREEN);
            }
        }
    }

    private class JoinAL implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == frame.getJoin().getBtnJoin()) {

                cm.JoinGame(frame, server, game, gamer, currentUser, parser);
                frame.getJoin().getTfGameId().setText("");
                frame.getJoin().getTfControls().setText("");


            } else if (e.getSource() == frame.getJoin().getBtnClose()) {

                frame.show(frame.USERSCREEN);

            }
        }
    }

    private class DeleteAL implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == frame.getDelete().getBtnDelete()) {

                if (cm.DeleteGame(frame, server, parser)) {

                    JOptionPane.showMessageDialog(frame, "Game was deleted!", "Success!", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(frame, "Game was not deleted!", "FATAL ERROR", JOptionPane.INFORMATION_MESSAGE);
                }

            } else if (e.getSource() == frame.getDelete().getBtnClose()) {

                frame.show(frame.USERSCREEN);

            }
        }
    }

    private class ScoreAL implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == frame.getHighscore().getBtnClose()) {

                frame.show(frame.USERSCREEN);

            }

        }
    }


}