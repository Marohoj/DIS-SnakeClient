package Logic;

import GUI.ScreenFrame;
import GUI.JoinScreen;
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
        frame.getCreate().addActionListeners(new CreateAL());
        frame.getJoin().addActionListeners(new JoinAL());
        frame.getDelete().addActionListeners(new DeleteAL());
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

                cm.CreateGame(frame, gamer, currentUser);

            } else if (e.getSource() == frame.getCreate().getBtnClose()){

                frame.getCreate().getTfGameName().setText("");
                frame.getCreate().getTfControls().setText("");
                frame.getCreate().getTfControls().setText("");
                frame.show(frame.USERSCREEN);
            }
        }
    }

    private class JoinAL implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if (e.getSource() == frame.getJoin().getBtnJoin()){

                //games = server.openGames();
                //frame.getJoin().tableGameModel(games);


            } else if (e.getSource() == frame.getJoin().getBtnClose()) {

                frame.show(frame.USERSCREEN);

            }
        }
    }

    private class DeleteAL implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if (e.getSource() == frame.getDelete().getBtnDelete()){

                if (cm.DeleteGame(frame, currentUser)){

                    JOptionPane.showMessageDialog(frame, "Game was deleted!", "Success!", JOptionPane.INFORMATION_MESSAGE);

                }
                else {
                    JOptionPane.showMessageDialog(frame, "Game was not deleted!", "FATAL ERROR", JOptionPane.INFORMATION_MESSAGE);
                }

                //frame.getDelete().getTfGameId().setText("");

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

            return message;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public String loginParser(String string, User user){

        JSONParser jsonParser = new JSONParser();
        String message;

        try {

            Object messageObject = jsonParser.parse(string);
            JSONObject jsonObject = (JSONObject) messageObject;

            message = ((String) (jsonObject.get("message")));

            if (message.equals("Login successful")){

                user.setId((long) jsonObject.get("userid"));

            }

            return message;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String createParser(String string){

        JSONParser jsonParser = new JSONParser();
        String gameName;

        try {
            Object object = jsonParser.parse(string);
            JSONObject jsonObject = (JSONObject) object;

            gameName = ((String) jsonObject.get("name"));

            game.setName(gameName);

            return gameName;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String joinParser(String string){

        JSONParser jsonParser = new JSONParser();
        String gameId;


        /*try {
            Object object = jsonParser.parse(string);
            JSONObject jsonObject = (JSONObject) object;

            gameId = ((String) jsonObject.get("gameid"));

            String message = server.get()

            if (message.equals("Game was joined")){

                server.get(json, path)

            } else if (message.equals("Game closed")){



        } catch (Exception e) {
            e.printStackTrace();

        }*/

        return null;
    }

    public String deleteParser (String string){

        JSONParser jsonParser = new JSONParser();
        String gameId;

        try {

            Object object = jsonParser.parse(string);
            JSONObject jsonObject = (JSONObject) object;

            gameId = ((String) jsonObject.get("gameid"));

            return gameId;

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    public void  login(ScreenFrame frame){

        String username = frame.getLoginScreen().getTfUsername().getText();
        String password = frame.getLoginScreen().getTfPassword().getText();

        if(!username.equals("") & !password.equals("")){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            String json = new Gson().toJson(user);
            String message = loginParser((server.post(json, "login/", frame)), user);

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

}