public class Enemy extends Character { 

	public Enemy ( ) {
		this ( "Enemy" );
	}

	public Enemy ( String n ) {
		super ( n );
	}

	public Enemy ( int a , int b , int c , int d, int e, int f, String n) {
        super ( a, b, c, d, e, f, n);
    }

}