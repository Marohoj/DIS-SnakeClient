package Logic;

import GUI.ScreenFrame;
import Model.Game;
import Model.Gamer;
import SDK.ServerConnection;
import Model.User;
import com.google.gson.Gson;

import javax.swing.*;

/**
 * Created by Mathias on 03-12-2015.
 */
public class ClientMethods {

    private User user;
    private Game game;
    private ServerConnection server;

    public ClientMethods(){

        user = new User();
        game = new Game();
        server = new ServerConnection();
    }


    public void CreateGame(ScreenFrame frame, Gamer gamer, User currentUser){

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

    public void JoinGame(ScreenFrame frame, User user){

    }

    public boolean DeleteGame(ScreenFrame frame, User user){

        try{
            Controller controller = new Controller();

            long gameId = frame.getDelete().getTfGameId();

            String message = controller.messageParser(server.delete("games/" + gameId), user);

            //deleteParser(server.delete("games/" + gameId));

            if (message.equals("Game was deleted")){

                return true;

            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

}
