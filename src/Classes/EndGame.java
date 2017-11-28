package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EndGame{
    public static ObjectOutputStream os;
    public static ObjectInputStream is;


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
    }

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
    }

    public static void loseFrame(Score gameScore)
    {
        JFrame endScreen = new JFrame("You lose!");
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
            loseArea.append("\n   Congrats!! New High Score");
            JButton highScore = new JButton("Close");
            highScore.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //name = nameField.getText();
                    gameScore.setHighScore(gameScore.getCurrentScore());
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
            try {
                //os.writeObject(gameScore);
                System.out.print("Don't do it");
                os.close();
            }
            catch (IOException ioe)
            {
                System.out.print("Error! File Not Found");
            }
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
    }
}//End of EndGame Class
