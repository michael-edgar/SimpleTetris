package Classes;

import javax.swing.*;
import java.awt.*;

public class Arena extends JPanel{

    private Color[][] wallOfArena = new Color[9][12];
    private int currentX, currentY;
    String currentScore, highScore;
    static CurrentBlock thisBlock;

    public void Wall()
    {
        for(int j = 0; j < 12; j++) {
            for(int i = 0; i < 9; i++) {
                if(i == 0 || i == 8 || j == 11) {
                    wallOfArena[i][j] = Color.GRAY;
                }
                else if(j == 10 && i == 2) {
                    wallOfArena[i][j] = Color.BLUE;
                }
                else if(j == 10 && i == 4) {
                    wallOfArena[i][j] = Color.RED;
                }
                else if(j == 10 && i == 6) {
                    wallOfArena[i][j] = Color.GREEN;
                }
                else {
                    wallOfArena[i][j] = Color.BLACK;
                }
            }
        }
    }//End of Wall Method

    public void setScores(Score gameScore)
    {
        this.currentScore = gameScore.currentString();
        this.highScore = gameScore.getHighString();
    }

    public void setCurrent(int currentX, int currentY)
    {
        setCurrentX(currentX);
        setCurrentY(currentY);

        thisBlock = new CurrentBlock();
        wallOfArena[currentX][currentY] = thisBlock.getColour();
    }//End of setCurrent


    @Override
    public void paintComponent(Graphics g)
    {
        g.fillRect(0,0, 55*9, 55*12);

        for(int j = 0; j < 12; j++)
        {
            for(int i = 0; i < 9; i++)
            {
                g.setColor(wallOfArena[i][j]);
                g.drawString("Current Score: " + currentScore, 325, 100);
                g.drawString("High Score: " + highScore, 325, 110);
                g.fillRect(55*i, 55*j, 54, 54);
            }
        }
    }//End of paintComponent method

    //Accessor methods

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public Color[][] getWallOfArena() {
        return wallOfArena;
    }

    //Mutator methods

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }
}//End of Arena Class
