
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
public class Munny {

    private Image Munny;
    private int x, y, width, height;
    private boolean visible;
    private List<Munny> munny;
    private static int amount = 25;
    
    public Munny() {}

    public Munny(int x, int y) {
        this.x = x;
        this.y = y;
        visible = true;
        ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Munny.png");
        Munny = Image.getImage();
    }
    
    
    public Image getImage() {
        return Munny;
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
    /*
    private void placeMunny() {
        munny = new ArrayList<>();
        loadImage("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Munny.png");
    }
*/
    public List<Munny> getMunny() {
        return munny;
    }
    
    public void getImageDimensions() {
        width = Munny.getWidth(null);
        height = Munny.getHeight(null);
    }
    
    public Rectangle getBounds() {
        return new Rectangle (x, y, width, height);
    }
    
    public static int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
