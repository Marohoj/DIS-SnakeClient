package Model;

/**
 * Created by Mathias on 02-12-15.
 */


// Creates class Score
public class Score {

    // Declare highScore
    private int id;
    private Gamer user;
    private Gamer opponent;
    private Game game;
    private int score;
    private long firstPlace;
    private long secondPlace;
    private long thirdPlace;
    private long fourthPlace;
    private long fifthPlace;
    private String first;
    private String second;
    private String third;
    private String fourth;
    private String fifth;

    // Creates constructor
    public Score(int id, Gamer user, Game game, Gamer opponent, int score)
    {
        this.id = id;
        this.user = user;
        this.game = game;
        this.opponent = opponent;
        this.score = score;
    }

    public Score(){}

    // Creates get method which returns the highScore

    public Gamer getOpponent() { return opponent; }

    public void setOpponent(Gamer opponent) { this.opponent = opponent;  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gamer getUser() {
        return user;
    }

    public void setUser(Gamer user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(long firstPlace) {
        this.firstPlace = firstPlace;
    }

    public long getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(long secondPlace) {
        this.secondPlace = secondPlace;
    }

    public long getThirdPlace() {
        return thirdPlace;
    }

    public void setThirdPlace(long thirdPlace) {
        this.thirdPlace = thirdPlace;
    }

    public long getFourthPlace() {
        return fourthPlace;
    }

    public void setFourthPlace(long fourthPlace) {
        this.fourthPlace = fourthPlace;
    }

    public long getFifthPlace() {
        return fifthPlace;
    }

    public void setFifthPlace(long fifthPlace) {
        this.fifthPlace = fifthPlace;
    }


    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getFourth() {
        return fourth;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public String getFifth() {
        return fifth;
    }

    public void setFifth(String fifth) {
        this.fifth = fifth;
    }
}
