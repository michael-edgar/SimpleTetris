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
    private static long currentTime;
    private static long timeDifference;
    private static double elapsedSeconds;

    public static void main(String[] args)
    {
        JFrame gameArena = new JFrame("Simple Tetris");
        gameArena.setSize(510,698);
        gameArena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Arena game = new Arena();
        EndGame losing = new EndGame();
        Score gameScore = losing.startScore();
        game.setScores(gameScore);
        game.setCurrentX(4);
        game.setCurrentY(0);
        game.Wall();
        game.setCurrent(game.getCurrentX(), game.getCurrentY());
        gameArena.add(game);
        gameArena.setVisible(true);
        gameStart = System.nanoTime();
        //Conor
        gameArena.setIconImage(new ImageIcon("Tetris-Logo.jpg").getImage());
        gameArena.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE)
                {
                    Movement.dropTheBlock(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY(), Arena.thisBlock.getThisBlock());
                    if(game.getCurrentY() == 9)
                    {
                        Movement.lastBlock(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY(), gameScore, Arena.thisBlock.getThisBlock());
                        if(game.getWallOfArena()[game.getCurrentX()][game.getCurrentY()] == Color.GRAY)
                        {
                                losing.youLose(gameScore, gameArena);
                        }
                        game.setScores(gameScore);
                    }

                    else if(game.getCurrentY() < 9)
                    {
                        game.setCurrentY(game.getCurrentY()+1);
                    }
                    game.repaint();
                }

                else if(e.getKeyCode() == KeyEvent.VK_A)
                {
                    Movement.moveLeft(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY(), Arena.thisBlock.getThisBlock());
                    if(game.getCurrentX() > 1)
                    {
                        game.setCurrentX(game.getCurrentX()-1);
                    }
                    game.repaint();
                }
                else if (e.getKeyCode() == KeyEvent.VK_D)
                {
                    Movement.moveRight(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY(), Arena.thisBlock.getThisBlock());

                    if(game.getCurrentX() < 7)
                    {
                        game.setCurrentX(game.getCurrentX()+1);
                    }
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
                        currentTime = System.nanoTime();
                        timeDifference = currentTime - gameStart;
                        elapsedSeconds = timeDifference/1000000000;
                        setGameSpeed();
                        Movement.dropTheBlock(game, game.getWallOfArena(), game.getCurrentX(), game.getCurrentY(), Arena.thisBlock.getThisBlock());
                        if(game.getCurrentY() < 9)
                        {
                            game.setCurrentY(game.getCurrentY()+1);
                        }
                        else if(game.getCurrentY() == 9)
                        {
                            Movement.lastBlock(game,game.getWallOfArena(), game.getCurrentX(), game.getCurrentY(), gameScore, Arena.thisBlock.getThisBlock());

                            if(game.getWallOfArena()[game.getCurrentX()][game.getCurrentY()] == Color.GRAY)
                            {
                                    losing.youLose(gameScore, gameArena);
                                    break;
                            }
                            game.setScores(gameScore);
                        }
                        game.repaint();

                    } catch ( InterruptedException e ) {}
                }
            }
        }.start();
    }//End of main method

    public static void setGameSpeed()
    {
        if (elapsedSeconds%5 == 0)
        {
            if(gameSpeed > 0)
            {
                gameSpeed -= 10;
                System.out.print("gameSpeed: " +gameSpeed+ "\nElapsed Seconds: " +elapsedSeconds+ "\n");
            }
        }
    }//End of setGameSpeed
}//End of MainGame Class
