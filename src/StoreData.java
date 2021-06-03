
import java.awt.Image;
import java.sql.*;

public class StoreData {

    public static final String CONNECTION_STRING = "jdbc:sqlite:C:/Users/HP/Desktop/tester.db";
    public static final String SEARCH_USERNAME = " ";
    public static boolean hasRecord = false;
    public static final String query = "INSERT INTO mydb (" + "username," + "password," + "happiness," + "level," + "hunger," + "coins," + "color,"
            + "stripe," + "eyeColor) VALUES (" + "?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private PreparedStatement preparedStmt;
    private static Connection myConn = null;
    private GameData GameData = new GameData();
    
    public static Connection getConn() throws Exception {
        if (myConn == null) {
            Class.forName("org.sqlite.JDBC");
            myConn = DriverManager.getConnection(CONNECTION_STRING);
            myConn.close();
        }
        return myConn;
    }
    
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

    public void storedatatodb() {
        
        try {
            
            String a = "a";
            String b = "b";
            String url = "jdbc:sqlite:C:/Users/HP/Desktop/tester.db";
            myConn = DriverManager.getConnection(url);
            Statement st = myConn.createStatement();
            st.executeUpdate("INSERT INTO mydb values('" + GameData.getUsername() + "','" + GameData.getPassword() + "',"
                    + GameData.getHappiness() + "," + GameData.getLevel() + "," + GameData.getHunger() + "," + GameData.getAmount() + "," + GameData.getColor()
                    + "," + GameData.getStripe() + "," + GameData.getEyeColor() + ")");
            myConn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        
    }
    public void update()  {
        try {
            String a = "a";
            String b = "b";
            String url = "jdbc:sqlite:C:/Users/HP/Desktop/tester.db";
            myConn = DriverManager.getConnection(url);
            Statement st = myConn.createStatement();
            st.executeUpdate("UPDATE mydb SET password = '" + GameData.getPassword() + "', happiness = " 
                    + GameData.getHappiness() + ", level = " + GameData.getLevel() + ", hunger = " + GameData.getHunger() + ",coins = " + GameData.getAmount() + ",color = " 
                    + GameData.getColor() + ",stripe = " + GameData.getStripe() + ",eyeColor = " + GameData.getEyeColor()
                    + " WHERE username = '"+GameData.getUsername()+"'");
 
    
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void getdatafromdb(String username, String password) {

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
}
