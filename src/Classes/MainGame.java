package Classes;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.sql.Time;
import java.time.Instant;

public class MainGame{
    private static long gameSpeed = 1000;
    private static long gameStart;

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
        gameStart = System.nanoTime();
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
                    Movement.dropTheBlock(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY(), Arena.thisBlock.getThisBlock());
                    if(game.getCurrentY() < 9)
                    {
                        game.setCurrentY(game.getCurrentY()+1);
                    }
                    else if(game.getCurrentY() == 9)
                    {
                        Movement.lastBlock(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY(), gameScore, Arena.thisBlock.getThisBlock());
                    }
                    //System.out.print(game.getCurrentY());
                    game.repaint();
                }

                else if(e.getKeyCode() == KeyEvent.VK_W)
                {
                    Movement.moveLeft(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY(), Arena.thisBlock.getThisBlock());
                    if(game.getCurrentX() > 1)
                    {
                        game.setCurrentX(game.getCurrentX()-1);
                    }
                    //System.out.print(game.getCurrentX());
                    game.repaint();
                }
                else if (e.getKeyCode() == KeyEvent.VK_R)
                {
                    Movement.moveRight(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY(), Arena.thisBlock.getThisBlock());

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
                        Thread.sleep(gameSpeed);
                        Movement.dropTheBlock(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY(), Arena.thisBlock.getThisBlock());
                        if(game.getCurrentY() < 9)
                        {
                            game.setCurrentY(game.getCurrentY()+1);
                        }
                        else if(game.getCurrentY() == 9)
                        {
                            Movement.lastBlock(game,game.getWallOfArena(), game.getCurrentX(), game.getCurrentY(), gameScore, Arena.thisBlock.getThisBlock());
                        }
                        game.repaint();

                    } catch ( InterruptedException e ) {}
                }
            }
        }.start();
    }//End of main method

    public void setGameSpeed()
    {
        if ((System.nanoTime()- gameStart)%10000 == 0)
        {
            gameSpeed -= 10;
        }

    }
}//End of MainGame Class
