public class Enemy extends Character { 

	public String atkmsg;

	public Enemy ( ) {
		this ( "Enemy" );
	}

	public Enemy ( String n ) {
		super ( n );
	}

	public Enemy ( int hp , int atk , int def , int spd , int exp , int gold , String name , String atkmsg ) {
        super ( hp , atk , def , spd , exp , gold , name );
        this.atkmsg = atkmsg;
        level = 1;
    }

}