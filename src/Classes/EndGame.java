package Classes;

import javax.swing.*;
import java.awt.*;

public class EndGame{
    private String loseMessage;
    private String name;

    public void youLose(int currentScore, JFrame gameArena)
    {
        gameArena.setVisible(false);

        JFrame endScreen = new JFrame("You lose!");
        endScreen.setSize(300, 300);
        endScreen.setLayout(new FlowLayout());
        loseMessage = "Game Over! Thanks for playing";
        JTextArea loseArea = new JTextArea(loseMessage);
        endScreen.add(loseArea);

        endScreen.setVisible(true);
    }
}//End of EndGame Class
