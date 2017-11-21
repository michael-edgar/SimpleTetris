package Classes;

import java.awt.*;

public class BlueBlock extends CurrentBlock{

    //Attributes
    Color BlockColor = new Color(0, 0, 255);

    public void setBlockType()
    {

        BlockColor = Color.BLUE;

    }//End of setBlockType

    public void setScore() { scoreValue = 50; }


    public int getBlockScore() {
        return scoreValue;
    }
}//End of BlueBlock Class
