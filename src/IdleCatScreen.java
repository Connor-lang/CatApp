
import java.awt.Dimension;
import java.awt.Graphics;
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
public class IdleCatScreen extends JPanel {

    private CatData Data = new CatData();

    public IdleCatScreen() {
        this.setPreferredSize(new Dimension(500, 500));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Data.getCreatedFrontImage(), 0, 0, this);
    }

    public static void main(String[] args) {
        new IdleCatScreen();
    }
}
