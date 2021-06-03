
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class LoginCatScreen extends JPanel{
    
    private static Image Cat, FrontImage;
    private GameData GameData = new GameData(); 

    public LoginCatScreen() {
        this.setPreferredSize(new Dimension(500, 500));
        if (GameData.getColor() == 0 && GameData.getStripe() == 0 && GameData.getEyeColor() == 0) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\White Black.png");
            Cat = Image.getImage();
            CatData.setCreatedCat(Cat);
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front White Black.png");
            FrontImage = Image.getImage();
            
        } else if (GameData.getColor() == 0 && GameData.getStripe() == 1 && GameData.getEyeColor() == 0) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\White Striped Black.png");
            Cat = Image.getImage();
            CatData.setCreatedCat(Cat);
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front White Striped Black.png");
            FrontImage = Image.getImage();
            
        } else if (GameData.getColor() == 0 && GameData.getStripe() == 0 && GameData.getEyeColor() == 1) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\White Blue.png");
            Cat = Image.getImage();
            CatData.setCreatedCat(Cat);
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front White Blue.png");
            FrontImage = Image.getImage();
            
        } else if (GameData.getColor() == 0 && GameData.getStripe() == 1 && GameData.getEyeColor() == 1) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\White Striped Blue.png");
            Cat = Image.getImage();
            CatData.setCreatedCat(Cat);
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front White Striped Blue.png");
            FrontImage = Image.getImage();
            
        } else if (GameData.getColor() == 1 && GameData.getStripe() == 0 && GameData.getEyeColor() == 0) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Grey Black.png");
            Cat = Image.getImage();
            CatData.setCreatedCat(Cat);
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Grey Black.png");
            FrontImage = Image.getImage();
            
        } else if (GameData.getColor() == 1 && GameData.getStripe() == 1 && GameData.getEyeColor() == 0) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Grey Striped Black.png");
            Cat = Image.getImage();
            CatData.setCreatedCat(Cat);
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Grey Striped Black.png");
            FrontImage = Image.getImage();
            
        } else if (GameData.getColor() == 1 && GameData.getStripe() == 0 && GameData.getEyeColor() == 1) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Grey Blue.png");
            Cat = Image.getImage();
            CatData.setCreatedCat(Cat);
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Grey Blue.png");
            FrontImage = Image.getImage();
            
        } else if (GameData.getColor() == 1 && GameData.getStripe() == 1 && GameData.getEyeColor() == 1) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Grey Striped Blue.png");
            Cat = Image.getImage();
            CatData.setCreatedCat(Cat);
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Grey Striped Blue.png");
            FrontImage = Image.getImage();
            
        } else if (GameData.getColor() == 2 && GameData.getStripe() == 0 && GameData.getEyeColor() == 0) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Orange Black.png");
            Cat = Image.getImage();
            CatData.setCreatedCat(Cat);
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Orange Black.png");
            FrontImage = Image.getImage();
           
        } else if (GameData.getColor() == 2 && GameData.getStripe() == 1 && GameData.getEyeColor() == 0) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Orange Striped Black.png");
            Cat = Image.getImage();
            CatData.setCreatedCat(Cat);
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Orange Striped Black.png");
            FrontImage = Image.getImage();
            
        } else if (GameData.getColor() == 2 && GameData.getStripe() == 0 && GameData.getEyeColor() == 1) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Orange Blue.png");
            Cat = Image.getImage();
            CatData.setCreatedCat(Cat);
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Orange Blue.png");
            FrontImage = Image.getImage();
            
        } else if (GameData.getColor() == 2 && GameData.getStripe() == 1 && GameData.getEyeColor() == 1) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Orange Striped Blue.png");
            Cat = Image.getImage();
            CatData.setCreatedCat(Cat);
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Orange Striped Blue.png");
            FrontImage = Image.getImage();
        }
    }
    
    
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(FrontImage, 0, 0, this);
    }

    public static void main(String[] args) {
        new LoginCatScreen();
    }
}
