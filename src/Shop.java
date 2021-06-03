
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;
import java.util.ArrayList;
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
public class Shop extends JFrame {

    public static GameData GameData = new GameData();
    public Munny munny = new Munny();
    public static ArrayList<String> boughtFoodItems = new ArrayList<String>();
    JFrame f, f1;
    private StoreData a = new StoreData();

    public Shop() {
        super("Shop ");
        this.initFrame();
        this.pack();
        this.setLocation(400, 400);
        this.setSize(1100, 150);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initFrame() {
        Container contentPane = this.getContentPane();
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout());
        JButton backButton = new JButton("Back");
        JLabel munnyLabel = new JLabel("Munny");
        JTextField munnyField = new JTextField(15);
        JLabel boughtItemLabel = new JLabel("You bought: ");
        JTextField boughtItemField = new JTextField(26);
        boughtItemField.setEditable(false);
        munnyField.setEditable(false);
        munnyField.setText(Integer.toString(GameData.getAmount() + GameData.getEarnAmount()));
        GameData.setEarnAmount(0);
        menuPanel.add(backButton);
        menuPanel.add(munnyLabel);
        menuPanel.add(munnyField);
        menuPanel.add(boughtItemLabel); 
        menuPanel.add(boughtItemField);

        Box shopPanel = Box.createVerticalBox();

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new GridLayout(0, 5));
        JButton fishCanButton = new JButton("Fish can   10");
        JButton saladButton = new JButton("Tuna fish salad   20");
        JButton sandwichButton = new JButton("Salmon fish sandwich   30");
        JButton steakButton = new JButton("Bladefin basslet steak   40");
        JButton cuisineButton = new JButton("Platinum arowana cuisine   50");
        selectionPanel.add(fishCanButton);
        selectionPanel.add(saladButton);
        selectionPanel.add(sandwichButton);
        selectionPanel.add(steakButton);
        selectionPanel.add(cuisineButton);

        shopPanel.add(menuPanel);
        shopPanel.add(selectionPanel);

        contentPane.add(shopPanel);

        fishCanButton.addActionListener((ActionEvent e) -> {
            int a = JOptionPane.showConfirmDialog(f, "Are you sure you want to buy fish can?");
            if (a == JOptionPane.YES_OPTION) {
                if (GameData.getAmount() >= 10) {
                    InputStream in;
                    try {
                        in = new FileInputStream(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Cash register.wav"));
                        AudioStream audio = new AudioStream(in);
                        AudioPlayer.player.start(audio);
                    } catch (FileNotFoundException ex) {
                        System.out.println("File not found");
                    } catch (IOException ex) {
                        System.out.println("Problem with I/O");
                    }
                    GameData.setAmount(GameData.getAmount() - 10);
                    munnyField.setText(Integer.toString(GameData.getAmount()));
                    GameData.setAmount(GameData.getAmount());
                    boughtItemField.setText(boughtItemField.getText() + "Fish Can, ");
                    boughtFoodItems.add("Fish Can");
                } else {
                    JOptionPane.showMessageDialog(f1, "Munny not enough! Fish can costs 10 munnies.");
                }
            }
        });

        saladButton.addActionListener((ActionEvent e) -> {
            int a = JOptionPane.showConfirmDialog(f, "Are you sure you want to buy tuna fish salad?");
            if (a == JOptionPane.YES_OPTION) {
                if (GameData.getAmount() >= 20) {
                    InputStream in;
                    try {
                        in = new FileInputStream(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Cash register.wav"));
                        AudioStream audio = new AudioStream(in);
                        AudioPlayer.player.start(audio);
                    } catch (FileNotFoundException ex) {
                        System.out.println("File not found");
                    } catch (IOException ex) {
                        System.out.println("Problem with I/O");
                    }
                    GameData.setAmount(GameData.getAmount() - 20);
                    munnyField.setText(Integer.toString(GameData.getAmount()));
                    GameData.setAmount(GameData.getAmount());
                    boughtItemField.setText(boughtItemField.getText() + "Tuna Fish Salad, ");
                    boughtFoodItems.add("Tuna Fish Salad");
                } else {
                    JOptionPane.showMessageDialog(f1, "Munny not enough! Tuna fish salad costs 20 munnies.");
                }
            }
        });

        sandwichButton.addActionListener((ActionEvent e) -> {
            int a = JOptionPane.showConfirmDialog(f, "Are you sure you want to buy salmon fish sandwich?");
            if (a == JOptionPane.YES_OPTION) {
                if (GameData.getAmount() >= 30) {
                    InputStream in;
                    try {
                        in = new FileInputStream(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Cash register.wav"));
                        AudioStream audio = new AudioStream(in);
                        AudioPlayer.player.start(audio);
                    } catch (FileNotFoundException ex) {
                        System.out.println("File not found");
                    } catch (IOException ex) {
                        System.out.println("Problem with I/O");
                    }
                    GameData.setAmount(GameData.getAmount() - 30);
                    munnyField.setText(Integer.toString(GameData.getAmount()));
                    GameData.setAmount(GameData.getAmount());
                    boughtItemField.setText(boughtItemField.getText() + "Salmon Fish Sandwich, ");
                    boughtFoodItems.add("Salmon Fish Sandwich");
                } else {
                    JOptionPane.showMessageDialog(f1, "Munny not enough! Salmon fish sandwich costs 30 munnies.");
                }
            }
        });

        steakButton.addActionListener((ActionEvent e) -> {
            int a = JOptionPane.showConfirmDialog(f, "Are you sure you want to buy bladefin basslet steak?");
            if (a == JOptionPane.YES_OPTION) {
                if (GameData.getAmount() >= 40) {
                    InputStream in;
                    try {
                        in = new FileInputStream(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Cash register.wav"));
                        AudioStream audio = new AudioStream(in);
                        AudioPlayer.player.start(audio);
                    } catch (FileNotFoundException ex) {
                        System.out.println("File not found");
                    } catch (IOException ex) {
                        System.out.println("Problem with I/O");
                    }
                    GameData.setAmount(GameData.getAmount() - 40);
                    munnyField.setText(Integer.toString(GameData.getAmount()));
                    GameData.setAmount(GameData.getAmount());
                    boughtItemField.setText(boughtItemField.getText() + "Bladefin Basslet Steak, ");
                    boughtFoodItems.add("Bladefin Basslet Steak");
                } else {
                    JOptionPane.showMessageDialog(f1, "Munny not enough! Bladefin basslet steak costs 40 munnies.");
                }
            }
        });

        cuisineButton.addActionListener((ActionEvent e) -> {
            int a = JOptionPane.showConfirmDialog(f, "Are you sure you want to buy platinum arowana cuisine?");
            if (a == JOptionPane.YES_OPTION) {
                if (GameData.getAmount() >= 50) {
                    InputStream in;
                    try {
                        in = new FileInputStream(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\Cash register.wav"));
                        AudioStream audio = new AudioStream(in);
                        AudioPlayer.player.start(audio);
                    } catch (FileNotFoundException ex) {
                        System.out.println("File not found");
                    } catch (IOException ex) {
                        System.out.println("Problem with I/O");
                    }
                    GameData.setAmount(GameData.getAmount() - 50);
                    munnyField.setText(Integer.toString(GameData.getAmount()));
                    GameData.setAmount(GameData.getAmount());
                    boughtItemField.setText(boughtItemField.getText() + "Platinum Arowana Cuisine, ");
                    boughtFoodItems.add("Platinum Arowana Cuisine");
                } else {
                    JOptionPane.showMessageDialog(f1, "Munny not enough! Platinum arowana cuisine costs 50 munnies");
                }
            }
        });

        backButton.addActionListener((ActionEvent e) -> {
            dispose();
            GameData.setAmount(Integer.parseInt(munnyField.getText()));
            if (GameData.getIsLoaded())
                new LoginIdleScreen();
            else 
                new IdleScreen();
        });
        
    }   

    public static void main(String[] args) {
        Shop s = new Shop();
    }
    
    public ArrayList<String> getBoughtFoodItems() {
        return boughtFoodItems;
    }
}
