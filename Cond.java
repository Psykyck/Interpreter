package interpreter;

public class Cond {
	private int altNo;
	private Cmpr cmpr;
	private Cond cond1;
	private Cond cond2;

	Cond(){
		altNo = 0;
		cmpr = null;
		cond1 = null;
		cond2 = null;
	}
	
	public void parse() {
		String token = MyScanner.currentToken();
		if(token.equals("LEFTBRACK")){
			altNo = 1;
			cmpr = new Cmpr();
			cmpr.parse();
		} else if (token.equals("NOT")){
			altNo = 2;
			MyScanner.nextToken(); //<cond>
			cond1 = new Cond();
			cond1.parse();
		} else if (token.equals("LEFTPAREN")){
			MyScanner.nextToken(); //<cond>
			cond1 = new Cond();
			cond1.parse();
			if(MyScanner.currentToken().equals("AND")){
				altNo = 3;
			} else if (MyScanner.currentToken().equals("OR")){
				altNo = 4;
			} else {
				System.out.println("ERROR: Invalid operator in condition");
				System.exit(0);
			}
			MyScanner.nextToken(); //<cond>
			cond2 = new Cond();
			cond2.parse();
			if(!MyScanner.currentToken().equals("RIGHTPAREN")){
				System.out.println("ERROR: Expected RIGHTPAREN at end of condition");
				System.exit(0);
			}
			MyScanner.nextToken();
		} else {
			System.out.println("ERROR: Invalid condition");
			System.exit(0);
		}
		
	}

	public void print() {
		if (altNo == 1){
			cmpr.print();
		} else if (altNo == 2){
			System.out.print("!");
			cond1.print();
		} else {
			System.out.print("(");
			cond1.print();
			if (altNo == 3) {
				System.out.print(" && ");
			} else {
				System.out.print(" || ");
			}
			cond2.print();
			System.out.print(")");
		}
		
	}

}
