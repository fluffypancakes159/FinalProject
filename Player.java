import java.util.ArrayList;

public class Player extends Character {

    public ArrayList<Item> inventory;
    public Weapon equipWeapon;
    public int modatk;

    public Player ( ) {
    	this ( "Player" );
    }

    public Player ( String n ) {
    	this ( 30 , 5 , 2 , 1 , 0 , 5 , n );
        /*
    	level = 1;
        inventory = new ArrayList<Item>();
        equipWeapon = new Weapon ( );
        */
    }

    public Player ( int hp , int atk , int def , int spd , int exp , int gold , String name ) {
        super ( hp , atk , def , spd , exp , gold , name );
        level = 1;
        inventory = new ArrayList<Item>();
        equipWeapon = new Weapon();
        modatk = atk;
    }

    public void die ( Enemy other ) {
        if ( currenthp <= 0 ) {
            Game.delayedPrintShort( "You slowly lose consciousness as your vision fades to black.");
            Game.delayedPrint( "Perhaps things could've gone differently..." );
            System.exit(0);
        }
        else {
            reward( other );
        }
    }

    public void reward ( Enemy other ) {
        gold += other.gold;
        Game.delayedPrint( "You received " + other.gold + " dollars!" );
        exp += other.exp;
        Game.delayedPrint( "You received " + other.exp + " EXP!" );
        levelUp( );

    }

    public boolean levelUp ( ) {
        boolean levelChange = false;
        while (exp >= level * 2 + 5) {
            exp -= level * 2 + 5;
	        level++;
            Game.delayedPrint( "You leveled up to " + level + "!");
            int m = (int)(Math.random() * 3 + 3);
            maxhp += m;
            Game.delayedPrintShort ( "HP increased by " + m + "!");
            m = (int)(Math.random() * 3 + 1);
            atk += m;
            Game.delayedPrintShort ( "ATK increased by " + m + "!");
            m = (int)(Math.random() * 3 + 1);
            def += m;
            Game.delayedPrintShort ( "DEF increased by " + m + "!");
            m = (int)(Math.random() * 3 + 1);
            spd += m;
            Game.delayedPrintShort ( "SPD increased by " + m + "!");
            heal ( maxhp );
            levelChange = true; // if there is a level up, the method returns true
        }
        return levelChange;
    }

    public void buy ( Item item ) {
        if ( gold >= item.cost ) {
            gold -= item.cost;
            if ( inventory.indexOf(item) < 0 ) {
                inventory.add(item);
                item.quantity = 1;
            }
            else {
                item.quantity++;
            }
        }
        else {
            Game.delayedPrintShort( "Sorry, not enough money!");
        }
    }

    public void receive ( Item item ) {
        if ( inventory.indexOf(item) < 0 ) {
            inventory.add(item);
            item.quantity = 1;
        }
        else {
            item.quantity++;
        }
    }

    public void viewStats ( ) {
        System.out.println ( this );
        this.printInventory( );
    }

    public void printInventory ( ) {
        int i = 0;
        System.out.println( "----------------------------------------");
        for (Item item : inventory) {
            i++;
            System.out.println( "" + i + ". " + item );
        }
        System.out.println( "----------------------------------------\n");
    }

    public String toString ( ) {
        String name_ = name + "'s Stats\n";
        String level_ = "Level: " + level + "\n";
        String exp_ = "EXP until next level: " + (level * 2 + 5 - exp) + "\n";
        String hp_ = "HP: " + currenthp + "/" + maxhp + "\n";
        String weap_ = "Currently equipped: " + equipWeapon.name + "\n";
        String atk_ = "ATK: " + atk + " + " + equipWeapon.atk + "\n";
        String def_ = "DEF: " + def + "\n";
        String spd_ = "SPD: " + atk + "\n";
        String gold_ = "Money: $" + gold + "\n";
        return name_ + level_ + exp_ + hp_ + weap_ + atk_ + def_ + spd_ + gold_;
    }

    public void equip ( Weapon equipWeapon ) {
        if ( inventory.indexOf( equipWeapon) >= 0 &&
             modatk == atk ) {
            this.equipWeapon = equipWeapon;
            this.modatk += equipWeapon.atk;
            System.out.println( equipWeapon.name + " equipped!\n");
        }
        else if ( this.equipWeapon.equals( equipWeapon ) ) {
            Game.delayedPrintShort( "Already equipped!");
        }

    }

    public void unequip ( ) {
        equipWeapon = new Weapon ( );
        this.modatk = this.atk;
    }

    public int damage ( Character other , String attackType ) { // updated damage function to account for equipped weapons
        int damage = modatk - other.def;                 
        if ( attackType == "kick") {
            damage += (int)(Math.random() * 3) + 1;
        }
        if ( damage < 1 ) {                     
            damage = 1;                         
        }
        other.currenthp = other.currenthp - damage; 
        return damage;
    }

    /*

    public void useItem ( ) {
        ArrayList<Restorative> list = new ArrayList<Restorative>();
        for ( Item item : inventory ) {
            if ( item instanceof Restorative ) {
                list.add(item);
            }
        }
        int i = 0;
        for ( Restorative r : list) {
            System.out.println( "" + i + " " + r );
        }
        Scanner itemChoice = new Scanner (System.in);
        int n;
        while ( true ) {
            try {
                n = itemChoice.nextInt();
                user.heal( list.get(n).healamt );
                break;
            }   
            catch ( InputMismatchException e ) {
                System.out.println( "Enter a valid number: " );
                itemChoice.nextLine(); // consumes the bad input so the user can make another one that is hopefully correct
            }
        }

    }
    */

}
