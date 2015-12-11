package Model;

import java.sql.Date;

/**
 * Created by Mathias on 02-12-2015.
 */

//Class mirrored from the server

public class Game {

    //Creating the variables needed for the game
    private long gameId;
    private Gamer winner;
    private String name;
    private Gamer host;
    private Gamer opponent;
    private String status;
    private Date created;
    private int mapSize;
    private long SnakeMasterId;

    public Game(){}

    //Creating getters and setters for all the variables
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGameId(){
        return gameId;
    }

    public void setGameId(long gameId){
        this.gameId = gameId;
    }

    public Gamer getHost(){
        return host;
    }

    public void setHost(Gamer host){
        this.host = host;
    }

    public Gamer getOpponent(){
        return opponent;
    }

    public void setOpponent(Gamer opponent){
        this.opponent = opponent;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public Gamer getWinner() {
        return winner;
    }

    public void setWinner(Gamer winner) {
        this.winner = winner;
    }

    //Not from the original server game class. Created to determine a winner by return an id
    //instead of the premade boolean value
    public long getSnakeMasterId() {
        return SnakeMasterId;
    }

    public void setSnakeMasterId(long snakeMasterId) {
        SnakeMasterId = snakeMasterId;
    }
}
