package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EndGame implements Serializable{
    public static String name;
    public static File outFile, inFile;
    public static FileOutputStream outputStream;
    public static FileInputStream inputStream;
    public static ObjectOutputStream outObjectStream;
    public static ObjectInputStream inObjectStream;


    public void youLose(Score gameScore, JFrame gameArena)
    {
        gameArena.setVisible(false);
        loseFrame(gameScore);
        outFile = new File("highScore.data");
        inFile = new File("highScore.data");
        try {
            outputStream = new FileOutputStream(outFile);
            outObjectStream = new ObjectOutputStream(outputStream);
            inputStream = new FileInputStream(inFile);
            inObjectStream = new ObjectInputStream(inputStream);
        }
        catch(IOException ioe)
        {
            System.out.print("Error! File Not Found");
        }
    }

    public Score startScore()
    {
        Score gameScore = new Score();

        try{
            gameScore = (Score)inObjectStream.readObject();
        }
        catch (IOException ioe)
        {
            gameScore = new Score();
            System.out.print("Not reading Score");
        }
        catch (ClassNotFoundException cnfe)
        {
            gameScore = new Score();
            System.out.print("Not reading Score");
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
            loseArea.append("\n   Please enter your name: ");
            JTextField nameField = new JTextField(30);
            endScreen.add(nameField);
            nameField.grabFocus();
            JButton enterName = new JButton("Enter and Close");
            enterName.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    name = nameField.getText();
                    gameScore.setHighScore(gameScore.getCurrentScore(), name);
                    try {
                        outObjectStream.writeObject(gameScore.highString());
                    }
                    catch (IOException ioe)
                    {
                        System.out.print("Error! File Not Found");
                    }
                    System.exit(0);
                }
            });
            endScreen.add(enterName);
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
    }
}//End of EndGame Class
