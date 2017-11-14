package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Arena extends JPanel{

    JFrame gameArena = new JFrame("Simple Tetris");
    int currentX = 4, currentY = 0;

    public static void main(String[] args)
    {
        JFrame gameArena = new JFrame("Simple Tetris");
        //gameArena.setLayout(new GridLayout(12,7));
        gameArena.setSize(510,698);
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

        Timer gameTime = new Timer(1000, null);

        gameArena.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_E)
                {
                    gameTime.start();
                    System.out.print("Works \n");
                    game.dropTheBlock();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }//End of main method

    private void dropTheBlock() {
        Color setColor;

        if(wallOfArena[currentX][currentY] == Color.BLUE)
        {
            setColor = Color.BLUE;
            System.out.print("Blue\n");
        }
        else if(wallOfArena[currentX][currentY] == Color.GREEN)
        {
            setColor = Color.GREEN;
            System.out.print("Green\n");
        }
        else if(wallOfArena[currentX][currentY] == Color.RED)
        {
            setColor = Color.RED;
            System.out.print("Red\n");
        }
        else
        {
            setColor = Color.GRAY;
            System.out.print("Error\n");
        }

        wallOfArena[currentX][currentY] = Color.BLACK;
        currentX = 5;
        currentY = 6;
        wallOfArena[currentX][currentY] = setColor;
        System.out.print("Is working\n");
    }

    private Color[][] wallOfArena = new Color[9][12];

    private void Wall()
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
                wallOfArena[currentX][currentY] = block.BlockColor;
                break;
            }
            case 2:
            {
                GreenBlock block = new GreenBlock();
                block.setBlockType();
                wallOfArena[currentX][currentY] = block.BlockColor;
                break;
            }
            case 3:
            {
                BlueBlock block = new BlueBlock();
                block.setBlockType();
                wallOfArena[currentX][currentY] = block.BlockColor;
                break;
            }
            default:
            {
                wallOfArena[4][0] = Color.GRAY;
            }
        }//End of switch
    }//End of Wall Method

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
    }

    public void Update()
    {
        Timer gameTime = new Timer(1500, null);

        gameArena.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_E)
                {
                    gameTime.start();
                    System.out.print("Works");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        while(gameTime.isRunning())
        {
            System.out.print(gameTime.toString());
        }
    }

}//End of Arena Class
