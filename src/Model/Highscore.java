package Model;

/**
 * Created by Mathias on 07-12-2015.
 */
//New class to interact with new highscore methods on the server
public class Highscore {
    private long firstPlace;
    private long secondPlace;
    private long thirdPlace;
    private long fourthPlace;
    private long fifthPlace;

    // Creates getters and setters for variables
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

    public long  getThirdPlace() {
        return thirdPlace;
    }

    public void setThirdPlace(long  thirdPlace) {
        this.thirdPlace = thirdPlace;
    }

    public long  getFourthPlace() {
        return fourthPlace;
    }

    public void setFourthPlace(long  fourthPlace) {
        this.fourthPlace = fourthPlace;
    }

    public long  getFifthPlace() {
        return fifthPlace;
    }

    public void setFifthPlace(long  fifthPlace) {
        this.fifthPlace = fifthPlace;
    }
}
