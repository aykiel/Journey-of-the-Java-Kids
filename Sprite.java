import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.awt.image.ImageObserver;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.math.*;


public class Sprite extends JComponent
{
    private BufferedImage i = null;
    private BufferedImage subimage;

    private String file;

    private int rows;
    private int columns;
    private int width;
    private int height;

    public Sprite (String file, int width, int height)
    {
        setLayout(null);

        this.file = file;

        rows = (getImage(file).getWidth() / width);
        columns = (getImage(file).getHeight() / height);

        this.width = width;
        this.height = height;

        /*
        System.out.println(rows);
        System.out.println(columns);
        System.out.println(width);
        System.out.println(height);
        System.out.println(file);
        System.out.println(getImage(file).getWidth());
        System.out.println(getImage(file).getHeight());
        System.out.println();*/

        this.repaint();
    }

    public BufferedImage getImage(String file)
    {
        BufferedImage temp;
        try
        {
            return ImageIO.read(new File(file));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            BufferedImage a = new BufferedImage(1,1, 1);
            return a;
        }
    }

    public BufferedImage getSubimage(int num)
    {
        return getImage(file).getSubimage(num * width, 0, width, height);
    }

    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }


    public void draw(Graphics2D g, int x, int y, ImageObserver obs, int num)
    {
        g.drawImage(getSubimage(num), x, y, obs);

        if (num == rows){
            num = 0;}
        else {num++;}
    }
}