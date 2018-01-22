import java.util.*;

public class Game {

	// Setting currentLocation;

	/*
	public void setCurrentLocation ( Setting l ) {
		currentLocation = l;
	}
	*/

	public static void main(String[] args) {
		if (isEmpty(args)) {
			System.out.println( "You need to add a parameter after \"java Game\" ");
			System.out.println( "Check the README for information.");
		}
		else {
			if ( args[0].equals("game")) {

			}
			else if ( arg[0].equals("battle")) {

			}
			else if ( arg[0].equals("codebattle")) {

			}
			else {
				System.out.println( "Not a valid input. Check the README for information.");
			}
		}
	}

	public static void battleUpdate ( Character player , Character other ) {
		System.out.println ( "~~~~~~~~~~~~" ); 
        System.out.println ( "Player HP: " + player.currenthp + " / " + player.maxhp );
        System.out.println ( "Enemy HP: " + other.currenthp + " / " + other.maxhp );
        System.out.println ( "~~~~~~~~~~~~" ); 
    }

    public static void delayedPrint ( String output ) { //give user some time to read text
    	try {
			System.out.println(output);
   			Thread.sleep(1000); 
		} 
		catch (InterruptedException e) {
    		e.printStackTrace();
		}
    }

    public static void delayedPrintShort ( String output ) { //give user less but still some time to read text
    	try {
			System.out.println(output);
   			Thread.sleep(500); 
		} 
		catch (InterruptedException e) {
    		e.printStackTrace();
		}
    }

}
