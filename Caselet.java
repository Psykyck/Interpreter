package interpreter;

public class Caselet {
	private IntList intlist;
	private Expr expr;
	
	Caselet(){
		intlist = null;
		expr = null;
	}
	
	public void parse() {
		intlist = new IntList();
		intlist.parse();
		if(!MyScanner.currentToken().equals("COLON")){
			System.out.println("ERROR: Expected COLON after INTLIST");
			System.exit(0);
		}
		MyScanner.nextToken(); // <expr>
		expr = new Expr();
		expr.parse();
	}

	public void print() {
		intlist.print();
		System.out.print(" : ");
		expr.print();
	}

}
