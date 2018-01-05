public abstract class Character {

    public int maxhp;
    public int currenthp;
    public int atk;
    public int def;
    public int spd;
    public int exp;
    public int gold;
    
    public abstract void attack ( Player other );

    public abstract void speak ( String context );
    
}
