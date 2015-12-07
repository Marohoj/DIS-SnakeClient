package Logic;

import GUI.ScreenFrame;
import Model.*;
import SDK.ServerConnection;
import com.google.gson.Gson;
import com.sun.glass.ui.Screen;

import javax.swing.*;

/**
 * Created by Mathias on 03-12-2015.
 */
public class ClientMethods {

    private User user;
    private User currentUser;
    private Game game;
    private Gamer gamer;
    private Score score;
    private ServerConnection server;

    public ClientMethods(){

        user = new User();
        currentUser = new User();
        game = new Game();
        score = new Score();
        server = new ServerConnection();
    }


    public void CreateGame(ScreenFrame frame){

        try {
            Controller controller = new Controller();

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

    public boolean DeleteGame(ScreenFrame frame){

        Controller controller = new Controller();

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

}
