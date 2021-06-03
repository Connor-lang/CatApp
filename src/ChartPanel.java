/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.awt.BorderLayout;
import java.awt.Container;


import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;

public class ChartPanel extends JFrame {
    
    private BarChart barChart;
    private GameData GameData = new GameData();

    public ChartPanel() {
        super("Stats");
        this.initFrame();
        this.pack();
        this.setLocation(600, 250);
        this.setSize(700, 670);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initFrame() {
        Container contentPane = this.getContentPane();
        JPanel chartPanel = new JPanel();
        chartPanel.setLayout(new BorderLayout());
        barChart = new BarChart(GameData.getFeedCount(), GameData.getCumulativeHappiness(), GameData.getStartTime(), GameData.getEndTime());
        chartPanel.add(barChart);
        JLabel title = new JLabel("Graph of Feeding Rate and Happiness Growth");
        chartPanel.add(title, BorderLayout.NORTH);
        contentPane.add(chartPanel);
    }

    public static void main(String[] args) {
        new ChartPanel();
    }
}
