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
		Restorative xanax = new Restorative ( 15 , "xanaX" , 7);
		Scanner input = new Scanner (System.in);
		String n_;
		int n; // initialization stuff
		boolean late = false;
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
				Player A = new Player ( 50 , 100 , 2 , 1 , 0 , 20 , n_ );
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
				Object[] a4aa = { "buy" , A , xanax};
				ChoiceTree ct4aa = new ChoiceTree ( "Buy the xanaX" , a4aa );

				Object[] a4b = { "print" , "Vaper: Looks like we're gonna have a problem then." , "The vaper towers over you threateningly."};
				ChoiceTree ct4b = new ChoiceTree ( "Refuse his offer and walk away" , a4b );
				Object[] a4ba = { "battle" , A , new Enemy ( 15 , 4 , 2 , 1 , 5 , 10 , "Vaper" , "hit") };
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

				ChoiceTree ct7 = new ChoiceTree ( " " , a );

				Object[] a8a = { "print" , "Teacher: I hope you know that's illegal." , "Teacher: I'm taking points off your participation."};
				ChoiceTree ct8a = new ChoiceTree ( "\"I was vaping\"" , a8a );

				Object[] a8b = { "print" , "Teacher: Whatever. I'd like to see at least a late pass next time." 
										 , "You think to yourself, Where would I get a late pass?" };
				ChoiceTree ct8b = new ChoiceTree ( "\"I had to use the bathroom\"" , a8b);

				Object[] a8c = { "print" , "Teacher: Excuse me?!" };
				ChoiceTree ct8c = new ChoiceTree ( "\"Shut up\"" , a8c);
				Object[] a8ca = { "battle" , A , new Enemy ( 20 , 3 , 2 , 2 , 10 , 15 , "Teacher" , "cold call")};
				ChoiceTree ct8ca = new ChoiceTree ( "Engage Teacher" , a8ca);

				ct7.assimilate( ct8a );
				ct7.assimilate( ct8b );
				ct7.assimilate( ct8c );
				ct8c.assimilate( ct8ca );

				ChoiceTree ct9 = new ChoiceTree ( " " , a );

				Object[] a10y = { "set" , late , false };
			    ChoiceTree ct10y = new ChoiceTree ( "Enter drafting on time" , a10y );
			    Object[] a10z = { "set" , late , true };
			    ChoiceTree ct10z = new ChoiceTree ( "Enter drafting late" , a10z );

				Object[] a10a = { "print" , "You sprint up the Hudson staircase, ignoring the couples and vapers." 
										  , "You reach drafting class just as the bell rings."
										  , "That's one crisis averted in this mess of a day." };
			    ChoiceTree ct10a = new ChoiceTree ( "Take the Hudson staircase" , a10a );

			    Object[] a10b = { "print" , "You take the regular staircase."
			    						  , "On your way up, you trip over a bunch of rolling backpacks while suffocating."
			    						  , "After about 15 minutes of being a sardine, you finally reach drafting class." };
				ChoiceTree ct10b = new ChoiceTree ( "Take the regular staircase" , a10b);

				Object[] a10c = { "print" , "You take the escalators."
			    						  , "It's very slow, but at least you're not out of breath and will to live."
			    						  , "However, some kid thinks it's okay to step on your shoes without consequence." };
				ChoiceTree ct10c = new ChoiceTree ( "Take the escalators" , a10c);
				Object[] a10ca = {"battle" , A , new Enemy ( 15 , 6 , 1 , 2 , 5 , 10 , "Freshman" , "trip")};
				ChoiceTree ct10ca = new ChoiceTree( "Engage Freshman" , a10ca);
				Object[] a10caa = { "print" , "Continuing up, you reach the drafting room after a nice ride."
											, "You are definitely late." };
				ChoiceTree ct10caa = new ChoiceTree( "Continue" , a10caa);

				Object[] a10d = { "print" , "You take the elevator while feigning a broken ankle."
			    						  , "On your way up, you encounter a teacher who doesn't quite believe your act." };
				ChoiceTree ct10d = new ChoiceTree ( "Take the elevator" , a10d);
				Object[] a10da = { "battle" , A , new Enemy ( 20 , 4 , 3 , 2 , 10 , 12 , "Teacher" , "reprimand")};
				ChoiceTree ct10da = new ChoiceTree ( "Engage Teacher" , a10da);
				Object[] a10daa = { "print" , "Continuing up, you encounter another student doing the same as you."
											, "There can only be one of you." };
				ChoiceTree ct10daa = new ChoiceTree( "Continue" , a10daa);
				Object[] a10daaa = { "battle" , A , new Enemy ( 10 , 6 , 4 , 2 , 10 , 15 , "Student" , "scratche")};
				ChoiceTree ct10daaa = new ChoiceTree( "Engage Student" , a10daaa);
				Object[] a10daaaa = { "print" , "Continuing up, you finally reach the drafting room."
											  , "It appears you are on time." };
				ChoiceTree ct10daaaa = new ChoiceTree( "Continue" , a10daaaa);

				ct9.assimilate( ct10a );
				ct10a.assimilate( ct10y );
				ct9.assimilate( ct10b );
				ct10b.assimilate( ct10z );
				ct9.assimilate( ct10c );
				ct10c.assimilate( ct10ca);
				ct10ca.assimilate( ct10caa );
				ct10caa.assimilate( ct10z );
				ct9.assimilate( ct10d );
				ct10d.assimilate( ct10da );
				ct10da.assimilate( ct10daa );
				ct10daa.assimilate( ct10daaa );
				ct10daaaa.assimilate( ct10y );

				ChoiceTree ct11 = new ChoiceTree ( "" , a );

				Object[] a11a = { "battle" , A , new Enemy ( 40 , 7 , 4 , 3 , 0 , 999 , "Mr. K" , "program" )};
				ChoiceTree ct11a = new ChoiceTree ( "Engage Mr. K (in battle)" , a11a );

				Object[] a11b = { "createCodefight" , "Given an array of integers, write a function firstDuplicate( array ) to find the index of the first duplicate element in that array. For array = [1, 2, 3, 4, 5, 1, 1, 2, 2, 3, 4], the output should be firstDuplicate(array) = 5." 
													, "assert firstDuplicate( [1, 2, 3, 6, 17, 4, 2, 1, 3, 3, 3, 4, 5, 1, 1, 2, 2, 3, 4] ) = 6 " };
				ChoiceTree ct11b = new ChoiceTree ( "Engage Mr. K (in code battle) (not recommended)" , a11b );

				Object[] a11c = { "bribe" , A };
				ChoiceTree ct11c = new ChoiceTree ( "Bribe Mr. K" , a11c );

				ct11.assimilate( ct11a );
				ct11.assimilate( ct11b );
				ct11.assimilate( ct11c );

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

				Game.delayedPrint( "You enter your Precalculus class terribly late." );
				Game.delayedPrint( "The teacher looks at you with visible disdain.");

				ct7.recursiveGo( );

				Game.delayedPrint( "You quickly try to forget what has occurred." );
				Game.delayedPrint( "Which is easy, since now you have a bigger problem:");
				Game.delayedPrint( "Getting to drafting class" );
				Game.delayedPrint( "On the 3457245892457th floor." );
				Game.delayedPrint( "On time.");
				Game.delayedPrint( "You quickly weigh all your options" );

				ct9.recursiveGo( );

				if (late) {
					Game.delayedPrint( "You enter drafting along with 10 other out-of-breath kids." );
					Game.delayedPrint( "You're teacher is too busy teaching graph theory to notice you enter.");
					Game.delayedPrint( "You notice a nice pen on the floor, one too nice to pass up." );
					A.receive( pen );
					A.equip( pen );
					Game.delayedPrint( "Pen equipped!");
				}
				else {
					Game.delayedPrint( "You enter drafting second, only to that kid who somehow is always there first." );
					Game.delayedPrint( "You go to your desk and notice a nice compass on the floor.");
					Game.delayedPrint( "Welp, finders keepers, you think to yourself as you reach for the compass.");
					A.receive( compass );
					A.equip( compass ); 
					Game.delayedPrint( "The lesson starts, even though 2 out of 30 students are present." );
					Game.delayedPrint( "The teacher starts talking about how to draw lines." );
					Game.delayedPrint( "However after 10 minutes, the lesson devolves into a college-level graph theory lecture." );
					Game.delayedPrint( "Whatever, you're sure someone out there will make a study sheet anyways." );
					Game.delayedPrint( "Compass equipped!");
				}

				Game.delayedPrintLong( "After about 30 minutes of confusing garbage that you definitely didn't sleep through, you're jolted awake by the screech of the end bell.");
				Game.delayedPrint( "As you leave the classroom, you notice Mr. K outside your classroom.");
				Game.delayedPrint( "Strange, but an opportunity nonetheless.");
				Game.delayedPrint( "You run up to Mr. K and request that you receive a 99 instead of a ridiculous 98.");
				Game.delayedPrint( "Mr. K: If you want this mere point, then you're going to have to prove yourself");
				Game.delayedPrint( "This is it, the moment of truth.");

				ct11.recursiveGo( );

				Game.delayedPrintLong( "Congrulations on defeating Mr. K ('s apprehension to give you a 99) and receiving that 99!" );
				Game.delayedPrintLong( "And thank you for playing!" );

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
				Action.createCodefight( "Write a function TwotoFive( String ) that converts all 2's to 5's and vice versa. Ex: \"21506\" -> \"51206\"" 
										, "assert TwotoFive( 11245463152342 ) = 11542463125345");
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
   			Thread.sleep(1200); 
   			// Thread.sleep(0); 
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
   			Thread.sleep(2000); 
   			// Thread.sleep(0); 
		} 
		catch (InterruptedException e) {
    		e.printStackTrace();
		}
    }

}
