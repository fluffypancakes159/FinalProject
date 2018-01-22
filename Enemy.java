public class Enemy extends Character { 

	public String atkmsg;

	public Enemy ( ) {
		this ( "Enemy" );
	}

	public Enemy ( String n ) {
		super ( n );
	}

	public Enemy ( int hp , int atk , int def , int spd , int exp , int gold , String name ) {
        super ( hp , atk , def , spd , exp , gold , name );
        this.atkmsg = "hit";
        level = 1;
    }

	public Enemy ( int hp , int atk , int def , int spd , int exp , int gold , String name , String atkmsg ) {
        super ( hp , atk , def , spd , exp , gold , name );
        this.atkmsg = atkmsg;
        level = 1;
    }

    public String toString ( ) {
        String name_ = name + "'s Stats\n";
        String hp_ = "HP: " + currenthp + "/" + maxhp + "\n";
        String atk_ = "ATK: " + atk + "\n";
        String def_ = "DEF: " + def + "\n";
        String spd_ = "SPD: " + atk + "\n";
        String gold_ = "Money: $" + gold + "\n";
        String exp_ = "EXP: " + exp + "\n";
        return name_ + hp_ + atk_ + def_ + spd_ + gold_ + exp_;

    }

}