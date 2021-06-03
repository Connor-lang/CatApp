/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class GameData {

    private static int amount = 25, earn_Amount = 0, color, stripe, eyeColor;
    private static int hunger = 100, happiness = 10, level = 1, required_Happiness = 0, cumulative_Happiness = 0, feedCount = 0, age = 0;
    private static long startTime, endTime;
    private static String username, password ;
    private static boolean isLoaded = true;

    public GameData() {
    }

    public static int getRequiredHappiness(int level) {
        int maxLevel = 25;
        int maxLevelhappiness = 1000;
        float x = level / (float) maxLevel;
        double y = Math.pow(x, 2.61);
        required_Happiness = (int) (y * maxLevelhappiness);
        return required_Happiness;
    }

    public int getAmount() {
        return amount;
    }

    public static void setAmount(int amount) {
        GameData.amount = amount;
    }
    
    public int getAge() {
        return age;
    }

    public static void setAge(int age) {
        GameData.age = age;
    }
    
    public boolean getIsLoaded() {
        return isLoaded;
    }
    
    public static void setIsLoaded(boolean isLoaded) {
        GameData.isLoaded = isLoaded;
    }

    public int getHunger() {
        return hunger;
    }

    public static void setHunger(int hunger) {
        GameData.hunger = hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public static void setHappiness(int happiness) {
        GameData.happiness = happiness;
    }
 
    public int getCumulativeHappiness() {
        return cumulative_Happiness;
    }

    public static void setCumulativeHappiness(int cumulative_Happiness) {
        GameData.cumulative_Happiness = cumulative_Happiness;
    }
 
    public int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        GameData.level = level;
    }
    
    public long getStartTime() {
        return startTime;
    }
    
    public static void setStartTime(long startTime) {
        GameData.startTime = startTime;
    }
    
    public long getEndTime() {
        return endTime;
    }
    
    public static void setEndTime(long endTime) {
        GameData.endTime = endTime;
    }
    
    public int getFeedCount() {
        return feedCount;
    }
    
    public static void setFeedCount(int feedCount) {
        GameData.feedCount = feedCount;
    }
    
    public String getUsername() {
        return username;
    }
    
    public static void setUsername(String username) {
        GameData.username = username;
    }
     
    public String getPassword() {
        return password;
    }
    
    public static void setPassword(String password) {
        GameData.password = password;
    }
     
    public int getEarnAmount() {
       return earn_Amount;
    }
    
    public static void setEarnAmount(int earn_Amount) {
       GameData.earn_Amount = earn_Amount;
    }
    
    public int getColor() {
       return color;
    }
    
    public static void setColor(int color) {
       GameData.color = color;
    }
    
    public int getEyeColor() {
       return eyeColor;
    }
    
    public static void setEyeColor (int eyeColor) {
       GameData.eyeColor = eyeColor;
    }
    
    public int getStripe() {
       return stripe;
    }
    
    public static void setStripe (int stripe) {
       GameData.stripe = stripe;
    }
}
