import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public abstract class Character implements Talkable {

    public int maxhp;
    public int currenthp;
    public int atk;
    public int def;
    public int spd;
    public int exp;
    public int gold;
    public int name;
    
    public abstract boolean attack ( Player other );

    public String speak(String context) {
        try {
            //read the file into a list of Strings
            Scanner sc = new Scanner(new File(context + ".txt"));
            List<String> lines = new ArrayList<String>();

            //adding each newline to an ArrayList
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
            //return a random element of the array
            Random randgen = new Random();
            return lines.get(randgen.nextInt(lines.size()-1));

            //reminder the python is better than java:
            //in python this code is:

            //from random import choice
            //speak = lambda context: choice([i for i in open(context+'.txt', 'r')])
        } catch (FileNotFoundException f){
            return "";
        }

    }
    
}
