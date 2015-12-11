package Model;

/**
 * Created by Mathias on 07-12-2015.
 */

//Is never used because of new highscore class
public class Scores {

    private int id;
    private int userId;
    private int gameid;
    private int score;
    private int opponentId;

    public Scores(){}

    // Creates getters and setters for variables

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(int opponentId) {
        this.opponentId = opponentId;
    }
}
