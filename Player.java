public class Player extends Character {

    public int level;

    public Player ( ) {
    	this ( "Player" );
    }

    public Player ( String n ) {
    	super ( n );
    	level = 0;
    }

    public Player ( int a , int b , int c , int d, int e, int f, String n) {
        super ( a, b, c, d, e, f, n);
    }

    public boolean levelUp ( ) {
	level++;
	exp = 0;
	return true;
    }

}
