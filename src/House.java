
import java.awt.Image;
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
public class House {
    private Image House; 
    private int x, y; 
    
    public House() {
        ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\House.png");
        House = Image.getImage();
        x = 18; 
        y = 1;
    }
    
    public Image getHouse() {
        return House; 
    }
    
    public int getX() {
        return x; 
    }
    
    public int getY() {
        return y; 
    }
}
