
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
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
public class GameOver extends JFrame{
    public GameOver() {
        super("Game Over");
        this.initFrame();
        this.pack();
        this.setLocation(600, 400);
        this.setSize(700, 120);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initFrame() {
        Container contentPane = this.getContentPane();
        JPanel gameOverPanel = new JPanel(); 
        JLabel gameOverLabel = new JLabel("YOUR CAT DIED OF HUNGER");
        Font endgame = new Font("Helvetica", Font.BOLD, 40);
        gameOverLabel.setFont(endgame);
        gameOverLabel.setForeground(Color.red);
        gameOverPanel.add(gameOverLabel);
        contentPane.add(gameOverPanel);
    }
    
}
