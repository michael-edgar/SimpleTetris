package Classes;

import javax.swing.*;
import java.awt.*;

public class Arena extends JFrame{


    public static void main(String[] args)
    {
        JFrame gameArena = new JFrame("Simple Tetris");
        gameArena.setLayout(new GridLayout(12,7));
        gameArena.setSize(300,500);

        /*for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 22; j++)
            {
                grid[j][i] = new JButton();
                gameArena.add(grid[j][i]);
            }
        }
        JButton[][] grid = new JButton[30][30];
        gameArena.pack();*/

        //Wall();
        gameArena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameArena.setVisible(true);
    }//End of main method

    private Color[][] wallOfArena = new Color[7][12];

    private void Wall()
    {
        for(int j = 0; j < 12; j++)
        {
            for(int i = 0; i < 7; i++)
            {
                if(i == 0 || i == 7 || j == 12)
                {
                    wallOfArena[i][j] = Color.GRAY;

                }
                else
                {
                    wallOfArena[i][j] = Color.BLACK;
                }
            }
        }
    }//End of Wall Method

    public void PaintWall(Graphics g)
    {
        g.fillRect(0,0, 26*7, 26*12);

        for(int j = 0; j < 12; j++)
        {
            for(int i = 0; i < 7; i++)
            {
                g.setColor(wallOfArena[i][j]);
                g.fillRect(26*i, 26*j, 25, 25);
            }
        }
    }

}//End of Arena Class
