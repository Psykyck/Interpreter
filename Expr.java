package interpreter;

public class Expr {
	private int altNo;
	private Term term;
	private Expr expr;
	
	Expr(){
		altNo = 0;
		term = null;
		expr = null;
	}
	
	public int[] parse() {
		term = new Term();
		int[] array = term.parse();
		if(MyScanner.currentToken().equals("PLUS")){
			altNo = 1;
			MyScanner.nextToken(); //<expr>
			expr = new Expr();
			expr.parse();
		} else if (MyScanner.currentToken().equals("MINUS")){
			altNo = 2;
			MyScanner.nextToken();
			expr = new Expr();
			expr.parse();
		}
		return array;
	}

}
