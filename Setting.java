public abstract class Setting{

    public Setting(Character[] chars){
	for(int i = 0; i < chars.size();i++){
	    chars.setting = this;
	}
	this.chars = chars;
    }

    abstract void runMainLoop(){}
}

    
