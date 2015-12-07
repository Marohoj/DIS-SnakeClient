package Logic;

import GUI.JoinScreen;
import GUI.ScreenFrame;
import Model.*;
import SDK.ServerConnection;
import com.google.gson.Gson;
import com.sun.corba.se.spi.activation.Server;
import com.sun.glass.ui.Screen;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by Mathias on 03-12-2015.
 */
public class ClientMethods {

    public User Login(ScreenFrame frame, ServerConnection server, User currentUser, Parsers parser){

        String username = frame.getLoginScreen().getTfUsername().getText();
        String password = frame.getLoginScreen().getTfPassword().getText();

        try {

            if(!username.equals("") & !password.equals("")) {

                User user = new User();

                user.setUsername(username);
                user.setPassword(password);

                String json = new Gson().toJson(user);
                String message = parser.loginParser((server.post(json, "login/")), user);

                if (message.equals("Login successful")) {

                    currentUser = user;

                    parser.userParser(server.get("users/" + currentUser.getId() + "/"), currentUser);

                    frame.show(frame.USERSCREEN);

                    return currentUser;

                } else if (message.equals("Wrong username or password")) {

                    JOptionPane.showMessageDialog(frame, "Wrong username or password. Please try again",
                            "Error", JOptionPane.ERROR_MESSAGE);

                } else if (message.equals("Error in JSON")) {

                    JOptionPane.showMessageDialog(frame, "Error", "Error", JOptionPane.ERROR_MESSAGE);

                }

            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public void CreateGame(ScreenFrame frame, ServerConnection server, User currentUser, Parsers parser){

        try {



            String gamename = frame.getCreate().getTfGameName().getText();
            int mapSize = frame.getCreate().getTfMapSize();
            String controls = frame.getCreate().getTfControls().getText();

            if (!controls.equals("") && mapSize != 0 && !gamename.equals("")) {

                Game game = new Game();
                Gamer gamer = new Gamer();

                gamer.setControls(controls);
                gamer.setId(currentUser.getId());
                game.setHost(gamer);

                game.setName(gamename);
                game.setMapSize(mapSize);

                String json = new Gson().toJson(game);
                String message = parser.createParser(server.post(json,"games/"));

                //System.out.print(game.getName() + " " + gamer.getControls() + " " + game.getMapSize() + " " + gamer.getId());

                if (message.equals(game.getName())){

                    JOptionPane.showMessageDialog(frame, "Game was created!\nIt's called "
                            + game.getName(), "Success!", JOptionPane.INFORMATION_MESSAGE);

                }

            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void JoinGame(ScreenFrame frame, ServerConnection server, Game game, Gamer gamer, User currentUser, Parsers parser){

        try {

            long gameId = frame.getJoin().getTfGameId();
            String controls = frame.getJoin().getTfControls().getText();

            if(!controls.equals("")){

                gamer.setId(currentUser.getId());
                gamer.setControls(controls);
                game.setGameId(gameId);
                game.setOpponent(gamer);

                String json = new Gson().toJson(game);

                String message = parser.messageParser(server.put("games/join/", json));

                if(message.equals("Game was joined")){

                    Game joined = parser.joinParser(server.put("games/start/", json));

                    joined = parser.joinParser(server.get("game/" + joined.getGameId() +"/"));

                    if (joined.getSnakeMasterId() == currentUser.getId()) {

                        JOptionPane.showMessageDialog(frame, "You joined the game and won!", "WINNER!", JOptionPane.INFORMATION_MESSAGE);

                    } else if (joined.getSnakeMasterId() != currentUser.getId()){

                        JOptionPane.showMessageDialog(frame, "You joined the game and lost!\nBuhuu..", "LOSER", JOptionPane.INFORMATION_MESSAGE);

                    }

                } else if (message.equals("Game closed")){

                    JOptionPane.showMessageDialog(frame, "Nope","Nope", JOptionPane.INFORMATION_MESSAGE);

                }

            }

        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public boolean DeleteGame(ScreenFrame frame, ServerConnection server, Parsers parser){

        try{
            long gameId = frame.getDelete().getTfGameId();

            String message = parser.messageParser(server.delete("games/" + gameId));

            if (message.equals("Game was deleted")){

                return true;
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public void ShowHighscore(ScreenFrame frame, Highscore highscores, ServerConnection server, Parsers parser){

        try{

            highscores = parser.scoreParser(server.get("scores/"), highscores);

            frame.getHighscore().getLblFirst().setText("#1: " + String.valueOf(highscores.getFirstPlace() + " points"));
            frame.getHighscore().getLblSecond().setText("#2: " + String.valueOf(highscores.getSecondPlace() + " points"));
            frame.getHighscore().getLblThird().setText("#3: " + String.valueOf(highscores.getThirdPlace() + " points"));
            frame.getHighscore().getLblFourth().setText("#4: " + String.valueOf(highscores.getFourthPlace() + " points"));
            frame.getHighscore().getLblFifth().setText("#5: " + String.valueOf(highscores.getFifthPlace() + " points"));

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
