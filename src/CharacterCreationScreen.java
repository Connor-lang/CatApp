
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
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
public class CharacterCreationScreen extends JFrame {

    public static CatData Data = new CatData();
    public Cat Cat = new Cat();
    JLabel nameLabel = new JLabel("Name: ");
    JLabel levelLabel = new JLabel("Level: ");
    JLabel colorLabel = new JLabel("Color of Cat: ");
    JLabel stripeLabel = new JLabel("Stripe: ");
    JLabel eyeColorLabel = new JLabel("Eye Color: ");
    JLabel personalityLabel = new JLabel("Personality: ");
    JLabel birthDateLabel = new JLabel("Date of Birth: ");
    JTextField name = new JTextField(15);
    JTextField color = new JTextField(15);
    JTextField stripe = new JTextField(15);
    JTextField eyeColor = new JTextField(15);
    JTextField personality = new JTextField(15);
    JTextField birthDate = new JTextField(15);
    JButton btReset = new JButton("Reset");
    JButton btCreate = new JButton("Create");

    public CharacterCreationScreen() {
        super("Character Creation");
        this.initFrame();
        this.setLocation(700, 400);
        this.setSize(560, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initFrame() {
        Container contentPane = this.getContentPane();

        JPanel catPanel = new JPanel();
        catPanel.add(new CatScreen());

        JProgressBar levelBar = new JProgressBar(0, 15);
        levelBar.setValue(Cat.getLevel());

        JPanel statPanel = new JPanel();
        statPanel.setLayout(new GridLayout(0, 2));
        statPanel.add(nameLabel);
        statPanel.add(name);
        statPanel.add(levelLabel);
        statPanel.add(levelBar);
        statPanel.add(colorLabel);
        statPanel.add(color);
        statPanel.add(stripeLabel);
        statPanel.add(stripe);
        statPanel.add(eyeColorLabel);
        statPanel.add(eyeColor);
        statPanel.add(personalityLabel);
        statPanel.add(personality);
        statPanel.add(birthDateLabel);
        statPanel.add(birthDate);
        statPanel.add(btReset);
        statPanel.add(btCreate);
        color.setText(Cat.getColor());
        stripe.setText(Cat.getStripe());
        eyeColor.setText(Cat.getEyeColor());
        personality.setText(Cat.getPersonality());
        birthDate.setText(Cat.getBirthDate().toString());
        color.setEditable(false);
        stripe.setEditable(false);
        eyeColor.setEditable(false);
        personality.setEditable(false);
        birthDate.setEditable(false);

        Box hBox = Box.createHorizontalBox();
        hBox.add(catPanel);
        hBox.add(statPanel);

        contentPane.add(hBox);

        btReset.addActionListener((ActionEvent e) -> {
            Cat cat = new Cat();
            dispose();
            new CharacterCreationScreen();
        });

        btCreate.addActionListener((ActionEvent e) -> {
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
            Cat.setName(name.getText());
            Cat.setColor(color.getText());
            Cat.setStripe(stripe.getText());
            Cat.setEyeColor(eyeColor.getText());
            Cat.setPersonality(personality.getText());
            Cat.setBirthDate(Cat.getBirthDate());
            CatData.setCreatedCat(Cat.getCat());
            CatData.setCreatedFrontImage(Cat.getFrontImage());
            GameData.setStartTime(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
            GameData.setStripe(Cat.getstripe());
            GameData.setColor(Cat.getcolor());
            GameData.setEyeColor(Cat.geteyecolor());
            dispose();
            new IdleScreen();
        });
    }

    public void paintComponent(Graphics g) {
        g.drawImage(Data.getCreatedFrontImage(), 0, 0, this);
    }

    public static void main(String[] args) {
        new CharacterCreationScreen();
    }
}
