package Classes;

import java.awt.*;

public abstract class CurrentBlock {

    //Attributes
    private float [] size = new float[2];
    private boolean match;
    protected int scoreValue;

    //Abstract Methods
    public abstract void setBlockType();

    public abstract void setScore();

    //Mutator methods
    public void setSize(float[] size) { this.size = size; }

    //Accessor methods
    public float[] getSize() { return size; }

    //No argument constructor
    public CurrentBlock() { this(null); }

    //1 argument constructor
    public CurrentBlock(float[] size)
    {
        setSize(size);
        setBlockType();
    }//End of 1 argument constructor
}//End of Blocks class
