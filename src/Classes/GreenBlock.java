package Classes;

import java.awt.*;

public class GreenBlock extends Block{

    //Mutator Methods

    public void setBlockType() { thisBlock = new GreenBlock(); }

    public void setBlockScore() { scoreValue = 30; }

    public void setColour() { blockColour = Color.GREEN; }

    //Accessor Methods

    public Color getColour() { return blockColour;}

    public int getBlockScore() {
        return scoreValue;
    }

    //Constructor Method

    public GreenBlock()
    {
        setColour();
        setBlockScore();
    }
}//End of GreenBlock Class
