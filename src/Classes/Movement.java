package Classes;

import java.awt.*;

public class Movement{

    public static void moveLeft(Arena game, Color [][] arenaWall, int currentX, int currentY, Block thisBlock){

        if(arenaWall[currentX-1][currentY] == Color.BLACK)
        {
            arenaWall[currentX][currentY] = Color.BLACK;
            game.setCurrentX(currentX--);
            arenaWall[currentX][currentY] = thisBlock.getColour();
            //System.out.print("Is working\n");
        }
    }//End of moveLeft method


    public static void moveRight(Arena game, Color [][] arenaWall, int currentX, int currentY, Block thisBlock){

        if(arenaWall[currentX+1][currentY] == Color.BLACK)
        {
            arenaWall[currentX][currentY] = Color.BLACK;
            game.setCurrentX(currentX++);
            arenaWall[currentX][currentY] = thisBlock.getColour();
            //System.out.print("Is working\n");
        }
    }//End of moveRight method


    public static void dropTheBlock(Arena game, Color [][] arenaWall, int currentX, int currentY, Block thisBlock){

        if(arenaWall[currentX][currentY+1] == Color.BLACK)
        {
            arenaWall[currentX][currentY] = Color.BLACK;
            game.setCurrentY(currentY++);
            arenaWall[currentX][currentY] = thisBlock.getColour();
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
                gameScore.setCurrentScore(thisBlock.getBlockScore());
                //System.out.print(thisBlock.getBlockScore());
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
                gameScore.setCurrentScore(thisBlock.getBlockScore());
                //System.out.print(thisBlock.getBlockScore());
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
                gameScore.setCurrentScore(thisBlock.getBlockScore());
                //System.out.print(thisBlock.getBlockScore());
            }
            else
            {
                arenaWall[currentX][currentY] = Color.GRAY;
            }
        }
        //System.out.print(gameScore.getCurrentScore()+"\n");
    }//End of lastBlock
}//End of Movement Class
