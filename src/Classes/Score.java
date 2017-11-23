package Classes;

public class Score {
    private int currentScore = 0;
    private int highScore = 0;

    //Accessor methods
    public int getCurrentScore() {
        //System.out.print("getScore\n");
        return currentScore;
    }

    public int getHighScore() {
        return highScore;
    }

    //Mutator methods
    public void setCurrentScore(int currentScore) {
        this.currentScore += currentScore;
        //System.out.print("setScore\n");
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public String toString()
    {
        return String.format("Current Score: %6d \nHigh Score: %6d", getCurrentScore(), getHighScore());
    }

    public String currentString()
    {
        return String.format("%d", currentScore);
    }

    public String highString()
    {
        return String.format("%d", highScore);
    }
}//End of Score Class
