package Classes;

public class Score {
    private int currentScore = 0;
    private int highScore = 0;
    private String name;

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

    public void setHighScore(int highScore, String name) {
        this.highScore = highScore;
        this.name = name;
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
        return String.format("%d %s", highScore, name);
    }
}//End of Score Class
