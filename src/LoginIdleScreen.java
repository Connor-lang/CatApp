
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
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
public class LoginIdleScreen extends JFrame {

    private static GridBagConstraints gbc = new GridBagConstraints();
    private GameData GameData = new GameData();
    private Munny munny = new Munny();
    Timer timer, timer1, timer2;
    private Shop s = new Shop();
    private Language language = new Language(GameData.getLevel());
    private Graphics g;
    private StoreData store = new StoreData();

    public LoginIdleScreen() {
        super("Idle Screen");
        this.setPreferredSize(new Dimension(660, 600));
        this.initFrame();
        this.pack();
        this.setLocation(600, 250);
        this.setSize(660, 700);
        this.setVisible(true);
        s.setVisible(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int b = JOptionPane.showConfirmDialog(null, "Are you sure?");
                if (b == JOptionPane.YES_OPTION) {
                    store.update();
                }
            }
        });
    }

    private void initFrame() {
        Container contentPane = this.getContentPane();

        JPanel catPanel = new JPanel();
        catPanel.add(new LoginCatScreen());

        JPanel chattingArea = new JPanel();
        chattingArea.setLayout(new GridLayout(2, 0));
        JPanel interactArea = new JPanel();
        interactArea.setLayout(new GridLayout(0, 2));
        JTextField defaultTextField = new JTextField();
        defaultTextField.setEditable(false);
        defaultTextField.setPreferredSize(new Dimension(660, 30));
        defaultTextField.setText("Meow ~ I am your pet cat ~ Chat with me by sending \"keywords\"~  Unlock more of my language content by leveling up");

        JLabel userLabel = new JLabel("User: ");
        JTextField userTextField = new JTextField();
        userTextField.setPreferredSize(new Dimension(660, 25));
        JLabel answerLabel = new JLabel("Pet: ");
        JTextField answerTextField = new JTextField();
        answerTextField.setEditable(false);

        chattingArea.add(defaultTextField);
        interactArea.add(userLabel);
        interactArea.add(userTextField);
        interactArea.add(answerLabel);
        interactArea.add(answerTextField);
        chattingArea.add(interactArea);

        ButtonGroup actionButton = new ButtonGroup();
        JButton actionFeed = new JButton("Feed");
        JButton actionPlay = new JButton("Play");
        JButton actionShop = new JButton("Shop");
        JButton actionStats = new JButton("Stats");
        actionPlay.setSize(30, 20);
        actionFeed.setSize(30, 20);
        actionShop.setSize(30, 20);
        actionStats.setSize(30, 20);

        actionButton.add(actionPlay);
        actionButton.add(actionFeed);
        actionButton.add(actionShop);
        actionButton.add(actionStats);
        Border etchedLoweredBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border titledBorder = BorderFactory.createTitledBorder(etchedLoweredBorder, "Actions", TitledBorder.CENTER, TitledBorder.TOP);

        JLabel levelLabel = new JLabel("Level: ");
        JProgressBar levelBar = new JProgressBar(0, 25);
        levelBar.setValue(GameData.getLevel());
        levelBar.setPreferredSize(new Dimension(10, 20));
        levelBar.setForeground(Color.red);
        levelBar.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel munnyFieldLabel = new JLabel("Munny: ");
        JTextField munnyField = new JTextField(5);
        munnyField.setText(Integer.toString(GameData.getAmount()));
        munnyField.setPreferredSize(new Dimension(10, 20));
        munnyField.setEditable(false);

        JLabel foodLabel = new JLabel("Food: ");
        JTextArea emptyArea = new JTextArea();
        for (String items : s.getBoughtFoodItems()) {
            emptyArea.setText(emptyArea.getText() + items + "\n");
        }
        emptyArea.setPreferredSize(new Dimension(10, 230));
        emptyArea.setEditable(false);
        emptyArea.setLineWrap(true);
        emptyArea.setWrapStyleWord(true);

        JLabel ageBarLabel = new JLabel("Age:");
        JProgressBar ageBar = new JProgressBar(0, 3600000);
        ageBar.setValue(GameData.getAge());
        ageBar.setPreferredSize(new Dimension(10, 20));
        ageBar.setForeground(Color.RED);
        ageBar.setBorder(BorderFactory.createLineBorder(Color.RED));

        ActionListener updateAgeBar = (ActionEvent e) -> {
            int age = GameData.getAge();
            if (age >= 3600000) {
                timer.stop();
                dispose();
                new GameOver();
                return;
            }
            ageBar.setValue(++age);
            GameData.setAge(++age);
        };

        timer2 = new Timer(3600000, updateAgeBar);
        timer2.start();

        JLabel hungerBarLabel = new JLabel("Hunger:");
        JProgressBar hungerBar = new JProgressBar(0, 100);
        hungerBar.setValue(GameData.getHunger());
        hungerBar.setPreferredSize(new Dimension(10, 20));
        hungerBar.setForeground(Color.YELLOW);
        hungerBar.setBorder(BorderFactory.createLineBorder(Color.yellow));

        ActionListener updateHungerBar = (ActionEvent e) -> {
            int hunger = GameData.getHunger();
            if (hunger < 0) {
                timer.stop();
                dispose();
                new GameOver();
                return;
            }
            if (GameData.getHunger() == 60) {
                JOptionPane.showMessageDialog(null, "Wanna eat! Miao~~", "Message", JOptionPane.INFORMATION_MESSAGE);
            }

            if (GameData.getHunger() == 35) {
                JOptionPane.showMessageDialog(null, "Hungry! Miao~~", "Message", JOptionPane.INFORMATION_MESSAGE);
            }

            hungerBar.setValue(--hunger);
            GameData.setHunger(--hunger);
        };

        timer = new Timer(600000, updateHungerBar);
        timer.start();

        JLabel happinessBarLabel = new JLabel("Happiness:            ");
        JProgressBar happinessBar = new JProgressBar(0, GameData.getRequiredHappiness(GameData.getLevel()));
        happinessBar.setValue(GameData.getHappiness());
        happinessBar.setPreferredSize(new Dimension(10, 20));
        happinessBar.setForeground(Color.GREEN);
        happinessBar.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        ActionListener updateHappinessBar = (ActionEvent e) -> {
            int happiness = GameData.getHappiness();
            if (happiness < 0) {
                timer.stop();
                return;
            }
            hungerBar.setValue(--happiness);
            GameData.setHunger(--happiness);
        };

        timer1 = new Timer(600000, updateHappinessBar);
        timer1.start();

        Box VBox = Box.createVerticalBox();
        JPanel g1 = new JPanel();
        g1.setLayout(new GridLayout(4, 0));
        g1.add(actionFeed);
        g1.add(actionPlay);
        g1.add(actionShop);
        g1.add(actionStats);
        g1.setBorder(titledBorder);

        VBox.add(levelLabel);
        VBox.add(levelBar);
        VBox.add(hungerBarLabel);
        VBox.add(hungerBar);
        VBox.add(happinessBarLabel);
        VBox.add(happinessBar);
        VBox.add(munnyFieldLabel);
        VBox.add(munnyField);
        VBox.add(foodLabel);
        VBox.add(emptyArea);
        VBox.add(g1);

        actionFeed.addActionListener((ActionEvent e) -> {
            InputStream in;
            try {
                in = new FileInputStream(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Meow.wav"));
                AudioStream audio = new AudioStream(in);
                AudioPlayer.player.start(audio);
            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            } catch (IOException ex) {
                System.out.println("Problem with I/O");
            }
            JFrame f = new JFrame();
            f.setTitle("Feed Your Cat");
            f.setSize(200, 300);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.setResizable(false);
            /*
            if (GameData.getHunger() >= 95) {
                JOptionPane.showMessageDialog(null, "Your pet is full", "Message", JOptionPane.INFORMATION_MESSAGE);
                f.setSize(0, 0);
                f.setVisible(false);
            }
             */
            JPanel foodPanel = new JPanel();
            foodPanel.setLayout(new GridLayout(5, 0));
            JButton fishCanButton = new JButton("Fish can");
            JButton saladButton = new JButton("Tuna fish salad");
            JButton sandwichButton = new JButton("Salmon fish sandwich");
            JButton steakButton = new JButton("Bladefin basslet steak");
            JButton cuisineButton = new JButton("Platinum arowana cuisine");
            foodPanel.add(fishCanButton);
            foodPanel.add(saladButton);
            foodPanel.add(sandwichButton);
            foodPanel.add(steakButton);
            foodPanel.add(cuisineButton);
            f.add(foodPanel);

            fishCanButton.addActionListener((ActionEvent ae) -> {
                if (s.getBoughtFoodItems().contains("Fish Can")) {
                    GameData.setFeedCount(GameData.getFeedCount() + 1);
                    GameData.setEndTime(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
                    s.getBoughtFoodItems().remove("Fish Can");
                    GameData.setCumulativeHappiness(GameData.getCumulativeHappiness() + 5);
                    GameData.setHappiness(GameData.getHappiness() + 5);
                    if (GameData.getHappiness() >= GameData.getRequiredHappiness(GameData.getLevel())) {
                        JOptionPane.showMessageDialog(null, "Level Up! You have reached level " + GameData.getLevel(), "Message", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        GameData.setHunger(GameData.getHunger() + 100);
                        GameData.setHappiness(0);
                        GameData.setLevel(GameData.getLevel() + 1);
                    }
                    f.dispose();
                    this.dispose();
                    if (GameData.getIsLoaded()) {
                        new LoginIdleScreen();
                    } else {
                        new IdleScreen();
                    }
                } else {
                    int a = JOptionPane.showConfirmDialog(f, "You don't have fish can. Would you like to buy some?");
                    if (a == JOptionPane.YES_OPTION) {
                        f.dispose();
                        this.dispose();
                        new Shop();
                    }
                }
            });

            saladButton.addActionListener((ActionEvent ae) -> {
                if (s.getBoughtFoodItems().contains("Tuna Fish Salad")) {
                    GameData.setFeedCount(GameData.getFeedCount() + 1);
                    GameData.setEndTime(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
                    s.getBoughtFoodItems().remove("Tuna Fish Sandwich");
                    GameData.setCumulativeHappiness(GameData.getCumulativeHappiness() + 10);
                    GameData.setHappiness(GameData.getHappiness() + 10);
                    if (GameData.getHappiness() >= GameData.getRequiredHappiness(GameData.getLevel())) {
                        JOptionPane.showMessageDialog(null, "Level Up! You have reached level " + GameData.getLevel(), "Message", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        GameData.setHunger(GameData.getHunger() + 10);
                        GameData.setHappiness(0);
                        GameData.setLevel(GameData.getLevel() + 1);
                    }
                    f.dispose();
                    this.dispose();
                    if (GameData.getIsLoaded()) {
                        new LoginIdleScreen();
                    } else {
                        new IdleScreen();
                    }
                } else {
                    int a = JOptionPane.showConfirmDialog(f, "You don't have tuna fish salad. Would you like to buy some?");
                    if (a == JOptionPane.YES_OPTION) {
                        f.dispose();
                        this.dispose();
                        new Shop();
                    }
                }
            });

            sandwichButton.addActionListener((ActionEvent ae) -> {
                if (s.getBoughtFoodItems().contains("Salmon Fish Sandwich")) {
                    GameData.setFeedCount(GameData.getFeedCount() + 1);
                    GameData.setEndTime(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
                    GameData.setCumulativeHappiness(GameData.getCumulativeHappiness() + 15);
                    s.getBoughtFoodItems().remove("Salmon Fish Sandwich");
                    GameData.setHappiness(GameData.getHappiness() + 15);
                    if (GameData.getHappiness() >= GameData.getRequiredHappiness(GameData.getLevel())) {
                        JOptionPane.showMessageDialog(null, "Level Up! You have reached level " + GameData.getLevel(), "Message", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        GameData.setHunger(GameData.getHunger() + 15);
                        GameData.setHappiness(0);
                        GameData.setLevel(GameData.getLevel() + 1);
                    }
                    f.dispose();
                    this.dispose();
                    if (GameData.getIsLoaded()) {
                        new LoginIdleScreen();
                    } else {
                        new IdleScreen();
                    }
                } else {
                    int a = JOptionPane.showConfirmDialog(f, "You don't have salmon fish sandwich. Would you like to buy some?");
                    if (a == JOptionPane.YES_OPTION) {
                        f.dispose();
                        this.dispose();
                        new Shop();
                    }
                }
            });

            steakButton.addActionListener((ActionEvent ae) -> {
                if (s.getBoughtFoodItems().contains("Bladefin Basslet Steak")) {
                    GameData.setFeedCount(GameData.getFeedCount() + 1);
                    GameData.setEndTime(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
                    GameData.setCumulativeHappiness(GameData.getCumulativeHappiness() + 20);
                    s.getBoughtFoodItems().remove("Bladefin Basslet Steak");
                    GameData.setHappiness(GameData.getHappiness() + 20);
                    if (GameData.getHappiness() >= GameData.getRequiredHappiness(GameData.getLevel())) {
                        JOptionPane.showMessageDialog(null, "Level Up! You have reached level " + GameData.getLevel(), "Message", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        GameData.setHunger(GameData.getHunger() + 20);
                        GameData.setHappiness(0);
                        GameData.setLevel(GameData.getLevel() + 1);
                    }
                    f.dispose();
                    this.dispose();
                    if (GameData.getIsLoaded()) {
                        new LoginIdleScreen();
                    } else {
                        new IdleScreen();
                    }
                } else {
                    int a = JOptionPane.showConfirmDialog(f, "You don't have bladefin basslet steak. Would you like to buy some?");
                    if (a == JOptionPane.YES_OPTION) {
                        f.dispose();
                        this.dispose();
                        new Shop();
                    }
                }
            });

            cuisineButton.addActionListener((ActionEvent ae) -> {
                if (s.getBoughtFoodItems().contains("Platinum Arowana Cuisine")) {
                    GameData.setFeedCount(GameData.getFeedCount() + 1);
                    GameData.setEndTime(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
                    s.getBoughtFoodItems().remove("Platinum Arowana Cuisine");
                    GameData.setCumulativeHappiness(GameData.getCumulativeHappiness() + 25);
                    GameData.setHappiness(GameData.getHappiness() + 25);
                    if (GameData.getHappiness() >= GameData.getRequiredHappiness(GameData.getLevel())) {
                        JOptionPane.showMessageDialog(null, "Level Up! You have reached level " + GameData.getLevel(), "Message", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        GameData.setHunger(GameData.getHunger() + 25);
                        GameData.setHappiness(0);
                        GameData.setLevel(GameData.getLevel() + 1);
                    }
                    f.dispose();
                    this.dispose();
                    if (GameData.getIsLoaded()) {
                        new LoginIdleScreen();
                    } else {
                        new IdleScreen();
                    }
                } else {
                    int a = JOptionPane.showConfirmDialog(f, "You don't have platinum arowana cuisine. Would you like to buy some?");
                    if (a == JOptionPane.YES_OPTION) {
                        f.dispose();
                        this.dispose();
                        new Shop();
                    }
                }
            });

        });

        actionPlay.addActionListener((ActionEvent e) -> {
            InputStream in;
            try {
                in = new FileInputStream(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Meow.wav"));
                AudioStream audio = new AudioStream(in);
                AudioPlayer.player.start(audio);
            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            } catch (IOException ex) {
                System.out.println("Problem with I/O");
            }
            Maze m = new Maze();
        });

        actionShop.addActionListener((ActionEvent e) -> {
            InputStream in;
            try {
                in = new FileInputStream(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Meow.wav"));
                AudioStream audio = new AudioStream(in);
                AudioPlayer.player.start(audio);
            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            } catch (IOException ex) {
                System.out.println("Problem with I/O");
            }
            dispose();
            new Shop();
        });

        actionStats.addActionListener((ActionEvent e) -> {
            new ChartPanel();
        });

        userTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String h;
                    String c = userTextField.getText();
                    String b = c.toLowerCase();
                    if (b.equals("game")) {
                        new RockPaperScissors();
                    } else {
                        h = language.getanswer(b);
                        answerTextField.setText(h);
                    }
                }
            }
        }
        );

        if (GameData.getLevel()
                >= 14) {
            answerTextField.setText("You now can play a mini game when you type game");
        }

        contentPane.add(catPanel, BorderLayout.CENTER);

        contentPane.add(VBox, BorderLayout.EAST);

        contentPane.add(chattingArea, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new IdleScreen();
    }

}
