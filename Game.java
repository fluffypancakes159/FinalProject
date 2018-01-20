public class Game {

	Setting currentLocation;

	public void setCurrentLocation ( Setting l ) {
		currentLocation = l;
	}

	public static void main(String[] args) {
		
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
