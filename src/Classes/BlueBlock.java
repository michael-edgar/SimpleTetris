package Classes;

import java.awt.*;

public class BlueBlock extends Block{

    //Mutator Methods

    public void setBlockType() { thisBlock = new BlueBlock();}

    public void setBlockScore() { scoreValue = 50; }

    public void setColour() { blockColour = Color.BLUE; }

    //Accessor Methods

    public Color getColour() { return blockColour;}

    public int getBlockScore() {
        return scoreValue;
    }

    //Constructor Method

    public BlueBlock()
    {
        setColour();
        setBlockScore();
    }
}//End of BlueBlock Class
