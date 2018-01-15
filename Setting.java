public abstract class Setting{

	Character[] chars;

    public Setting(Character[] chars){
	for(int i = 0; i < chars.length;i++){
	    chars[i].setting = this;
	}
	this.chars = chars;
    }

    abstract void runMainLoop();
}

    
