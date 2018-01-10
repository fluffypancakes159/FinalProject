public class Game {

	Setting currentLocation;

	public void setCurrentLocation ( Setting l ) {
		currentLocation = l;
	}

	public static void main(String[] args) {
		
	}

	public static void battleUpdate ( Character player , Character other ) {
        System.out.println ( "Player HP: " + player.currenthp + " / " + player.maxhp );
        System.out.println ( "Enemy HP: " + other.currenthp + " / " + other.maxhp );
        System.out.println ( "~~~~~~~~~~~~" ); 
    }
	
}
