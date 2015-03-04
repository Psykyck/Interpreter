package interpreter;

public class Cmpr {
	private Expr expr1;
	private Expr expr2;
	private CmprOp cmprop;
	
	Cmpr(){
		expr1 = null;
		expr2 = null;
		cmprop = null;
	}
	
	public void parse() {
		if(!MyScanner.currentToken().equals("LEFTBRACK")){
			System.out.println("ERROR: Expected LEFTBRACK at start of comparison");
			System.exit(0);
		}
		MyScanner.nextToken(); //<expr>
		expr1 = new Expr();
		expr1.parse();
		cmprop = new CmprOp();
		cmprop.parse();
		expr2 = new Expr();
		expr2.parse();
		if(!MyScanner.currentToken().equals("RIGHTBRACK")){
			System.out.println("ERROR: Expected RIGHTBRACK at end of comparison");
			System.exit(0);
		}
		MyScanner.nextToken();
	}

	public void print() {
		System.out.print("[");
		expr1.print();
		cmprop.print();
		expr2.print();
		System.out.print("]");
		
	}

}
