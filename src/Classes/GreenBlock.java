package Classes;

import java.awt.*;

public class GreenBlock extends CurrentBlock{

    //Attributes
    Color BlockColor = new Color(0);

    public void setBlockType()
    {

        BlockColor = Color.GREEN;

    }//End of setBlockType

    public void setScore() { scoreValue = 30; }

    public int getBlockScore() {
        return scoreValue;
    }
}//End of GreenBlock Class
