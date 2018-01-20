public class Enemy extends Character { 

	public Enemy ( ) {
		this ( "Enemy" );
	}

	public Enemy ( String n ) {
		super ( n );
	}

	public Enemy ( int hp , int atk , int def , int spd , int exp , int gold , String name ) {
        super ( hp , atk , def , spd , exp , gold , name );
        level = 1;
    }

}