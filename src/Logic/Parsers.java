package Logic;

import Model.Game;
import Model.Highscore;
import Model.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Date;

/**
 * Created by Mathias on 07-12-2015.
 */
public class Parsers {

    public void userParser(String string, User user) {

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

    public void tableParser(String string){

        JSONParser jsonParser = new JSONParser();

        try {
            Object object = jsonParser.parse(string);
            JSONObject jsonObject = (JSONObject) object;

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //Creates parser method to parse messages sent from server to client
    //
    public String messageParser(String string) {

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

    public String loginParser(String string, User user) {

        JSONParser jsonParser = new JSONParser();
        String message;

        try {

            Object messageObject = jsonParser.parse(string);
            JSONObject jsonObject = (JSONObject) messageObject;

            message = ((String) (jsonObject.get("message")));

            if (message.equals("Login successful")) {

                user.setId((long) jsonObject.get("userid"));

            }

            return message;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String createParser(String string, Game game) {

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

    public String joinParser(String string) {

        JSONParser jsonParser = new JSONParser();
        String gameId;

        /*try {
            Object object = jsonParser.parse(string);
            JSONObject jsonObject = (JSONObject) object;

            gameId = ((String) jsonObject.get("gameid"));

            String message = server.get();

            if (message.equals("Game was joined")) {

                server.get(json, path);

                return null;

            } else if (message.equals("Game closed")) {


            }

        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        return null;

    }

    public String deleteParser(String string) {

        JSONParser jsonParser = new JSONParser();
        String gameId;

        try {

            Object object = jsonParser.parse(string);
            JSONObject jsonObject = (JSONObject) object;

            gameId = ((String) jsonObject.get("gameid"));

            return gameId;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public Highscore scoreParser(String string, Highscore highscores) {

        JSONParser jsonParser = new JSONParser();

        try {
            Object object = jsonParser.parse(string);
            JSONObject jsonObject = (JSONObject) object;

            highscores.setFirstPlace((long) jsonObject.get("place1"));
            highscores.setSecondPlace((long) jsonObject.get("place2"));
            highscores.setThirdPlace((long) jsonObject.get("place3"));
            highscores.setFourthPlace((long) jsonObject.get("place4"));
            highscores.setFifthPlace((long) jsonObject.get("place5"));

            return highscores;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}