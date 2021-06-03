
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;
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
public class Login extends JFrame {

    StoreData a = new StoreData();
    JLabel nameLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JTextField name = new JTextField(20);
    JPasswordField password = new JPasswordField(20);
    JTextField comment = new JTextField(20);
    String correctPass = "admin";
    char[] cp = correctPass.toCharArray();

    public Login() {
        super("Login");
        this.initFrame();
    }

    private void initFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();

        JPanel buttonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        buttonPanel.add(loginButton);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JPanel loginPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        loginPanel.setLayout(new CardLayout());
        JPanel lesserLoginPanel = new JPanel();
        lesserLoginPanel.setLayout(new GridLayout(2, 0));
        lesserLoginPanel.add(nameLabel);
        lesserLoginPanel.add(name);
        lesserLoginPanel.add(passwordLabel);
        lesserLoginPanel.add(password);
        loginPanel.add(lesserLoginPanel);

        contentPane.add(loginPanel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputName = name.getText().trim();
                char[] p = password.getPassword();
                String PW = String.valueOf(p);
                System.out.println(inputName);
                System.out.println(PW);
                a.open();
                a.getdatafromdb(inputName, PW);
                if (a.getHasRecord()) {
                    GameData.setIsLoaded(true);
                    dispose();
                    System.out.println("connection success !");
                    new LoginIdleScreen();
                } else {
                    GameData.setIsLoaded(false);
                    InputStream in;
                    try {
                        in = new FileInputStream(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\wrong.wav"));
                        AudioStream audio = new AudioStream(in);
                        AudioPlayer.player.start(audio);
                    } catch (FileNotFoundException ex) {
                        System.out.println("File not found");
                    } catch (IOException ex) {
                        System.out.println("Problem with I/O");
                    }
                    int a = JOptionPane.showConfirmDialog(null, "No username / password found. Would you like to create a new account?");
                    if (a == JOptionPane.YES_OPTION) {
                        GameData.setUsername(inputName);
                        GameData.setPassword(PW);
                        
                        dispose();
                        new CharacterCreationScreen();
                    }
                }
            }
        }
        );
        password.addKeyListener(
                new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e
            ) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String inputName = name.getText().trim();
                    char[] p = password.getPassword();
                    String PW = String.valueOf(p);
                    
                    a.open();
                    a.getdatafromdb(inputName, PW);
                    if (a.getHasRecord()) {
                        dispose();
                        System.out.println("connection success !");
                        new LoginIdleScreen();
                    } else {
                        InputStream in;
                        try {
                            in = new FileInputStream(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\fop\\src\\wrong.wav"));
                            AudioStream audio = new AudioStream(in);
                            AudioPlayer.player.start(audio);
                        } catch (FileNotFoundException ex) {
                            System.out.println("File not found");
                        } catch (IOException ex) {
                            System.out.println("Problem with I/O");
                        }
                        int a = JOptionPane.showConfirmDialog(null, "No username / password found. Would you like to create a new account?");
                        if (a == JOptionPane.YES_OPTION) {
                            GameData.setUsername(inputName);
                            GameData.setPassword(PW);
                        
                            dispose();
                            new CharacterCreationScreen();
                        }
                    }
                }
            }
        }
        );

    }

    public static void main(String[] args) {
        Login frame = new Login();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
