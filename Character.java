/* import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random; */

public abstract class Character /* implements Talkable */ {

    public int maxhp;
    public int currenthp;
    public int atk;
    public int def;
    public int spd;
    public int exp;
    public int gold;
    public String name;
    
    public Character ( ) {
        this ( 30 , 5 , 2 , 1 , 0 , 0 , "Test" );
    }

    public Character ( String n ) {
        this ( 30 , 5 , 2 , 1 , 0 , 0 , n );
    }

    public Character ( int a , int b , int c , int d , int e , int f , String n ) {
        maxhp = a;
        currenthp = a;
        atk = b;
        def = c;
        spd = d;
        exp = e;
        gold = f;
        name = n;
    }

    public boolean attack ( Character other ) {// attack function
	    if ( (int)(Math.random() * 100) < 85 ) { // checks if the attack hit
	        // damage ( other );                 // damages opponent then checks
            System.out.println( this.name + " attacks " + other.name + " for " + damage ( other ) + " damage" );
	        other.aliveCheck ( );               // if they are killed
	        return true;                       // returns true for successful hit
	    }
	    else {
            System.out.println( this.name + " misses!" );
	        return false;                      // returns false for a miss
	    }
    }

    public int damage ( Character other ) { // helper function that changes hp
	    int damage = atk - def;                 // calculates total damage
	    if ( damage < 0 ) {                     // makes sure weak attacks 
	        damage = 0;                         // heal the enemy instead
	    }
	    other.currenthp = other.currenthp - damage; // decreases other hp by damage
	    return damage;
    }

    public boolean aliveCheck ( ) { // checks if character is dead
	    return currenthp > 0;
    }
    
    public static void battleUpdate ( Character player , Character other ) {
        System.out.println ( "Player HP: " + player.currenthp + " / " + player.maxhp );
        System.out.println ( "Enemy HP: " + other.currenthp + " / " + other.maxhp );
        System.out.println ( "~~~~~~~~~~~~" ); 
    }

    /*
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

    } */
    
}
