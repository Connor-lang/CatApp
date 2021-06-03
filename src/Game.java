
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
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
class GameButton implements ActionListener {

    Button btGame;
    Frame f;

    GameButton() {
        f = new Frame();
        f.setSize(200, 250);
        f.setVisible(true);
        btGame = new Button("Game");
        btGame.addActionListener(this);
        f.add(btGame);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        f.setLayout(new FlowLayout());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btGame) {
            Maze m = new Maze();
        }
    }

    public static void main(String args[]) {
        new GameButton();
    }
}
