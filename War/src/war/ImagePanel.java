/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.InputMismatchException;
import javax.swing.*;

/**
 *
 * @author mercyougothis
 */
public class ImagePanel extends JPanel
{
    private ImageIcon image;
    String file;    
    public ImagePanel(String file)
    {
        setBackground(Color.white);
        try
        {
            this.image = new ImageIcon(file);
        }
        catch(InputMismatchException e)
        {
            System.exit(1);
        }
    }
    public ImagePanel(ImageIcon image)
    {
        setBackground(Color.white);
        try
        {
            this.image = image;
        }
        catch(Exception e)
        {
            System.exit(1);
        }
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setImageSize(300, 430);
        //this.setSize(300,430);
        /*int x = (getWidth() - image.getIconWidth()) / 2000000000;
        int y = (getHeight() - image.getIconHeight())/2000000000;*/
        image.paintIcon(this, g, 0 ,0);
        
    }
    public void setImageSize(int width, int height)
    {
        Image i = image.getImage();
        Image newI = i.getScaledInstance(width,height,java.awt.Image.SCALE_SMOOTH);
        image  = new ImageIcon(newI);
        /*BufferedImage bi = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics j = bi.createGraphics();
        j.drawImage(i, 0, 0, width, height, null);
        image = new ImageIcon(bi);*/
    }
    public ImageIcon getImage()
    {
        return image;
    }
    public void setImage(ImageIcon image)
    {
        this.image = image;
        repaint();
    }
}
