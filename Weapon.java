public class Weapon extends Item {

	public int atk;

	public Weapon ( ) { // default constructor is the default weapon
		this ( 0 , "fists" , 0);
	}

	public Weapon ( int cost , String name , int atk ) {
		super ( cost , name );
		this.atk = atk;
	}

	public String toString ( ) {
		return "" + quantity + "x " + name + " - $" + cost + " - increases ATK by " + atk;
	}

}
	
