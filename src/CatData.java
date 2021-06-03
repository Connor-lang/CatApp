
import java.awt.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP           
 */
public class CatData {
    private static Image CreatedCat, CreatedFrontImage;
    private int x, y, tileX, tileY;
    private static int hunger;
    
    public CatData() {
        x = 1; 
        y = 1;
    }; 
    
    public int getHunger() {
        return hunger;
    }
    
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
    
    public Image getCreatedCat() {
        return CreatedCat; 
    } 
    
    public Image getCreatedFrontImage() {
        return CreatedFrontImage; 
    }
    
    public static void setCreatedCat(Image CreatedCat) {
        CatData.CreatedCat = CreatedCat; 
    }
    
    public static void setCreatedFrontImage(Image CreatedFrontImage) {
        CatData.CreatedFrontImage = CreatedFrontImage;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTileX() {
        return x * 32;
    }

    public int getTileY() {
        return y * 32;
    }
    
    public void moveUp() {
        y -= 1;
    }

    public void moveDown() {
        y += 1;
    }

    public void moveRight() {
        x += 1;
    }

    public void moveLeft() {
        x -= 1;
    }
    
    public void display() {
        System.out.println(CreatedCat);
    }
}
