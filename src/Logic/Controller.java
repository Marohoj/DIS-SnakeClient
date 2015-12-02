package Logic;

import GUI.ScreenFrame;
import GUI.UserScreen;
import SDK.ServerConnection;
import SDK.User;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Created by Mathias on 30-11-2015.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controller {

    private ScreenFrame frame = new ScreenFrame();
    private ServerConnection server = new ServerConnection();
    private User user = new User();

    public void run() {

        server.get("");

        frame.show(frame.LOGIN);

        frame.getLoginScreen().addActionListener(new LoginAL());
        frame.getUserScreen().addActionListener(new UserAL());

    }

    private class LoginAL implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == frame.getLoginScreen().getBtnLogin()) {

                frame.show(frame.USERSCREEN);

                //JOptionPane.showMessageDialog(frame, "Wrong username/password. Please try again.");

            } else if (e.getSource() == frame.getLoginScreen().getBtnClose()) {

                System.exit(0);

            }
        }
    }

    private class UserAL implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == frame.getUserScreen().getBtnLogout()) {

                frame.show(frame.LOGIN);

            } else if (e.getSource() == frame.getUserScreen().getBtnCreate()) {

                JOptionPane.showMessageDialog(frame, "Function unavailable");

            } else if (e.getSource() == frame.getUserScreen().getBtnJoin()) {

                JOptionPane.showMessageDialog(frame, "Function unavailable");

            } else if (e.getSource() == frame.getUserScreen().getBtnGames()) {

                JOptionPane.showMessageDialog(frame, "Function unavailable");

            } else if (e.getSource() == frame.getUserScreen().getBtnHighscore()) {

                JOptionPane.showMessageDialog(frame, "Function unavailable");

            }
        }
    }

    //Creates parser method to parse messages sent from server to client
    //
    public String messageParser(String string, User user) {

        JSONParser jsonParser = new JSONParser();
        String message = new String();

        try {

            String json = new Gson().toJson(user);

            server.post(json,"login/");

            Object messageObject = jsonParser.parse(string);
            JSONObject jsonObject = (JSONObject) messageObject;

            message = ((String) (jsonObject.get("message")));


            if (message.equals("Login succesful")){

                user.setId((int) (jsonObject.get("userid")));
            }

            return message;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    

}