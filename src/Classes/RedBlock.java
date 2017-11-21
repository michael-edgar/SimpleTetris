package Classes;

import java.awt.*;

public class RedBlock extends CurrentBlock {

    //Attributes
    Color  BlockColor = new Color(255,0,0);

    public void setBlockType()
    {

        BlockColor = Color.RED;

    }//End of setBlockType

    public void setScore() { scoreValue = 20; }

    public int getBlockScore() {
        return scoreValue;
    }
}//End of RedBlock Class
