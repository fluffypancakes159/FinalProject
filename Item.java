public class Item {

    public int quantity;
    public int cost;
    public String name;

    public Item ( int cost , String name ) {
    	this.cost = cost;
    	this.name = name;
    	quantity = 0;
    }

    public String toString ( ) {
    	return "" + quantity + "x " + name + " - $" + cost;
    }

    public boolean equals ( Item other ) {
    	return name.equals(other.name);
    }

}

