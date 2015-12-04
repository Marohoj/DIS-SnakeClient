package Logic;

import GUI.ScreenFrame;
import Model.Game;
import Model.Gamer;
import SDK.ServerConnection;
import Model.User;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by Mathias on 30-11-2015.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Controller {

    private ScreenFrame frame = new ScreenFrame();
    private ServerConnection server = new ServerConnection();
    private User currentUser = new User();
    private ClientMethods cm = new ClientMethods();
    private Game game = new Game();
    private Gamer gamer = new Gamer();

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

                login(frame);

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

                frame.show(frame.HIGHSCORE);

            }
        }
    }

    private class CreateAL implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if (e.getSource()== frame.getCreate().getBtnCreate()){

                CreateGame(frame, gamer, currentUser);

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

                frame.show(frame.USERSCREEN);

            }
        }
    }

    public void userParser (String string, User user){

        JSONParser jsonParser = new JSONParser();

        try {

            Object messageObject = jsonParser.parse(string);
            JSONObject jsonObject = (JSONObject) messageObject;

            user.setFirstName((String) jsonObject.get("firstName"));
            user.setLastName((String) jsonObject.get("lastName"));
            user.setUsername((String) jsonObject.get("username"));
            user.setStatus((String) jsonObject.get("status"));
            user.setEmail((String) jsonObject.get("email"));
            user.setType((long) jsonObject.get("type"));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    //Creates parser method to parse messages sent from server to client
    //
    public String messageParser(String string, User user) {

        JSONParser jsonParser = new JSONParser();
        String message;

        try {

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

    public String createParser(String string){

        JSONParser jsonParser = new JSONParser();
        String gname = new String();

        try {
            Object object = jsonParser.parse(string);
            JSONObject jsonObject = (JSONObject) object;

            gname = ((String) jsonObject.get("gamename"));

            game.setName(gname);

            return gname;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String joinParser(String string){
        return string;
    }

    //public String deleteParser

    public void  login(ScreenFrame frame){

        String username = frame.getLoginScreen().getTfUsername().getText();
        String password = frame.getLoginScreen().getTfPassword().getText();

        if(!username.equals("") & !password.equals("")){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            String json = new Gson().toJson(user);

            String message = messageParser((server.post(json, "login/", frame)), user);

            if(message.equals("Login successful")) {

                currentUser = user;

                userParser(server.get("users/"+ currentUser.getId()+"/"), currentUser);

                frame.show(frame.USERSCREEN);

            } else if (message.equals("Wrong username or password")) {

                JOptionPane.showMessageDialog(frame, "Wrong username or password. Please try again",
                        "Error", JOptionPane.ERROR_MESSAGE);

            } else if (message.equals("Error in JSON")) {

                JOptionPane.showMessageDialog(frame, "Error", "Error", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    public void CreateGame(ScreenFrame frame, Gamer gamer, User currentUser){

        String gamename = frame.getCreate().getTfGameName().getText();
        int mapSize = frame.getCreate().getTfMapSize();
        String controls = frame.getCreate().getTfControls().getText();

        if (!controls.equals("") && mapSize != 0 && !gamename.equals("")) {

            gamer.setControls(controls);
            gamer.setId(currentUser.getId());
            game.setHost(gamer);

            game.setName(gamename);
            game.setMapSize(mapSize);

            String json = new Gson().toJson(game);
            String message = createParser(server.post(json,"games/",frame));

            //System.out.print(game.getName() + " " + gamer.getControls() + " " + game.getMapSize() + " " + gamer.getId());

            if (message.equals(game.getName())){

                JOptionPane.showMessageDialog(frame, "Game was created!\nIt's called "
                        + game.getName(), "Success!", JOptionPane.INFORMATION_MESSAGE);

            }

        }

    }

}