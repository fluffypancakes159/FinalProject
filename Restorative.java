public class Restorative extends Item {

	public int healamt;

	public Restorative ( int cost , String name , int healamt ) {
		super ( cost , name );
		this.healamt = healamt;
	}

	public String toString ( ) {
    	return "" + quantity + "x " + name + " - heals " + healamt + " HP";
    }

}