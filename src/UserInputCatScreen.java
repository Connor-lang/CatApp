/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author JY
 */
public class UserInputCatScreen extends JPanel {
    private CatImage CatImage = new CatImage();
    public UserInputCatScreen() {
        this.setPreferredSize(new Dimension(50, 50));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(CatImage.getCatImage1(), 0, 0, this);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Cat Image");
        f.pack();
        f.setSize(300, 300);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.add(new UserInputCatScreen());
    }
}
