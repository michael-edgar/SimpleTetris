package Classes;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainGame{
    //JFrame gameArena = new JFrame("Simple Tetris");

    public static void main(String[] args)
    {
        long gameStart = System.currentTimeMillis();
        JFrame gameArena = new JFrame("Simple Tetris");
        //gameArena.setLayout(new FlowLayout());
        gameArena.setSize(510,698);
        gameArena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        game.setCurrentX(4);
        game.setCurrentY(0);
        game.Wall();
        game.setCurrent(game.getCurrentX(), game.getCurrentY());
        gameArena.add(game);
        gameArena.setVisible(true);

        //Timer gameTime = new Timer(1000, null);

        gameArena.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_E)
                {
                    //gameTime.start();
                    //System.out.print("Works \n");
                    Movement.dropTheBlock(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY());
                    if(game.getCurrentY() < 9)
                    {
                        game.setCurrentY(game.getCurrentY()+1);
                    }
                    else if(game.getCurrentY() == 9)
                    {
                        Movement.lastBlock(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY());
                    }
                    System.out.print(game.getCurrentY());
                    game.repaint();
                }

                else if(e.getKeyCode() == KeyEvent.VK_W)
                {
                    Movement.moveLeft(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY());
                    if(game.getCurrentX() > 1)
                    {
                        game.setCurrentX(game.getCurrentX()-1);
                    }
                    System.out.print(game.getCurrentX());
                    game.repaint();
                }
                else if (e.getKeyCode() == KeyEvent.VK_R)
                {
                    Movement.moveRight(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY());

                    if(game.getCurrentX() < 7)
                    {
                        game.setCurrentX(game.getCurrentX()+1);
                    }
                    System.out.print(game.getCurrentX());
                    game.repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        if(System.currentTimeMillis() - gameStart == 1000)
        {
            Update(game);
        }
    }//End of main method

    public static void Update(Arena game)
    {
        System.out.print("Works \n");
        Movement.dropTheBlock(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY());
        if(game.getCurrentY() < 9)
        {
            game.setCurrentY(game.getCurrentY()+1);
        }
        else if(game.getCurrentY() == 9)
        {
            Movement.lastBlock(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY());
        }
        System.out.print(game.getCurrentY());
        game.repaint();
    }
}//End of MainGame Class
