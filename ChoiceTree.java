import java.util.Scanner;
import java.util.ArrayList;

public class ChoiceTree{

    public ArrayList<ChoiceTree> data;
    public String prompt;
    public Action action;

    public ChoiceTree(String p, Action a){
	prompt = p;
    }

    public void assimilate(ChoiceTree victim){
	data.add(victim);
    }

    public ChoiceTree manageAction(){
	for(int i = 0; i < data.size(); i++){
	    System.out.println((i+1) + ". " + data.get(i).prompt);
	}
	Scanner reader = new Scanner(System.in);
	System.out.print("> ");
	String in = reader.next();
	try{
	    return data.get(Integer.parseInt(in));
	}catch (Exception e){
	    return manageAction();
	}
    }

    
    public ChoiceTree go(){
	action.run();
	return manageAction();
    }
}
