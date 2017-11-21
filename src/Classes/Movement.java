package Classes;

import java.awt.*;

public class Movement{

    public static void moveLeft(Arena game, Color [][] arenaWall, int currentX, int currentY, Block thisBlock){
        Color setColour;

        if(arenaWall[currentX-1][currentY] == Color.BLACK)
        {
            setColour = thisBlock.getColour();
            arenaWall[currentX][currentY] = Color.BLACK;
            game.setCurrentX(currentX--);
            arenaWall[currentX][currentY] = setColour;
            //System.out.print("Is working\n");
        }
    }//End of moveLeft method


    public static void moveRight(Arena game, Color [][] arenaWall, int currentX, int currentY, Block thisBlock){
        Color setColour;

        if(arenaWall[currentX+1][currentY] == Color.BLACK)
        {
            setColour = thisBlock.getColour();
            arenaWall[currentX][currentY] = Color.BLACK;
            game.setCurrentX(currentX++);
            arenaWall[currentX][currentY] = setColour;
            //System.out.print("Is working\n");
        }
    }//End of moveRight method


    public static void dropTheBlock(Arena game, Color [][] arenaWall, int currentX, int currentY, Block thisBlock){
        Color setColour;

        if(arenaWall[currentX][currentY+1] == Color.BLACK)
        {
            setColour = thisBlock.getColour();
            arenaWall[currentX][currentY] = Color.BLACK;
            game.setCurrentX(currentX++);
            arenaWall[currentX][currentY] = setColour;
            //System.out.print("Is working\n");
        }
    }//End of dropTheBlock method

    public static void lastBlock(Arena game, Color[][] arenaWall, int currentX, int currentY, Score gameScore, Block thisBlock)
    {
        if(thisBlock.getColour() == Color.BLUE)
        {
            if(currentX == 3 && currentY == 9)
            {
                arenaWall[currentX][currentY] = Color.BLACK;

                game.setCurrent(4,0);

                BlueBlock block = new BlueBlock();
                block.setBlockScore();
                gameScore.setCurrentScore(block.getBlockScore());
                //System.out.print(block.getBlockScore());
            }
            else
            {
                arenaWall[currentX][currentY] = Color.GRAY;
            }
        }

        else if(thisBlock.getColour() == Color.RED)
        {
            if(currentX == 4 && currentY == 9)
            {
                arenaWall[currentX][currentY] = Color.BLACK;

                game.setCurrent(4,0);

                RedBlock block = new RedBlock();
                block.setBlockScore();
                gameScore.setCurrentScore(block.getBlockScore());
                //System.out.print(block.getBlockScore());
            }
            else
            {
                arenaWall[currentX][currentY] = Color.GRAY;
            }
        }

        else
        {
            if(currentX == 5 && currentY == 9)
            {
                arenaWall[currentX][currentY] = Color.BLACK;

                game.setCurrent(4,0);

                GreenBlock block = new GreenBlock();
                block.setBlockScore();
                gameScore.setCurrentScore(block.getBlockScore());
                //System.out.print(block.getBlockScore());
            }
            else
            {
                arenaWall[currentX][currentY] = Color.GRAY;
            }
        }
        //System.out.print(gameScore.getCurrentScore());
    }//End of lastBlock
}//End of Movement Class
