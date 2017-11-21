package Classes;

import java.awt.*;

public class RedBlock extends Block {

    //Mutator Methods

    public void setBlockType() { thisBlock = new RedBlock(); }

    public void setBlockScore() { scoreValue = 20; }

    public void setColour() { blockColour = Color.RED; }

    //Accessor Methods

    public Color getColour() { return blockColour;}

    public Block getBlockType() {return thisBlock;}

    public int getBlockScore() {
        return scoreValue;
    }

    //Constructor Method

    public RedBlock()
    {
        setColour();
        setBlockScore();
    }
}//End of RedBlock Class
