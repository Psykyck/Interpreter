package interpreter;

public class Stmt {
	private int altNo;
	private Assign s1;
	private IfLoop s2;
	private Loop s3;
	private Input s4;
	private Output s5;
	private Case s6;
	
	Stmt(){
		altNo = 0;
		s1 = null;
		s2 = null;
		s3 = null;
		s4 = null;
		s5 = null;
		s6 = null;
	}
	
	public void parse() {
		String token = MyScanner.currentToken();
		if(token.substring(0,2).equals("ID")){
			altNo = 1;
			s1 = new Assign();
			s1.parse();
		} else if (token.equals("IF")){
			altNo = 2;
			s2 = new IfLoop();
			s2.parse();
		} else if (token.equals("DO")){
			altNo = 3;
			s3 = new Loop();
			s3.parse();
		} else if (token.equals("INPUT")){
			altNo = 4;
			s4 = new Input();
			s4.parse();
		} else if (token.equals("OUTPUT")){
			altNo = 5;
			s5 = new Output();
			s5.parse();
		} else if (token.equals("CASE")){
			altNo = 6;
			s6 = new Case();
			s6.parse();
		} else {
			System.out.println("ERROR: Invalid statement");
			System.exit(0);
		}
	}

}
