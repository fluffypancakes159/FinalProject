import java.util.*;

public class Game {

	// Setting currentLocation;

	/*
	public void setCurrentLocation ( Setting l ) {
		currentLocation = l;
	}
	*/

	public static void main(String[] args) {
		Weapon pen = new Weapon ( 5 , "Pen" , 2);
		Weapon compass = new Weapon ( 10 , "Compass" , 4);
		Restorative water = new Restorative ( 5 , "Water Bottle" , 4);
		Restorative xanax = new Restorative ( 15 , "xanaX" , 7);
		Scanner input = new Scanner (System.in);
		int n;
		if (args.length == 0) {
			System.out.println( "You need to add a parameter after \"java Game\" ");
			System.out.println( "Check the README for information.");
		}
		else {
			if ( args[0].equals("game")) {

			}
			else if ( args[0].equals("battle")) {
				int [][]stats = new int [2][6];
				String [] names = { "Player" , "Enemy"};
				String[] statNames = { "HP" , "ATK" , "DEF" , "SPD" , "EXP" , "Money" };
				for ( int i = 0 ; i < 2 ; i++ ) {
					System.out.println( names[i] + "'s Stats:" );
					for ( int j = 0 ; j < 6 ; j++ ) {
						System.out.println( statNames[j] + ": " );
						while ( true ) {
             			    try {
                    			n = input.nextInt();
                    			stats[i][j] = n;
                				break;
                			}
                			catch ( InputMismatchException e ) {
                    			System.out.println( "Enter a valid number: " );
                    			input.nextLine(); // consumes the bad input so the user can make another one that is hopefully correct
                			}
            			}
					}
				}
				Player A = new Player ( stats[0][0], stats[0][1], stats[0][2], stats[0][3], stats[0][4], stats[0][5] , names[0] );
				Enemy B = new Enemy ( stats[1][0], stats[1][1], stats[1][2], stats[1][3], stats[1][4], stats[1][5], names[1] );
				Character.battle( A , B );
				System.out.println( "Congrats you won!" ); // if character dies, then the System exits
			}

			else if ( args[0].equals("codebattle")) {

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
