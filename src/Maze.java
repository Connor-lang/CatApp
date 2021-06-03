/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import javax.swing.*; 
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Maze {
    public static void main(String[] args) {
        new Maze(); 
    }
    
    public Maze() { 
        JFrame f = new JFrame(); 
        f.setTitle("Maze Game"); 
        f.add(new Board());
        f.setSize(646, 674); 
        f.setLocationRelativeTo(null); 
        f.setVisible(true);
        f.setResizable(false);
    }
}
