package Classes;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class MainGame{
    //JFrame gameArena = new JFrame("Simple Tetris");

    public static void main(String[] args)
    {
        JFrame gameArena = new JFrame("Simple Tetris");
        gameArena.setSize(510,698);
        gameArena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Arena game = new Arena();
        Score gameScore  = new Score();
        game.setCurrentX(4);
        game.setCurrentY(0);
        game.Wall();
        game.setCurrent(game.getCurrentX(), game.getCurrentY());
        gameArena.add(game);
        gameArena.setVisible(true);
        gameArena.setIconImage(new ImageIcon("Tetris-Logo.jpg").getImage());
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
                        Movement.lastBlock(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY(), gameScore);
                    }
                    //System.out.print(game.getCurrentY());
                    game.repaint();
                }

                else if(e.getKeyCode() == KeyEvent.VK_W)
                {
                    Movement.moveLeft(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY());
                    if(game.getCurrentX() > 1)
                    {
                        game.setCurrentX(game.getCurrentX()-1);
                    }
                    //System.out.print(game.getCurrentX());
                    game.repaint();
                }
                else if (e.getKeyCode() == KeyEvent.VK_R)
                {
                    Movement.moveRight(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY());

                    if(game.getCurrentX() < 7)
                    {
                        game.setCurrentX(game.getCurrentX()+1);
                    }
                    //System.out.print(game.getCurrentX());
                    game.repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        new Thread() {
            @Override public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        Movement.dropTheBlock(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY());
                        if(game.getCurrentY() < 9)
                        {
                            game.setCurrentY(game.getCurrentY()+1);
                        }
                        else if(game.getCurrentY() == 9)
                        {
                            Movement.lastBlock(game,game.getWallOfArena(), game.getCurrentX(), game.getCurrentY(), gameScore);
                        }
                        game.repaint();

                    } catch ( InterruptedException e ) {}
                }
            }
        }.start();
    }//End of main method
}//End of MainGame Class
