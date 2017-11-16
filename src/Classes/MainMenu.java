package Classes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
    public static void main(String[] args) {
        JFrame menu = new JFrame("Menu");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(500,200);
        FlowLayout menuLayout = new FlowLayout();
        menu.setLayout(menuLayout);
        JButton eTetris = new JButton("Example Tetris");
        //menu.setIconImage();
        /*Border emptyBorder = BorderFactory.createEmptyBorder();
        eTetris.setBorder(emptyBorder);*/
        eTetris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                TetrisExample.main(args);
            }
        });//End of eTetris Listener
        JButton myGame = new JButton("Mike's Simple Tetris");
        myGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                MainGame.main(args);
            }
        });//End of myGame Listener

        menu.add(eTetris);
        menu.add(myGame);
        menu.setVisible(true);



    }//End of main method
}//End of MainMenu Class
