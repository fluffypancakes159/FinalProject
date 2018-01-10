public class Player extends Character {

    public int level;

    public Player ( ) {
    	this ( "Player" );
    }

    public Player ( String n ) {
    	super ( n );
    	level = 0;
    }

}
