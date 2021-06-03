
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
public class BarChart extends JPanel {

    private java.util.Map<Integer, Integer> bars = new HashMap<Integer, Integer>();
    private java.util.ArrayList<Integer> list;
    int originX = 20;
    int originY = 20;
    int a, b, height3, height4;
    long x, y;

    public BarChart(int a, int b, long x, long y) {
        super();
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
    }

    public void addBar(Graphics2D g2d) {
        int barWidth = 350;
        double height1 = a * 100 / (y - x);
        height3 = (int) (height1);
        double height2 = b * 10 / (y  - x);
        height4 = (int) (height2);
        
        Rectangle rec1 = new Rectangle(21, 579 - height3 * 10, 320, height3 * 10);
        Rectangle rec2 = new Rectangle(341, 579 - height4 * 10, 320, height4 * 10);
        g2d.setColor(Color.YELLOW);
        g2d.fill(rec1);
        g2d.setColor(Color.GREEN);
        g2d.fill(rec2);
        g2d.setColor(Color.BLACK);
    }

    public void addAxes(Graphics2D g2d) {
        g2d.drawLine(20, 580, 680, 580);
        g2d.drawLine(20, 20, 20, 580);
        Font font = new Font("Helvetica", Font.PLAIN, 20);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(-90), 0, 0);
        Font rotatedFont = font.deriveFont(affineTransform);
        g2d.setFont(rotatedFont);
        g2d.drawString("Rate", 20, 300);
        g2d.setFont(font);
    }

    private void addText(Graphics2D g2d) {
        g2d.drawString("Feeding Rate" , 110, 600);
        g2d.drawString("Happiness Growth Rate" , 401, 600);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        addAxes(g2d);
        addBar(g2d);
        addText(g2d);
    }
}
