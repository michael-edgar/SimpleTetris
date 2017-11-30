package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
    public static void main(String[] args) {
        JFrame menu = new JFrame("Menu");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(500,200);

        menu.setIconImage(new ImageIcon("Tetris-Logo.jpg").getImage());
        JMenuBar menuBar = new JMenuBar();
        menu.setJMenuBar(menuBar);
        FlowLayout menuLayout = new FlowLayout();
        menu.setLayout(menuLayout);
        JMenu myGame = createJMenu("Mike's Game", "Simple Tetris", menu, args);
        JMenu eTetris = createJMenu("Example Game", "Tetris", menu, args);
        menuBar.add(myGame);
        menuBar.add(eTetris);
        menu.setVisible(true);
    }//End of main method

    private static JMenu createJMenu(String menuText, String itemText, JFrame menu, String[] args)
    {
        JMenu makeMenu = new JMenu(menuText);
        JMenuItem makeItem = new JMenuItem(itemText);
        makeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                if(itemText.equals("Simple Tetris"))
                {
                    MainGame.main(args);
                }
                else
                {
                    TetrisExample.main(args);
                }
            }
        });//End of myGame Listener
        makeMenu.add(makeItem);
        return makeMenu;
    }
}//End of MainMenu Class
