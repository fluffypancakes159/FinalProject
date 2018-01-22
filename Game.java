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
		String n_;
		int n; // initialization stuff
		if (args.length == 0) {
			System.out.println( "You need to add a parameter after \"java Game\" ");
			System.out.println( "Check the README for information.");
		}
		else {

			// GAME

			if ( args[0].equals("game")) {

				// Character Initialization

				System.out.println( "Before we start, I'm going to need a name: ");
				n_ = input.next( );
				Player A = new Player ( 20 , 4 , 2 , 1 , 0 , 20 , n_ );
				Game.delayedPrintLong( "That's a pretty good name, I'm assuming.");
				Game.delayedPrintLong( "Now, we can start the game...\n");

				// Story Initialization

				// Object[] a = { "print" , "What to do?" };
				Object[] a = { "" };
				ChoiceTree ct1 = new ChoiceTree ( "What to do?" , a );

				Object[] a2a = { "print" , "Classmate: I know what you mean. I got a 100 but I got the extra credit wrong. UGH!" 
										 , "You: I know right... I got that exactly for my physics test. She only gave me partial credit on the bonus!" 
										 , "Classmate: I hate teachers that do that."
										 , "You: For real, my son... It gets me mad tight!!!"};
				ChoiceTree ct2a = new ChoiceTree ( "Complain to your classmates about how you did so badly" , a2a );
				Object[] a2b = { "print" , "You look around for Mr. K, but he's nowhere to be found!" 
										 , "The end bell rings, signaling the end of AP Computer Science." };
				ChoiceTree ct2b = new ChoiceTree ( "Go talk to Mr. K about how he should curve your test up to a 99 <<MANDATORY>>" , a2b);

				ct1.assimilate( ct2a );
				ct1.assimilate( ct2b );
				ct2a.assimilate( ct2b );

				ChoiceTree ct3 = new ChoiceTree ( "Enter the bathroom" , a );

				Object[] a4a = { "print" , "You: Yeah I'll buy some xanaX."};
				ChoiceTree ct4a = new ChoiceTree ( "Accept his offer" , a4a );
				Object[] a4aa = { "Buy" , A , xanax};
				ChoiceTree ct4aa = new ChoiceTree ( "Buy the xanaX" , a4aa );

				Object[] a4b = { "print" , "Vaper: Looks like we're gonna have a problem then." , "The vaper towers over you threateningly."};
				ChoiceTree ct4b = new ChoiceTree ( "Refuse his offer and walk away" , a4b );
				Object[] a4ba = { "battle" , A , new Enemy ( 15 , 4 , 2 , 1 , 5 , 5 , "Vaper") };
				ChoiceTree ct4ba = new ChoiceTree ( "Engage Vaper" , a4ba );

				Object[] a4c = { "print" , "Vaper: Whoa whoa calm down there buddy I was just kidding." 
										 , "Vaper: Just have some, on the house okay?"
										 , "I guess he couldn't tell the difference." };
				ChoiceTree ct4c = new ChoiceTree ( "Threaten him with a finger gun" , a4c );
				Object[] a4ca = { "receive" , A , xanax };
				ChoiceTree ct4ca = new ChoiceTree ( "Take the xanaX" , a4ca);

				ct3.assimilate( ct4a );
				ct4a.assimilate( ct4aa );
				ct3.assimilate( ct4b );
				ct4b.assimilate( ct4ba );
				ct3.assimilate( ct4c );
				ct4c.assimilate( ct4ca );

				ChoiceTree ct5 = new ChoiceTree ( "Go back to math class" , a );

				Object[] a6a = { "print" , "You go to the water fountain." , "Refreshing!" };
				ChoiceTree ct6a = new ChoiceTree ( "Go get a drink of water" , a6a );
				Object[] a6aa = { "heal" , A , 5 };
				ChoiceTree ct6aa = new ChoiceTree ( "Drink the water." , a6aa );

				Object[] a6b = { "print" , "You decide you need to urinate some more and you return to the bathroom."
										  , "Of course, the vapers are still there." };
				ChoiceTree ct6b = new ChoiceTree ( "Go back to the bathroom" , a6b );

				Object[] a6c = { "print" , "You decide to enter the lion's den: Precalculus" };
				ChoiceTree ct6c = new ChoiceTree ( "Enter your math class" , a6c );

				ct5.assimilate( ct6a );
				ct6a.assimilate( ct6aa );
				ct6aa.assimilate( ct5 );
				ct5.assimilate( ct6b );
				ct6b.assimilate( ct3 );
				ct5.assimilate( ct6c );

				// Actual Game

				Game.delayedPrint( "Your first period APCS class with Mr. K...");
				Game.delayedPrint( "You are snapped out of your daydream by Mr. K saying, \"Alright I'm handing the tests back now!\"");
				Game.delayedPrint( "You anxiously wait for him to pass your test back.");
				Game.delayedPrint( "When he does, you eagerly turn it over to see the score.");
				Game.delayedPrint( "98%");

				ct1.recursiveGo( );

				Game.delayedPrint( "You think to yourself, I really need that 99.");
				Game.delayedPrintLong( "You silently blame the school system for all of your failures such as this most recent one as you head to math class.");
				Game.delayedPrint( "Suddenly, you feel the strong urge to urinate.");
				Game.delayedPrint( "You enter the bathroom and see some sketchy-looking people in a circle vaping.");
				Game.delayedPrint( "The main person walks up to you. He looks a little on edge.");
				Game.delayedPrint( "Vaper: Hey kid, you want some xanaX? I'll hook you up for $15");

				ct3.recursiveGo( );

				Game.delayedPrint( "You leave the bathroom after that interesting experience." );
				Game.delayedPrint( "As you exit, you hear the late bell ring.");
				Game.delayedPrint( "Great, I'm late for math class, you think to yourself.");
				Game.delayedPrint( "First I fail my APCS test and now I'm late to class.");
				Game.delayedPrint( "I'm not getting into college.");
				Game.delayedPrint( "You cycle these thoughts inside your head until you reach the door to your math class.");

				ct5.recursiveGo( );

			}

			// BATTLE

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
   			// Thread.sleep(1500); 
   			Thread.sleep(0); 
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

    public static void delayedPrintLong ( String output ) { //give user some time to read text
    	try {
			System.out.println(output);
   			// Thread.sleep(2000); 
   			Thread.sleep(0); 
		} 
		catch (InterruptedException e) {
    		e.printStackTrace();
		}
    }

}
