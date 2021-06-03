
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JFrame;
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
public class SelectionPane {

    private Image Cat;
    private UserInputCatScreen uInCatScreen = new UserInputCatScreen();

    public static void main(String[] args) {

        JFrame window = new JFrame("Cat");
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(700, 400);
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 0));
        JPanel panel1 = new JPanel();
        JPanel panel2_ = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();
        JPanel panel11 = new JPanel();
        JPanel panel12 = new JPanel();
        panel.setLayout(new GridLayout(4, 3, 5, 10));
        JButton button = new JButton("Cat 1");
        JButton button2 = new JButton("Cat 2");
        JButton button3 = new JButton("Cat 3");
        JButton button4 = new JButton("Cat 4");
        JButton button5 = new JButton("Cat 5");
        JButton button6 = new JButton("Cat 6");
        JButton button7 = new JButton("Cat 7");
        JButton button8 = new JButton("Cat 8");
        JButton button9 = new JButton("Cat 9");
        JButton button10 = new JButton("Cat 10");
        JButton button11 = new JButton("Cat 11");
        JButton button12 = new JButton("Cat 12");

        panel2.add(new UserInputCatScreen());
        panel2.add(button2);
        panel.add(panel2);

        window.add(panel);
    }
}