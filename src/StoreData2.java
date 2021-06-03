/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.awt.Image;
import java.sql.*;

public class StoreData2 {

    public static final String CONNECTION_STRING = "jdbc:sqlite:C:/Users/HP/Desktop/tester.db";
    public static final String SEARCH_USERNAME = " ";
    public static boolean hasRecord = false;
    public static final String query = "INSERT INTO mydb (" + "username," + "password," + "happiness," + "level," + "hunger," + "coins," + "color,"
            + "stripe," + "eyeColor) VALUES (" + "?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private PreparedStatement preparedStmt;
    private Connection myConn;
    private GameData GameData = new GameData();

    public boolean open() {
        try {

            myConn = DriverManager.getConnection("jdbc:sqlite:C:/Users/HP/Desktop/tester.db");
            return true;

        } catch (Exception exc) {
            exc.printStackTrace();
            return false;
        }
    }

    public boolean getHasRecord() {
        return hasRecord;
    }

    public void storedatatodb(String username) {
        
        try {
            
            String url = "jdbc:sqlite:C:/Users/HP/Desktop/tester.db";
            Connection conn = DriverManager.getConnection(url, "","");
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO mydb " + "VALUES('a', 'b', 1, 1, 1, 1, 1, 1, 1)");
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public void getdatafromdb(String username, String password) {
        //gamesettings a = new gamesettings ();

        try {
            myConn = DriverManager.getConnection("jdbc:sqlite:C:/Users/HP/Desktop/tester.db");
            String query1 = "SELECT * FROM mydb WHERE username='" + username + "'";
            Statement myStmt = myConn.createStatement();
            ResultSet myrs = myStmt.executeQuery(query1);

            while (myrs.next()) {
                String testpass = myrs.getString("password");
                if (!testpass.equals(password)) {
                    System.out.println("You enter a wrong password !");
                    break;
                } else {
                    hasRecord = true;
                    GameData.setUsername(myrs.getString("username"));
                    GameData.setPassword(myrs.getString("password"));
                    GameData.setHappiness(myrs.getInt("happiness"));
                    GameData.setLevel(myrs.getInt("level"));
                    GameData.setHunger(myrs.getInt("hunger"));
                    GameData.setAmount(myrs.getInt("coins"));
                    GameData.setColor(myrs.getInt("color"));
                    GameData.setStripe(myrs.getInt("stripe"));
                    GameData.setEyeColor(myrs.getInt("eyeColor"));
                }

            }
        } catch (Exception exc) {

            exc.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            String url = "jdbc:sqlite:C:/Users/HP/Desktop/tester.db";
            Connection conn = DriverManager.getConnection(url, "","");
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO mydb " + "VALUES('a', 'b', 1, 1, 1, 1, 1, 1, 1)");
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

}

