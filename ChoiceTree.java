import java.awt.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ChoiceTree{

	public ArrayList<ChoiceTree> data = new ArrayList<ChoiceTree>();
	public String prompt;
	public String[] action;

	public ChoiceTree(String p, String[] a){

	    prompt = p;
	    action = a;
	}

	public void assimilate(ChoiceTree victim){
		data.add(victim);
	}

	public ChoiceTree manageAction(){
	    if(data.size()==0) return null;
		for(int i = 0; i < data.size(); i++){
			System.out.println((i+1) + ". " + data.get(i).prompt);
		}
		Scanner reader = new Scanner(System.in);
		System.out.print("> ");
		String in = reader.next();
		try{
			return data.get(Integer.parseInt(in)-1);
		}catch (Exception e){
			return manageAction();
		}
	}


	public ChoiceTree go(){
		Action a = new Action(action);
		a.run();
		return manageAction();
	}
}
