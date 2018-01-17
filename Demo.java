public class Demo {
	
	public static void main(String[] args) {
		System.out.println( "You're walking home from school and you feel like something really shady is going on" );

        String[] action = {"print", "Investigate?"};
	    ChoiceTree ct = new ChoiceTree("", action);

	    String[] a2 = {"print", "You choose not to get tangled up in someone else's business and go home"};
	    ChoiceTree ct2 = new ChoiceTree("No", a2);

	    String[] a2a = {"print", "You round the corner and you see a hooded man with his laptop. Aside from the laptop something seems off."};
	    ChoiceTree ct2a = new ChoiceTree("Yes", a2a);

	    ct.assimilate(ct2);
	    ct.assimilate(ct2a);

	    String[] daf = {"print", "Man: Get outta here before you know what's good for you!"};
	    ChoiceTree ct22 = new ChoiceTree("Say: Hello?", daf);
	    ct2a.assimilate(ct22);


	    String[] action2 = {"createCodefight", "Make a function" +
                " add(number1, number2), that adds the numbers"+
                " i.e.: add(1,2) --> 3.\n#add(0,0) --> 0",
                "assert add(3,5) == 8"};
	    ChoiceTree ct3 = new ChoiceTree("Challenge the man to a Codefight", action2);
	    ct22.assimilate(ct3);

	    String[] action2a = {"print" , "After Codefighting that man into oblivion, you leave the crime scene. Good prep for your upcoming APCS test."};
	    ChoiceTree ct4a = new ChoiceTree("Leave" , action2a);
	    ct3.assimilate(ct4a);

	    String[] action3 = {"battle" , "Stranger"};
	    ChoiceTree ct3a = new ChoiceTree("Attack the man", action3);
	    ct22.assimilate(ct3a);

	    String[] action2b = {"print" , "After beating that man into oblivion, you leave the crime scene. Good prep for your upcoming APCS test, I suppose?"};
	    ChoiceTree ct4b = new ChoiceTree("Leave" , action2b);
	    ct3a.assimilate(ct4b);

	    String[] action4 = {"print" , "You leave the man and go home. You have a APCS test to study for anyways."};
	    ChoiceTree ct3b = new ChoiceTree("Leave", action4);
	    ct22.assimilate(ct3b);
 
	    while(true){
	        ct = ct.go();
	        if (ct==null)break;
        }
	}

}