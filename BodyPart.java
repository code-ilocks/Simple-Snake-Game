import javax.swing.*;
import java.awt.*;

public class BodyPart{
    private int xCoor, yCoor, width, height;

    public BodyPart(int xCoor, int yCoor, int tileSize){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tileSize;
        height = tileSize;
    }

    public void tick(){

    }

    public void drawSnake(Graphics g){
        g.setColor(Color.green);
        g.fillRect(xCoor * width,yCoor * height,width,height);
    }

    public void setX(int xCoor){
        this.xCoor = xCoor;
    }

    public void setY(int yCoor){
        this.yCoor = yCoor;
    }

}
