import java.awt.*;

public class Food {

    private int xCoor, yCoor, width, height;

    public Food(int xCoor, int yCoor, int tileSize){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tileSize;
        height = tileSize;
    }

    public void tick(){

    }

    public int getxCoor(){
        return xCoor;
    }

    public int getyCoor(){
        return yCoor;
    }

    public void putFood(Graphics g){
        g.setColor(Color.red);
        g.fillRect(xCoor * width,yCoor * height,width,height);
    }


}
