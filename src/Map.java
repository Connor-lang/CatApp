
import java.awt.Image;
import java.io.File;
import java.util.Scanner;
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
public class Map {
    
    private Scanner scanner;
    private String Maze[] = new String[20];
    private Image Wall, Munny, House, Empty;
    
    public Map() {
        ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Wall.png");
        Wall = Image.getImage();
        Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Munny.png");
        Munny = Image.getImage(); 
        Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\House.png");
        House = Image.getImage();
        Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Empty.png");
        Empty = Image.getImage();
        
        openFile();
        readFile(); 
        closeFile();
    }
    
    public Image getMunny() {
        return Munny;
    }
    
    public Image getEmpty() {
        return Empty;
    }
    
    public Image getWall() {
        return Wall; 
    }
    
    public Image getHouse() {
        return House; 
    }
    
    public String getMaze(int x, int y) {
        String index = Maze[y].substring(x, x + 1);
        return index;
    }
    
    public String replaceMunny(int x, int y) {
        String index = Maze[y].substring(x, x + 1);
        index = "G"; 
        return index; 
    }
    public void openFile() {
        try {
        scanner = new Scanner(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Maze.txt"));
        }catch (Exception ex) {
            System.out.println("Error loading map");
        }
    }
    
    public void readFile() {
        while(scanner.hasNext()){
            for(int i = 0; i < 20; i++)
                Maze[i] = scanner.next();
        }
    }
    
    public void closeFile() {
    
    }
}
