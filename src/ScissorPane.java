
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
public class ScissorPane extends JPanel {

    ImageIcon Image = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Scissors.png");
    Image Scissor  = Image.getImage();

    public ScissorPane() {
        this.setPreferredSize(new Dimension(150, 150));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Scissor, 38, 0, this);
    }
}
