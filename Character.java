/* import java.io.File;
import java.io.FileNotFoundException;*/
import java.util.*;
/*import java.util.List;
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
    public Setting setting;
    
    public Character ( ) {
        this ( 30 , 5 , 2 , 1 , 0 , 0 , "Test" );
    }

    public Character ( String n ) {
        this ( 30 , 5 , 2 , 1 , 0 , 0 , n );
    }

    public Character ( int hp , int atk , int def , int spd , int exp , int gold , String name ) {
        maxhp = hp;
        currenthp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        this.exp = exp;
        this.gold = gold;
        this.name = name;
    }

    public boolean attack ( Character other , String attackType) {// attack function
	    if ( (int)(Math.random() * 100) < 85 ) { // checks if the attack hit
	        // damage ( other );                 // damages opponent then checks
            System.out.println( this.name + " " + attackType + "s " + other.name + " for " + damage ( other , attackType ) + " damage" );
	        return true;                         // returns true for successful hit
	    }
	    else {
            System.out.println( this.name + " misses!" );
	        return false;                      // returns false for a miss
	    }
    }

    public int damage ( Character other , String attackType ) { // helper function that changes hp
	    int damage = atk - def;                 // calculates total damage
        if ( attackType == "kick") {
            damage += (int)(Math.random() * 3) + 1;
        }
	    if ( damage < 0 ) {                     // makes sure weak attacks don't
	        damage = 0;                         // heal the enemy instead
	    }
	    other.currenthp = other.currenthp - damage; // decreases other hp by damage
	    return damage;
    }

    public int damage ( int d ) {
	   currenthp -= d;
	   return d;
    }

    public static void battle ( Character Player, Character other ) {
        String[] actions = { "jab" , "kick" }; // more choices will be added
        Scanner input = new Scanner(System.in);
        Game.battleUpdate(Player, other);
        boolean cooldown = false;
        while ( Player.aliveCheck( ) && other.aliveCheck( ) ) {
            System.out.println( "0. Jab\n1. Kick");
            if (cooldown) {
                System.out.print( "**ON COOLDOWN**" );
            }
            System.out.print( "Enter a number: ");
            int n;
            while ( true ) {
                try {
                    n = input.nextInt();
                    break;
                }
                catch ( InputMismatchException e ) {
                    System.out.println( "Enter a valid number: " );
                    input.nextLine(); // consumes the bad input so the user can make another one that is hopefully correct
                }
            }
            System.out.println( "" );
            if ( Player.spd >= other.spd && !cooldown) {
                Player.attack( other , actions[n] );
                if (other.aliveCheck()) {
                    other.attack( Player , "hit");
                }
            }
            else if ( cooldown ) {
                other.attack( Player , "hit");
                cooldown = false;
            }
            else {
                other.attack( Player , "hit");
                if (Player.aliveCheck()) {
                    Player.attack( other , actions[n] );
                }
            }
            if ( n == 1 ) {
                cooldown = true;
            }
            Game.battleUpdate( Player, other);
        }
        Player.die( );
    }

    public boolean aliveCheck ( ) { // checks if character is dead
	    return currenthp > 0;
    }

    public void die ( ) {
        if ( currenthp <= 0 ) {
            System.out.println( "You slowly lose consciousness as your vision fades to black.");
            System.exit(0);
        }
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
