public class Player extends Character {

    public int level;

    public Player ( ) {
    	this ( "Player" );
    }

    public Player ( String n ) {
    	super ( n );
    	level = 0;
    }

    public Player ( int hp , int atk , int def , int spd , int exp , int gold , String name ) {
        super ( hp , atk , def , spd , exp , gold , name );
    }

    public boolean levelUp ( ) {
	level++;
	exp = 0;
	return true;
    }

}
