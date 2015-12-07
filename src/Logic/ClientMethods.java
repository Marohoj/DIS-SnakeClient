package Logic;

import GUI.ScreenFrame;
import Model.*;
import SDK.ServerConnection;
import com.google.gson.Gson;
import com.sun.corba.se.spi.activation.Server;
import com.sun.glass.ui.Screen;

import javax.swing.*;

/**
 * Created by Mathias on 03-12-2015.
 */
public class ClientMethods {

    private Controller controller;

    public ClientMethods(){

        controller = new Controller();
    }



    public void CreateGame(ScreenFrame frame, ServerConnection server, Game game, Gamer gamer, User currentUser){

        try {

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
                String message = controller.createParser(server.post(json,"games/",frame));

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


    public void JoinGame(){



    }

    public boolean DeleteGame(ScreenFrame frame, ServerConnection server){

        //Controller controller = new Controller();
        //ScreenFrame frame = new ScreenFrame();

        try{
            long gameId = frame.getDelete().getTfGameId();

            String message = controller.messageParser(server.delete("games/" + gameId));

            if (message.equals("Game was deleted")){

                return true;
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public void ShowHighscore(ScreenFrame frame, Highscore highscores, ServerConnection server){

        try{

            highscores = controller.scoreParser(server.get("scores/"));

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
