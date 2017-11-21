package Classes;

import java.awt.*;

public abstract class Block {

    //Attributes
    protected int scoreValue;
    protected Color  blockColour;
    protected Block thisBlock;

    //Abstract Methods
    public abstract void setBlockType();

    public abstract void setColour();

    public abstract void setBlockScore();

    public abstract Block getBlockType();

    public abstract int getBlockScore();

    public abstract Color getColour();
}//End of Blocks class