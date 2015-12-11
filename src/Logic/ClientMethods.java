package Logic;

import GUI.ScreenFrame;
import Model.*;
import SDK.ServerConnection;
import com.google.gson.Gson;
import javax.swing.*;

/**
 * Created by Mathias on 03-12-2015.
 */

//Class that contains the methods used by controller class. Methods that support all the functions of the klient
//and calls the ServerConnection class to communicate with the server
public class ClientMethods {

    //Method that makes it possible for the user to log in
    public User Login(ScreenFrame frame, ServerConnection server, User currentUser, Parsers parser){

        //Sets variables username and password equal to the typed values in the LoginScreen panel
        String username = frame.getLoginScreen().getTfUsername().getText();
        String password = frame.getLoginScreen().getTfPassword().getText();

        //Try/catch for error handling through exceptions
        try {
            //If-statement for checking the typed values.
            //If the typed values aren't equal to "" (empty textfields) the method will be executed
            if(!username.equals("") & !password.equals("")) {

                User user = new User();

                //Sets the username and password for the logged in user equal to the typed values
                user.setUsername(username);
                user.setPassword(password);

                //Sends
                String json = new Gson().toJson(user);

                //Sends
                String message = parser.loginParser((server.post(json, "login/")), user);

                //Checks whether the received message is equal to the wanted one
                if (message.equals("Login successful")) {

                    currentUser = user;

                    //Uses the userParser method to get ..
                    parser.userParser(server.get("users/" + currentUser.getId() + "/"), currentUser);

                    //Leads the user to the usermenu
                    frame.show(frame.USERSCREEN);

                    //Returns the value/variable/object currentUser to define who's logged in
                    return currentUser;

                    //If the server can't fit the typed values
                    //Responds following received message with a JOptionPane that will warn the user
                } else if (message.equals("Wrong username or password")) {

                    JOptionPane.showMessageDialog(frame, "Wrong username or password. Please try again",
                            "Error", JOptionPane.ERROR_MESSAGE);

                    //If the error is elsewhere than in the typed values
                    //Responds following received message with a JOptionPane that will warn the user
                } else if (message.equals("Error in JSON")) {

                    JOptionPane.showMessageDialog(frame, "Error", "Error", JOptionPane.ERROR_MESSAGE);

                }

            }

            //Prints a stacktrace when catching an unforeseen error
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    //Method that allows the user to create a new game in the database
    public void CreateGame(ScreenFrame frame, ServerConnection server, User currentUser, Parsers parser){

        try {

            //Defining variables from typed values in the CreateScreen panel
            String gamename = frame.getCreate().getTfGameName().getText();
            int mapSize = frame.getCreate().getTfMapSize();
            String controls = frame.getCreate().getTfControls().getText();

            //Checks whether the typed in values are legitimate
            //Strings controls and gamename can't be empty and the map size can't be 0
            if (!controls.equals("") && mapSize != 0 && !gamename.equals("")) {

                //Creates objects of/instansialize Game and Gamer classes
                Game game = new Game();
                Gamer gamer = new Gamer();

                //Sets controls equal to the typed controls
                gamer.setControls(controls);

                //Sets id equal to the logged in user (the current user)
                gamer.setId(currentUser.getId());

                //Sets the above defined id as the host of the game
                game.setHost(gamer);

                //Sets the gamename and mapsize equal to the typed values
                game.setName(gamename);
                game.setMapSize(mapSize);

                //All of the above setters are used to @post the variables into the database
                //
                String json = new Gson().toJson(game);
                String message = parser.createParser(server.post(json,"games/"));

                //Checks if the received list of games contains the newly created game
                //If so a confirmation will be shown to the user
                if (message.equals(game.getName())){

                    JOptionPane.showMessageDialog(frame, "Game was created!\nIt's called "
                            + game.getName(), "Success!", JOptionPane.INFORMATION_MESSAGE);

                }

            }

            //Prints a stacktrace when catching an unforeseen error
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //Method that allows the user to join a game and at the same time starting, determining who's the winner
    public void JoinGame(ScreenFrame frame, ServerConnection server, User currentUser, Parsers parser){

        //Try/catch for error handling through exceptions
        try {

            //Defines the variables gameId for the game and controls for the joining user
            //GamId is set as type long because the server apparently sends back long type variables
            long gameId = frame.getJoin().getTfGameId();
            String controls = frame.getJoin().getTfControls().getText();

            //Checks whether the opponent typed controls are legitimate
            if(!controls.equals("")){

                //Instansierer/create new objects of game and gamer class
                Game game = new Game();
                Gamer gamer = new Gamer();

                //Sets the gamer id equal to the current users id
                gamer.setId(currentUser.getId());

                //Sets the typed in controls equal to gamer controls
                gamer.setControls(controls);

                //Sets the gameId equal to the typed gameId
                game.setGameId(gameId);

                //Sets the gamer to being the opponent
                game.setOpponent(gamer);

                String json = new Gson().toJson(game);

                String message = parser.messageParser(server.put("games/join/", json));

                //Checks whether the PUT-request succeeded
                if(message.equals("Game was joined")){

                    //
                    Game joined = parser.joinParser(server.put("games/start/", json));

                    joined = parser.joinParser(server.get("game/" + joined.getGameId() +"/"));

                    //If the SnakeMasterId is equal to the opponent (current user)
                    //the panel shows a message confirming that the opponent won
                    if (joined.getSnakeMasterId() == currentUser.getId()) {

                        JOptionPane.showMessageDialog(frame, "You joined the game and won!",
                                "WINNER!", JOptionPane.INFORMATION_MESSAGE);

                        //If the SnakeMasterId isn't equal to the current users
                        //the panel shows a message confirming that the host won
                    } else if (joined.getSnakeMasterId() != currentUser.getId()){

                        JOptionPane.showMessageDialog(frame, "You joined the game and lost!\nBuhuu..",
                                "LOSER", JOptionPane.INFORMATION_MESSAGE);

                    }

                //If the PUT-request message equals "Game closed"
                //the panel shows error message to the user
                } else if (message.equals("Game closed")){

                    JOptionPane.showMessageDialog(frame, "The Game is closed. Check your Game Id again",
                            "NOPE", JOptionPane.ERROR_MESSAGE);

                }

            }

        } catch (Exception e){
            e.printStackTrace();
        }


    }

    //Boolean method that allows the user to deleting a game with a known Game Id
    public boolean DeleteGame(ScreenFrame frame, ServerConnection server, Parsers parser){

        //Try/catch for error handling through exceptions
        try{
            //Gets variable gameId from DeleteScreen panel
            //Defines which game that has to be deleted
            long gameId = frame.getDelete().getTfGameId();

            //
            String message = parser.messageParser(server.delete("games/" + gameId));

            //If the server returns "Game was deleted" the statement returns true
            //which executes the lines at Controller class (l. 157-160)
            if (message.equals("Game was deleted")){

                return true;
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    //Method that shows the top 5 scores in the ScoreScreen panel
    public void ShowHighscore(ScreenFrame frame, ServerConnection server, Parsers parser){

        //
        try{

            //Initiates highscore class
            Highscore highscores = new Highscore();

            //Instantiates highscore object..?
            highscores = parser.scoreParser(server.get("scores/"), highscores);

            //Sets the labels in ScoreScreen panel equal to the obtained scores from servers
            frame.getHighscore().getLblFirst().setText("#1: " + String.valueOf(highscores.getFirstPlace() + " points"));
            frame.getHighscore().getLblSecond().setText("#2: " + String.valueOf(highscores.getSecondPlace() + " points"));
            frame.getHighscore().getLblThird().setText("#3: " + String.valueOf(highscores.getThirdPlace() + " points"));
            frame.getHighscore().getLblFourth().setText("#4: " + String.valueOf(highscores.getFourthPlace() + " points"));
            frame.getHighscore().getLblFifth().setText("#5: " + String.valueOf(highscores.getFifthPlace() + " points"));

            //
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
