package Classes;

import java.awt.*;

public class Movement{

    public static void moveLeft(Arena game, Color [][] arenaWall, int currentX, int currentY){
        Color setColor;

        if(arenaWall[currentX-1][currentY] == Color.BLACK)
        {
            if(arenaWall[currentX][currentY] == Color.BLUE)
            {
                setColor = Color.BLUE;
                //System.out.print("Blue\n");
            }
            else if(arenaWall[currentX][currentY] == Color.GREEN)
            {
                setColor = Color.GREEN;
                //System.out.print("Green\n");
            }
            else if(arenaWall[currentX][currentY] == Color.RED)
            {
                setColor = Color.RED;
                //System.out.print("Red\n");
            }
            else
            {
                setColor = Color.GRAY;
                //System.out.print("Error\n");
            }

            arenaWall[currentX][currentY] = Color.BLACK;
            game.setCurrentX(currentX--);
            arenaWall[currentX][currentY] = setColor;
            //System.out.print("Is working\n");
        }
    }//End of moveLeft method


    public static void moveRight(Arena game, Color [][] arenaWall, int currentX, int currentY){
        Color setColor;

        if(arenaWall[currentX+1][currentY] == Color.BLACK)
        {
            if(arenaWall[currentX][currentY] == Color.BLUE)
            {
                setColor = Color.BLUE;
                //System.out.print("Blue\n");
            }
            else if(arenaWall[currentX][currentY] == Color.GREEN)
            {
                setColor = Color.GREEN;
                //System.out.print("Green\n");
            }
            else if(arenaWall[currentX][currentY] == Color.RED)
            {
                setColor = Color.RED;
                //System.out.print("Red Block\n");
            }
            else
            {
                setColor = Color.GRAY;
                //System.out.print("Error\n");
            }

            arenaWall[currentX][currentY] = Color.BLACK;
            game.setCurrentX(currentX++);
            arenaWall[currentX][currentY] = setColor;
            //System.out.print("Is working\n");
        }
    }//End of moveRight method


    public static void dropTheBlock(Arena game, Color [][] arenaWall, int currentX, int currentY){
        Color setColor;

        if(arenaWall[currentX][currentY+1] == Color.BLACK)
        {
            if(arenaWall[currentX][currentY] == Color.BLUE)
            {
                setColor = Color.BLUE;
                //System.out.print("Blue\n");
            }
            else if(arenaWall[currentX][currentY] == Color.GREEN)
            {
                setColor = Color.GREEN;
                //System.out.print("Green\n");
            }
            else if(arenaWall[currentX][currentY] == Color.RED)
            {
                setColor = Color.RED;
                //System.out.print("Red\n");
            }
            else
            {
                setColor = Color.GRAY;
                //System.out.print("Error\n");
            }

            arenaWall[currentX][currentY] = Color.BLACK;
            game.setCurrentY(currentY++);
            arenaWall[currentX][currentY] = setColor;
            //System.out.print("Is working\n");
        }
    }//End of dropTheBlock method

    public static void lastBlock(Arena game, Color[][] arenaWall, int currentX, int currentY, Score gameScore)
    {
        if(arenaWall[currentX][currentY] == Color.BLUE)
        {
            if(currentX == 3 && currentY == 9)
            {
                arenaWall[currentX][currentY] = Color.BLACK;

                game.setCurrent(4,0);

                BlueBlock block = new BlueBlock();
                block.setScore();
                gameScore.setCurrentScore(block.getBlockScore());
                //System.out.print(block.getBlockScore());
            }
            else
            {
                arenaWall[currentX][currentY] = Color.GRAY;
            }
        }

        else if(arenaWall[currentX][currentY] == Color.RED)
        {
            if(currentX == 4 && currentY == 9)
            {
                arenaWall[currentX][currentY] = Color.BLACK;

                game.setCurrent(4,0);

                RedBlock block = new RedBlock();
                block.setScore();
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
                block.setScore();
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
