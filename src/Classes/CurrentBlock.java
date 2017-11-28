package Classes;

import java.awt.*;

public class CurrentBlock {

    private Block thisBlock;

    public Color getColour() {return thisBlock.getColour();}

    public Block getThisBlock() { return thisBlock;}

    public CurrentBlock ()
    {
        int random = (int)(Math.random()*100);

        while(random <= 0 || random > 3) {
            random = (int)(Math.random()*100);
        }

        switch (random) {
            case 1: {
                RedBlock block = new RedBlock();
                block.setBlockType();
                block.setBlockScore();
                block.setColour();
                thisBlock = block;
                break;
            }
            case 2: {
                GreenBlock block = new GreenBlock();
                block.setBlockType();
                block.setBlockScore();
                block.setColour();
                thisBlock = block;
                break;
            }
            case 3: {
                BlueBlock block = new BlueBlock();
                block.setBlockType();
                block.setBlockScore();
                block.setColour();
                thisBlock = block;
                break;
            }
            default: {
                System.out.print("Error\n");
            }
        }
    }
}//End of Blocks class
