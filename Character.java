import java.util.*;

public abstract class Character {

    public int maxhp;
    public int currenthp;
    public int level;
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

    public boolean attack ( Character other , String attackType) { // action function
        if ( attackType.equals( "item") && useItem( (Player)this) ) {
            return true;
        }
        else if ( attackType.equals( "item")) {
            return false; // returns false to go back 
        }
        else {
	        if ( (int)(Math.random() * 100) < 85 ) { // checks if the attack hit
	                                                 // damages opponent then checks
                Game.delayedPrintShort( this.name + " " + attackType + "s " + other.name + " for " + damage ( other , attackType ) + " damage" );
	            return true;                         // returns true for successful hit
	        }
	        else {
                Game.delayedPrintShort( this.name + " misses!" );
	            return true;                      // returns true for a miss
	        }
        }   
    }

    public int damage ( Character other , String attackType ) { // helper function that changes hp
	    int damage = atk - other.def;                 // calculates total damage
        if ( attackType.equals("kick")) {
            damage += (int)(Math.random() * 3) + 1;
        }
	    if ( damage < 1 ) {                     // makes sure weak attacks don't
	        damage = 1;                         // heal the enemy instead and also still deal damage
	    }
	    other.currenthp = other.currenthp - damage; // decreases other hp by damage
	    return damage;
    }

    public int damage ( int d ) {
	    currenthp -= d;
	    return d;
    }

    public static boolean useItem ( Player user ) {
        ArrayList<Restorative> list = new ArrayList<Restorative>();
        for ( Item item : user.inventory ) {
            if ( item instanceof Restorative ) {
                list.add((Restorative)item); // already established that the item in question is a restorative
            }
        }
        int i = 0;
        System.out.println( "-----------------ITEMS-----------------");
        for ( Restorative r : list) {
            System.out.println( "" + i + ". " + r );
            i++;
        }
        System.out.println( "---------------------------------------\n");
        Scanner itemChoice = new Scanner (System.in);
        String n = "";
        int n_;
        System.out.println( "Which item would you like to use? (Enter -1 to leave)" );
        while ( true ) {
            try {
                n = itemChoice.next();
                n_ = Integer.parseInt(n);
                Restorative selected = list.get(n_);
                user.heal( selected.healamt );
                System.out.println( "Healed " + selected.healamt + " HP!" );
                selected.quantity--;
                if ( selected.quantity <= 0 ) {
                    user.inventory.remove( selected );
                }
                return true;
            }   
            catch ( InputMismatchException e ) {
                System.out.println( "Enter a valid number: " );
                itemChoice.nextLine(); // consumes the bad input so the user can make another one that is hopefully correct
            }
            catch ( ArrayIndexOutOfBoundsException e ) {
                if ( Integer.parseInt(n) == -1 ) {
                    return false;
                }
                else {
                    System.out.println( "Enter a valid number: " );
                    itemChoice.nextLine(); // consumes the bad input so the user can make another one that is hopefully correct
                }
            }
        }

    }

    public static void battle ( Player player, Enemy other ) {
        String[] actions = { "poke" , "kick" , "item"}; // more choices will be added
        Scanner input = new Scanner(System.in);
        Game.battleUpdate(player, other);
        boolean cooldown = false;
        boolean cooldowncooldown = false;
        while ( player.aliveCheck( ) && other.aliveCheck( ) ) {
            System.out.println( "0. Poke\n1. Kick\n2. Item");
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
            if ( n == 2 && !useItem( player ) ) { // if the player doesn't choose an item, don't do anything

            }
            else {
                if ( player.spd >= other.spd && !cooldown) {
                    player.attack( other , actions[n] );
                    if (other.aliveCheck()) {
                        other.attack( player , other.atkmsg);
                    }
                    cooldowncooldown = false;
                }
                else if ( cooldown ) {
                    other.attack( player , other.atkmsg);
                    cooldown = false;
                    cooldowncooldown = true;
                }
                else {
                    other.attack( player , other.atkmsg);
                    if (player.aliveCheck()) {
                        player.attack( other , actions[n] );
                    }
                }
                if ( n == 1 && !cooldowncooldown) {
                    cooldown = true;
                }
            }
            Game.battleUpdate( player, other);
        }
        player.die( other );
    }

    public boolean aliveCheck ( ) { // checks if character is dead
	    return currenthp > 0;
    }

    public int heal ( int healamt ) {
        currenthp += healamt;
        if ( currenthp > maxhp ) {
            currenthp = maxhp;
        }
        return healamt;
    }

    public abstract String toString ( );

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
