public class Player extends Character {

    public Player ( ) {
    	this ( "Player" );
    }

    public Player ( String n ) {
    	super ( n );
    	level = 1;
    }

    public Player ( int hp , int atk , int def , int spd , int exp , int gold , String name ) {
        super ( hp , atk , def , spd , exp , gold , name );
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

}
