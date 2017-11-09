package Classes;

import javax.swing.*;
import java.awt.*;

public class Arena extends JPanel{


    public static void main(String[] args)
    {
        JFrame gameArena = new JFrame("Simple Tetris");
        //gameArena.setLayout(new GridLayout(12,7));
        gameArena.setSize(300,700);
        gameArena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameArena.setVisible(true);

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

        Arena game = new Arena();
        game.Wall();
        gameArena.add(game);

    }//End of main method

    private Color[][] wallOfArena = new Color[5][12];

    private void Wall()
    {
        for(int j = 0; j < 12; j++) {
            for(int i = 0; i < 5; i++) {
                if(i == 0 || i == 4 || j == 11) {
                    wallOfArena[i][j] = Color.GRAY;
                }
                else if(j == 10 && i == 1) {
                    wallOfArena[i][j] = Color.BLUE;
                }
                else if(j == 10 && i == 2) {
                    wallOfArena[i][j] = Color.RED;
                }
                else if(j == 10 && i == 3) {
                    wallOfArena[i][j] = Color.GREEN;
                }
                else {
                    wallOfArena[i][j] = Color.BLACK;
                }
            }
        }

        int random = (int)(Math.random()*100);

        while(random <= 0 || random > 3) {
            random = (int)(Math.random()*100);
        }

        switch (random)
        {
            case 1:
            {
                RedBlock block = new RedBlock();
                block.setBlockType();
                wallOfArena[2][0] = block.BlockColor;
                break;
            }
            case 2:
            {
                GreenBlock block = new GreenBlock();
                block.setBlockType();
                wallOfArena[2][0] = block.BlockColor;
                break;
            }
            case 3:
            {
                BlueBlock block = new BlueBlock();
                block.setBlockType();
                wallOfArena[2][0] = block.BlockColor;
                break;
            }
            default:
            {
                wallOfArena[2][0] = Color.GRAY;
            }
        }//End of switch
    }//End of Wall Method

    @Override
    public void paintComponent(Graphics g)
    {
        g.fillRect(0,0, 55*5, 55*12);

        for(int j = 0; j < 12; j++)
        {
            for(int i = 0; i < 5; i++)
            {
                g.setColor(wallOfArena[i][j]);
                g.fillRect(55*i, 55*j, 54, 54);
            }
        }
    }

}//End of Arena Class
