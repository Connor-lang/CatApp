
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private static int score;
    private Map m = new Map();
    private boolean ingame;
    private CatData CatData = new CatData();
    private GameData GameData = new GameData();
    private Graphics g;
    private static List<Munny> munnies;
    private Munny Munny = new Munny();
    private House House = new House();
    private InputStream in;
    private AudioStream audio;
    private final int[][] location = {{3, 1}, {11, 1}, {15, 1}, {11, 6}, {6, 7}, {17, 7},
    {9, 8}, {2, 10}, {4, 10}, {11, 10}, {13, 10}, {15, 10}, {9, 12}, {4, 13}, {11, 16},
    {18, 16}, {1, 17}, {9, 18}, {6, 18}, {18, 18}};

    public Board() {
        initBoard();
    }

    private void initBoard() {
        System.out.println(GameData.getAmount());
        addKeyListener(new Movement());
        setFocusable(true);
        ingame = true;
        placeMunny();

        timer = new Timer(25, this);
        timer.start();
        
        if (!ingame) {
            AudioPlayer.player.stop(audio);
            AudioPlayer.player.stop(in);
        }
        
        else if (ingame) {
            try {
                in = new FileInputStream(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Maze BGM.wav"));
                AudioStream audio = new AudioStream(in);
                AudioPlayer.player.start(audio);
            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            } catch (IOException ex) {
                System.out.println("Problem with I/O");
            }
        }
        
    }

    public void placeMunny() {
        munnies = new ArrayList<Munny>();
        for (int[] position : location) {
            munnies.add(new Munny(position[0] * 32, position[1] * 32));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame) {
            System.out.println(ingame);
            drawMaze(g);
        } else {
            System.out.println(ingame);
            drawEnd(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawMaze(Graphics g) {
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                if (m.getMaze(x, y).equals("G")) {
                    g.drawImage(m.getEmpty(), x * 32, y * 32, null);
                }
                if (m.getMaze(x, y).equals("X")) {
                    g.drawImage(m.getWall(), x * 32, y * 32, null);
                }
            }
        }
        for (Munny munny : munnies) {
            if (munny.isVisible()) {
                g.drawImage(m.getMunny(), munny.getX(), munny.getY(), this);
            }
        }
        g.drawImage(House.getHouse(), House.getX() * 32, House.getY() * 32, null);
        g.drawImage(CatData.getCreatedCat(), CatData.getX() * 32, CatData.getY() * 32, null);
    }

    private void drawEnd(Graphics g) {
        String message = "Money Collected = " + score;
        System.out.println(score);
        Font endgame = new Font("Helvetica", Font.BOLD, 40);
        FontMetrics fm = getFontMetrics(endgame);
        g.setColor(Color.BLACK);
        g.setFont(endgame);
        g.drawString(message, (646 - fm.stringWidth(message)) / 2, 674 / 2);
        GameData.setAmount(GameData.getAmount() + score);
        AudioPlayer.player.stop(audio);
        AudioPlayer.player.stop(in);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inGame();
        updateMoney();
        checkCollision();
        repaint();
        AudioPlayer.player.stop(audio);
    }

    private void inGame() {
        if (!ingame) {
            timer.stop();
            AudioPlayer.player.stop(audio);
        }
    }

    private void updateMoney() {
        for (int i = 0; i < munnies.size(); i++) {
            Munny m = munnies.get(i);
            if (!m.isVisible()) {
                munnies.remove(i);
            }
        }
    }

    public void checkCollision() {
        int x = CatData.getTileX();
        int y = CatData.getTileY();
        for (Munny munny : munnies) {
            int x1 = munny.getX();
            int y1 = munny.getY();
            if (x == x1 && y == y1) {
                try {
                    InputStream in;
                    in = new FileInputStream(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Mario-coin-sound.wav"));
                    AudioStream audio = new AudioStream(in);
                    AudioPlayer.player.start(audio);
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found");
                } catch (IOException ex) {
                    System.out.println("Problem with I/O");
                }
                munny.setVisible(false);
                score++;
            }
        }
        int x3 = CatData.getX();
        int y3 = CatData.getY();
        int x4 = House.getX();
        int y4 = House.getY();
        if (x3 == x4 && y3 == y4) {
            ingame = false;
        }
    }

    public class Movement extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int direction = e.getKeyCode();
            if (direction == KeyEvent.VK_UP) {
                if (!m.getMaze(CatData.getX(), CatData.getY() - 1).equals("X")) {
                    CatData.moveUp();
                }
            }
            if (direction == KeyEvent.VK_DOWN) {
                if (!m.getMaze(CatData.getX(), CatData.getY() + 1).equals("X")) {
                    CatData.moveDown();
                }
            }
            if (direction == KeyEvent.VK_RIGHT) {
                if (!m.getMaze(CatData.getX() + 1, CatData.getY()).equals("X")) {
                    CatData.moveRight();
                }
            }
            if (direction == KeyEvent.VK_LEFT) {
                if (!m.getMaze(CatData.getX() - 1, CatData.getY()).equals("X")) {
                    CatData.moveLeft();
                }
            }
        }
    }
}
