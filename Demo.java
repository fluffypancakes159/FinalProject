public class Demo {
	
	public static void main(String[] args) {
        String[] action = {"print", "THERE SEEMS TO BE A VAPER HERE"};
	    ChoiceTree ct = new ChoiceTree("", action);

	    String[] a2 = {"print", "VAPER: HELLO THERE"};
	    ChoiceTree ct2 = new ChoiceTree("Say: Whas good mah homie, gimmie a hit", a2);

	    String[] a2a = {"print", "VAPER: fuck outta here before i whoop yo ugly ass"};
	    ChoiceTree ct2a = new ChoiceTree("Say: Fuck outta my bathroom nigga, or else ill shit on you", a2a);

	    ct.assimilate(ct2);
	    ct.assimilate(ct2a);

	    String[] daf = {"print", "VAPER: nah homie"};
	    ChoiceTree ct22 = new ChoiceTree("Say: You got any hits left nigga?", daf);
	    ct2.assimilate(ct22);


	    String[] action2 = {"createCodefight", "Make a function" +
                " insult(name), that insults the person with that name"+
                " i.e.: insult(John) --> \"John, I fucked your mom\".\n#insult(Bob) --> \"Bob, I fucked your mom\"",
                "assert insult(\"joe\")==\"joe, I fucked your mom\""};
	    ChoiceTree ct3 = new ChoiceTree("codefight the shit outta this ugly ass nigga", action2);
	    ct2a.assimilate(ct3);

	    String[] action3 = {"battle" , "Vaper"};
	    ChoiceTree ct3a = new ChoiceTree("beat up this guy", action3);
	    ct2a.assimilate(ct3a);

	    while(true){
	        ct = ct.go();
	        if (ct==null)break;
        }
	}

}