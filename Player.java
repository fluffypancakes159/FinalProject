import java.util.ArrayList;

public class Player extends Character {

    public ArrayList<Item> inventory;

    public Player ( ) {
    	this ( "Player" );
    }

    public Player ( String n ) {
    	super ( n );
    	level = 1;
        inventory = new ArrayList<Item>();
    }

    public Player ( int hp , int atk , int def , int spd , int exp , int gold , String name ) {
        super ( hp , atk , def , spd , exp , gold , name );
        inventory = new ArrayList<Item>();
    }

    public void die ( Enemy other ) {
        if ( currenthp <= 0 ) {
            System.out.println( "You slowly lose consciousness as your vision fades to black.");
            System.exit(0);
        }
        else {
            reward( other );
        }
    }

    public void reward ( Enemy other ) {
        gold += other.gold;
        Game.delayedPrint( "You received " + other.gold + " dollars!" );
        exp += other.exp;
        Game.delayedPrint( "You received " + other.exp + " EXP!" );
        levelUp( );

    }

    public boolean levelUp ( ) {
        boolean levelChange = false;
        while (exp >= level * 2 + 5) {
            exp -= level * 2 + 5;
	        level++;
            Game.delayedPrint( "You leveled up to " + level + "!");
            int m = (int)(Math.random() * 3 + 3);
            maxhp += m;
            Game.delayedPrintShort ( "HP increased by " + m + "!");
            m = (int)(Math.random() * 3 + 1);
            atk += m;
            Game.delayedPrintShort ( "ATK increased by " + m + "!");
            m = (int)(Math.random() * 3 + 1);
            def += m;
            Game.delayedPrintShort ( "DEF increased by " + m + "!");
            m = (int)(Math.random() * 3 + 1);
            spd += m;
            Game.delayedPrintShort ( "SPD increased by " + m + "!");
            heal ( maxhp );
            levelChange = true; // if there is a level up, the method returns true
        }
        return levelChange;
    }

    public void buy ( Item item ) {
        gold -= item.cost;
        if ( inventory.indexOf(item) < 0 ) {
            inventory.add(item);
            item.quantity = 1;
        }
        else {
            item.quantity++;
        }
    }

    public void printInventory ( ) {
        int i = 0;
        for (Item item : inventory) {
            i++;
            System.out.println( "" + i + ". " + item );
        }
        System.out.println( "----------------------------------------\n");
    }

}
