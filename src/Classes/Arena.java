package Classes;

import javax.swing.*;
import java.awt.*;

public class Arena extends JPanel{

    private Color[][] wallOfArena = new Color[9][12];
    private int currentX, currentY;

    public void Wall()
    {
        for(int j = 0; j < 12; j++) {
            for(int i = 0; i < 9; i++) {
                if(i == 0 || i == 8 || j == 11) {
                    wallOfArena[i][j] = Color.GRAY;
                }
                else if(j == 10 && i == 3) {
                    wallOfArena[i][j] = Color.BLUE;
                }
                else if(j == 10 && i == 4) {
                    wallOfArena[i][j] = Color.RED;
                }
                else if(j == 10 && i == 5) {
                    wallOfArena[i][j] = Color.GREEN;
                }
                else {
                    wallOfArena[i][j] = Color.BLACK;
                }
            }
        }
    }//End of Wall Method

    public void setCurrent(int currentX, int currentY)
    {
        System.out.print("Getting to setCurrent\n");

        int random = (int)(Math.random()*100);

        while(random <= 0 || random > 3) {
            random = (int)(Math.random()*100);
        }

        switch (random)
        {
            case 1:
            {
                System.out.print("Red\n");
                RedBlock block = new RedBlock();
                block.setBlockType();
                wallOfArena[currentX][currentY] = block.BlockColor;
                break;
            }
            case 2:
            {
                System.out.print("Green\n");
                GreenBlock block = new GreenBlock();
                block.setBlockType();
                wallOfArena[currentX][currentY] = block.BlockColor;
                break;
            }
            case 3:
            {
                System.out.print("Blue\n");
                BlueBlock block = new BlueBlock();
                block.setBlockType();
                wallOfArena[currentX][currentY] = block.BlockColor;
                break;
            }
            default:
            {
                System.out.print("Error\n");
                wallOfArena[currentX][currentY] = Color.GRAY;
            }
        }//End of switch
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
