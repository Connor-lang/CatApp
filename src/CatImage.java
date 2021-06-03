
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
public class CatImage {

    private static Image Cat1;
    
    public CatImage() {
        ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Grey Striped Black.png");
        Cat1 = Image.getImage();
    }
    
    public static Image getCatImage1() {
        return Cat1;
    }
    
    public static void main(String[] args) {
        new CatImage();
    }
}
