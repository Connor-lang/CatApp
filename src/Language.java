
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Language {

    private HashMap<String, String> map = new HashMap<String, String>();
    

    public Language(int level) {
        
        if (level >= 14) {
            map.put("bored", "Come play with me! miaowmiaow~~");
            map.put("boring", "Come play with me! miaowmiaow~~");
            
        }
        if (level >= 8) {
            map.put("happy", "Happy is a good thing! Meow~~");
            map.put("sing", "I don't know what to sing >_< So can I sing a birthday song for you( '-'*)Happy birthday to you~Happy birthday to you :) Happy birthday to you ~~Happy birthday to you ! Meow~");
            map.put("dance", "I can't dance. You can let me sing!");
            map.put("good night", "Good night~Meow~");
            map.put("tired", "So take a break!");
            map.put("good afternoon", "Good afternoon~Meow~");
            map.put("rain", "I like rainy days~Meow~");

        }

        if (level >= 3) {
            map.put("how are you", "Pretty good!");
            map.put("how are you", "Great!");
            map.put("what are you doing", "Pretty good!");
            map.put("really?", "I'm not kidding!");
            map.put("what are you doing", "Pretty good!");
            map.put("stupid", "Sorry~ I'll continue to improve!");
            map.put("foolish", "Sorry~ I'll continue to improve!");
            map.put("silly", "Sorry~ I'll continue to improve!");
        }

        if (level >= 1) {
            map.put("good", "Nice~mrooww~~");
            map.put("love you", "I love you too");
            map.put("like you", "Thanks for your like");
        }

        if (level >= 0) {
            map.put("hello", "Hi~ I'm your pet! Meow~~");
            map.put("hi", "Hi~ I'm your pet! Meow~~");
            map.put("who are you", "I am your lovely pet");
            map.put("bye", "Bye~~Have a nice day!!");
        }
    }

    public String getanswer(String b) {
        Set<String> setKey = map.keySet();
        Iterator<String> iterator = setKey.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (b.contains(key)) {
                b = key;
            }
        }
        if (map.containsKey(b)) {
            return map.get(b);
        } else {
            return "Sorry, I don't know how to answer this question.";
        }
    }

    public int getanswertwo(int j, int k) {
        int sum = 0;

        return sum;
    }
}
