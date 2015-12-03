package Logic;

import GUI.ScreenFrame;
import SDK.ServerConnection;
import Model.User;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Created by Mathias on 30-11-2015.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Controller {

    private ScreenFrame frame = new ScreenFrame();
    private ServerConnection server = new ServerConnection();
    private User user = new User();

    public void run() {

        server.get("");

        frame.show(frame.LOGIN);

        frame.getLoginScreen().addActionListener(new LoginAL());
        frame.getUserScreen().addActionListener(new UserAL());
        frame.getCreate().addActionisteners(new CreateAL());
        frame.getJoin().addActionisteners(new JoinAL());
        frame.getDelete().addActionisteners(new DeleteAL());
      //frame.getHighscore().addActionListeners(new ScoreAL());

    }

    private class LoginAL implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == frame.getLoginScreen().getBtnLogin()) {

                login(frame, user);

            } else if (e.getSource() == frame.getLoginScreen().getBtnClose()) {

                System.exit(0);

            }
        }
    }

    private class UserAL implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == frame.getUserScreen().getBtnLogout()) {

                //frame.getLoginScreen().setTfPassword().setText();
                //frame.getLoginScreen().setTfUsername().setText();
                frame.show(frame.LOGIN);

            } else if (e.getSource() == frame.getUserScreen().getBtnCreate()) {

                frame.show(frame.CREATE);

            } else if (e.getSource() == frame.getUserScreen().getBtnJoin()) {

                frame.show(frame.JOIN);

            } else if (e.getSource() == frame.getUserScreen().getBtnDelete()) {

                frame.show(frame.DELETE);

            } else if (e.getSource() == frame.getUserScreen().getBtnHighscore()) {

                frame.show(frame.HIGHSCORE);

            }
        }
    }

    private class CreateAL implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if (e.getSource()== frame.getCreate().getBtnCreate()){

                System.out.print("Hej");

            } else if (e.getSource() == frame.getCreate().getBtnClose()){

                frame.show(frame.USERSCREEN);
            }
        }
    }

    private class JoinAL implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if (e.getSource() == frame.getJoin().getBtnJoin()){

                System.out.print("Hej");

            } else if (e.getSource() == frame.getJoin().getBtnClose()) {

                frame.show(frame.USERSCREEN);

            }
        }
    }

    private class DeleteAL implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if (e.getSource() == frame.getDelete().getBtnDelete()){

                System.out.print("Hej");

            } else if (e.getSource() == frame.getDelete().getBtnClose()) {

                frame.show(frame.DELETE);

            }
        }
    }

    //Creates parser method to parse messages sent from server to client
    //
    public String messageParser(String string, User user) {

        JSONParser jsonParser = new JSONParser();
        String message;

        try {

            String json = new Gson().toJson(user);

            server.post(json,"login/", frame);

            Object messageObject = jsonParser.parse(string);
            JSONObject jsonObject = (JSONObject) messageObject;

            message = ((String) (jsonObject.get("message")));


            if (message.equals("Login successful")){

                user.setId((long)(jsonObject.get("userid")));
            }

            return message;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public void  login(ScreenFrame frame, User user){

        String username = frame.getLoginScreen().getTfUsername().getText();
        String password = frame.getLoginScreen().getTfPassword().getText();

        if(!username.equals("") & !password.equals("")){

            this.user.setUsername(username);
            this.user.setPassword(password);

            String json = new Gson().toJson(this.user);

            String message = messageParser((server.post(json, "login/", frame)), this.user);

            if(message.equals("Login successful")) {

                messageParser(server.get("users/"+ this.user.getId()+"/"), this.user);

                frame.show(frame.USERSCREEN);

            } else if (message.equals("Wrong username or password")) {

                JOptionPane.showMessageDialog(frame, "Wrong username or password. Please try again",
                        "Error", JOptionPane.ERROR_MESSAGE);

            } else if (message.equals("Error in JSON")) {

                JOptionPane.showMessageDialog(frame, "Error", "Error", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

}