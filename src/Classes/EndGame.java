package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**<h1>End Game Class</h1>
 * This class defines what happens when the player loses the game.
 * It contains methods to both read and write the gamescore to a seperate file.
 * @author Michael Edgar
 * @since 2017-11-30
 */

public class EndGame{

    //Attributes
    public static ObjectOutputStream os;
    public static ObjectInputStream is;
    public static String name;

    /**This method is called by the MainGame class when the player has lost the
     * game. It closes the main game arena and calls a method to display a seperate
     * JFrame that informs the player the game is over. It also prompts them for their
     * name if they have obtained a new high score.
     * @param gameScore contains the current score and the current highscore.
     * @param gameArena this contains the main game arena so that it may be closed.
     */
    public void youLose(Score gameScore, JFrame gameArena)
    {
        gameArena.setVisible(false);
        loseFrame(gameScore);

        try {
            os = new ObjectOutputStream(new FileOutputStream("highScore.data"));
        }
        catch(IOException ioe)
        {
            System.out.print("Error! File Not Found");
            ioe.printStackTrace();
        }
    }//End of youLose method

    /**
     * This method sets up the score for the start of the game.
     * It does this by reading the highScore.data file and returning it.
     * It is called by the mainGame class
     * @return gameScore this returns the score that is saved in the highScore.data file
     */
    public Score startScore()
    {
        Score gameScore;

        try{
            is = new ObjectInputStream(new FileInputStream("highScore.data"));
            gameScore = (Score)is.readObject();
            gameScore.setCurrentScore(-gameScore.getCurrentScore());
            is.close();
        }
        catch (IOException ioe)
        {
            gameScore = new Score();
            System.out.print("Not reading Score\n");
        }
        catch (ClassNotFoundException cnfe)
        {
            gameScore = new Score();
            System.out.print("No Class\n");
        }
        catch (NullPointerException npe)
        {
            gameScore = new Score();
            System.out.print("Null Pointer\n");
        }

        return  gameScore;
    }//End of startScore method

    /**
     * This method sets up a JFrame for the end of game and compares the
     * current score to the high score to see if the player got a new high
     * score. It also closes the game.
     * @param gameScore This allows the method to display the player's
     * score and tests to see if they obtained a new high score.
     */

    public static void loseFrame(Score gameScore)
    {
        JFrame endScreen = new JFrame("You lose!");
        //Stack Overflow
        endScreen.setIconImage(new ImageIcon("Tetris-Logo.jpg").getImage());
        endScreen.setSize(500, 200);
        endScreen.setLayout(new FlowLayout());
        JTextArea loseArea = new JTextArea("Game Over! Thanks for playing \n     You Scored " +gameScore.getCurrentScore()+ " points");
        loseArea.setFont(new Font("monospaced", Font.PLAIN, 12  ));
        loseArea.setSize(30, 2);
        loseArea.setEditable(false);
        endScreen.add(loseArea);

        if(gameScore.getCurrentScore() > gameScore.getHighScore())
        {
            loseArea.append("\n   New High Score, please enter name: ");
            JTextField nameField = new JTextField(30);
            endScreen.add(nameField);
            JButton highScore = new JButton("Enter and Close");
            highScore.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    name = nameField.getText();
                    gameScore.setHighScore(gameScore.getCurrentScore(), name);
                    try {
                        os.writeObject(gameScore);
                        System.out.print("Saved");
                        os.close();
                    }
                    catch (IOException ioe)
                    {
                        System.out.print("Error! File Not Found");
                    }
                    System.exit(0);
                }
            });
            endScreen.add(highScore);
        }
        else
        {
            JButton closeGame = new JButton("Close");
            closeGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            endScreen.add(closeGame);
        }
        endScreen.setVisible(true);
    }//End of loseFrame method

    /**C:\Users\t00194492\Desktop\SimpleTetris> javaDoc EndGame.java*/
}//End of EndGame Class
