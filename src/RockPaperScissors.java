
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
public class RockPaperScissors extends JFrame {

    Random rand = new Random();
    JFrame f;

    public RockPaperScissors() {
        super("Rock Paper Scissors");
        this.initFrame();
        this.setLocation(600, 400);
        this.setSize(460, 170);
        this.setVisible(true);
    }

    private void initFrame() {
        ImageIcon Rock = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Rock.png");
        ImageIcon Scissors = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Scissors.png");
        ImageIcon Paper = new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Paper.png");

        Container contentPane = this.getContentPane();
        JPanel iconPane = new JPanel();
        JPanel clickPane = new JPanel();
        JPanel SelectRock = new JPanel();
        SelectRock.add(new RockPane());
        JPanel SelectScissor = new JPanel();
        SelectScissor.add(new ScissorPane());
        JPanel SelectPaper = new JPanel();
        SelectPaper.add(new PaperPane());
        JButton btRock = new JButton("Rock");
        JButton btScissors = new JButton("Scissors");
        JButton btPaper = new JButton("Paper");
        iconPane.setLayout(new GridLayout(0, 3));
        iconPane.add(SelectRock);
        iconPane.add(SelectScissor);
        iconPane.add(SelectPaper);
        clickPane.setLayout(new GridLayout(0, 3));
        clickPane.add(btRock);
        clickPane.add(btScissors);
        clickPane.add(btPaper);
        contentPane.add(iconPane, BorderLayout.CENTER);
        contentPane.add(clickPane, BorderLayout.SOUTH);

        btRock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = rand.nextInt(3);
                switch (number) {
                    case 0:
                        JOptionPane.showMessageDialog(f, "Draw", "Result", JOptionPane.INFORMATION_MESSAGE, Rock);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(f, "You lost", "Result", JOptionPane.INFORMATION_MESSAGE, Paper);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(f, "You win", "Result", JOptionPane.INFORMATION_MESSAGE, Scissors);
                        break;
                }
            }
        });
        btScissors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = rand.nextInt(3);
                switch (number) {
                    case 0:
                        JOptionPane.showMessageDialog(f, "You lost", "Result", JOptionPane.INFORMATION_MESSAGE, Rock);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(f, "You win", "Result", JOptionPane.INFORMATION_MESSAGE, Paper);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(f, "Draw", "Result", JOptionPane.INFORMATION_MESSAGE, Scissors);
                        break;
                }
            }
        });
        btPaper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = rand.nextInt(3);
                switch (number) {
                    case 0:
                        JOptionPane.showMessageDialog(f, "You win", "Result", JOptionPane.INFORMATION_MESSAGE, Rock);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(f, "Draw", "Result", JOptionPane.INFORMATION_MESSAGE, Paper);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(f, "You lost", "Result", JOptionPane.INFORMATION_MESSAGE, Scissors);
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        new RockPaperScissors();
    }
}
