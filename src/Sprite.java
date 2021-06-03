
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Sprite {
    protected int x; 
    protected int y; 
    protected int width; 
    protected int height; 
    protected boolean visible; 
    protected Image image; 
    
    public Sprite(int x, int y) {
        this.x = x;
        this.y = y; 
        visible = true;
    }
    
    protected void getImageDimensions() {
        width = image.getWidth(null); 
        height = image.getHeight(null); 
    }
    
    protected void loadImage(String imageName) {
        ImageIcon imageIcon = new ImageIcon(imageName);
        image = imageIcon.getImage();
    }
    
    public Image getImage() {
        return image; 
    }
    
    public int getX() {
        return x; 
    }
    
    public int getY() {
        return y; 
    }
    
    public boolean isVisible() {
        return visible;
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
