
import java.awt.Image;
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
public class Cat {

    private static Image Cat, FrontImage, CCImage;
    private int x, y, width, height;
    private int color, stripe, eyeColor, personality;
    private static int level = 1, hunger = 100, happiness = 0;
    String Name,Color, Stripe, EyeColor, Personality;
    private java.util.Date birthDate;

    public Cat() {
        birthDate = new java.util.Date();
        java.util.Random rand = new java.util.Random();
        color = rand.nextInt(3);
        stripe = rand.nextInt(2);
        eyeColor = rand.nextInt(2);
        personality = rand.nextInt(3);
        if (color == 0 && stripe == 0 && eyeColor == 0) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\White Black.png");
            Cat = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front White Black.png");
            FrontImage = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front White Black - Copy.png");
            CCImage = Image.getImage();
        } else if (color == 0 && stripe == 1 && eyeColor == 0) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\White Striped Black.png");
            Cat = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front White Striped Black.png");
            FrontImage = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front White Striped Black - Copy.png");
            CCImage = Image.getImage();
        } else if (color == 0 && stripe == 0 && eyeColor == 1) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\White Blue.png");
            Cat = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front White Blue.png");
            FrontImage = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front White Blue - Copy.png");
            CCImage = Image.getImage();
        } else if (color == 0 && stripe == 1 && eyeColor == 1) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\White Striped Blue.png");
            Cat = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front White Striped Blue.png");
            FrontImage = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front White Striped Blue - Copy.png");
            CCImage = Image.getImage();
        } else if (color == 1 && stripe == 0 && eyeColor == 0) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Grey Black.png");
            Cat = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Grey Black.png");
            FrontImage = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Grey Black - Copy.png");
            CCImage = Image.getImage();
        } else if (color == 1 && stripe == 1 && eyeColor == 0) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Grey Striped Black.png");
            Cat = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Grey Striped Black.png");
            FrontImage = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Grey Striped Black - Copy.png");
            CCImage = Image.getImage();
        } else if (color == 1 && stripe == 0 && eyeColor == 1) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Grey Blue.png");
            Cat = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Grey Blue.png");
            FrontImage = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Grey Blue - Copy.png");
            CCImage = Image.getImage();
        } else if (color == 1 && stripe == 1 && eyeColor == 1) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Grey Striped Blue.png");
            Cat = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Grey Striped Blue.png");
            FrontImage = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Grey Striped Blue - Copy.png");
            CCImage = Image.getImage();
        } else if (color == 2 && stripe == 0 && eyeColor == 0) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Orange Black.png");
            Cat = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Orange Black.png");
            FrontImage = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Orange Black - Copy.png");
            CCImage = Image.getImage();
        } else if (color == 2 && stripe == 1 && eyeColor == 0) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Orange Striped Black.png");
            Cat = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Orange Striped Black.png");
            FrontImage = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Orange Striped Black - Copy.png");
            CCImage = Image.getImage();
        } else if (color == 2 && stripe == 0 && eyeColor == 1) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Orange Blue.png");
            Cat = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Orange Blue.png");
            FrontImage = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Orange Blue - Copy.png");
            CCImage = Image.getImage();
        } else if (color == 2 && stripe == 1 && eyeColor == 1) {
            ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Orange Striped Blue.png");
            Cat = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Orange Striped Blue.png");
            FrontImage = Image.getImage();
            Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Front Orange Striped Blue - Copy.png");
            CCImage = Image.getImage();
        }

        x = 1;
        y = 1;

    }

    public static Image getCat() {
        return Cat;
    }
    
    public int getcolor() {
        return color;
    }
    
    public int geteyecolor() {
        return eyeColor;
    }
    
    public int getstripe() {
        return stripe;
    }

    public Image getFrontImage() {
        return FrontImage;
    }
    
    public static Image getCCImage() {
        return CCImage;
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

    public String getColor() {
        switch (color) {
            case 0:
                Color = "White";
                break;
            case 1:
                Color = "Grey";
                break;
            case 2:
                Color = "Orange";
                break;
        }
        return Color;
    }

    public String getStripe() {
        switch (stripe) {
            case 0:
                Stripe = "No Stripe";
                break;
            case 1:
                Stripe = "Striped";
                break;
        }
        return Stripe;
    }

    public String getEyeColor() {
        switch (eyeColor) {
            case 0:
                EyeColor = "Black";
                break;
            case 1:
                EyeColor = "Blue";
                break;
        }
        return EyeColor;
    }

    public static int getLevel() {
        return level;
    }
    
    public static int getHunger() {
        return hunger; 
    }

    public String getPersonality() {
        switch (personality) {
            case 0:
                Personality = "Obedient";
                break;
            case 1:
                Personality = "Lazy";
                break;
            case 2:
                Personality = "Naughty";
                break;
        }
        return Personality; 
    }

    public java.util.Date getBirthDate() {
        return birthDate;
    }
    
    public String getName() {
        return Name;
    }
    
    public static int getHappiness() {
        return happiness;
    }
    
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
    
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }
    
    public void setBirthDate(java.util.Date birthDate) {
        this.birthDate = birthDate;
    }
    public void setPersonality(String Personality) {
        this.Personality = Personality;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setEyeColor(String EyeColor) {
        this.EyeColor = EyeColor;
    }
    public void setStripe(String Stripe) {
        this.Stripe = Stripe;
    }
    public void setColor(String Color) {
        this.Color = Color;
    }
    public void setImage(Image Cat) {
        this.Cat = Cat;
    }
    public void setFrontImage(Image FrontImage) {
        this.FrontImage = FrontImage;
    }

    public void getImageDimensions() {
        width = Cat.getWidth(null);
        height = Cat.getHeight(null);
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
        System.out.println("Name: " + Name + " Color: " + Color + " Personality: " + Personality + "Level: " + level + " Eye Color: " + EyeColor + " Stripe: " 
                + Stripe);
    }
}
