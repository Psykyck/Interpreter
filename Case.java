package interpreter;

public class Case {
	private CaseletList caseletlist;
	private Expr expr;
	
	Case(){
		caseletlist = null;
		expr = null;
	}
	
	public void parse() {
		if(!MyScanner.currentToken().equals("CASE")){
			System.out.println("ERROR: Expected CASE at beginning of case statement");
			System.exit(0);
		}
		MyScanner.nextToken(); //ID
		if(!MyScanner.currentToken().substring(0,2).equals("ID")){
			System.out.println("ERROR: Expexcted ID after beginning of CASE block");
			System.exit(0);
		}
		MyScanner.nextToken(); //OF
		if(!MyScanner.currentToken().equals("OF")){
			System.out.println("ERROR: Expected OF after ID in CASE block");
			System.exit(0);
		}
		MyScanner.nextToken(); //<caselet-list>
		caseletlist = new CaseletList();
		caseletlist.parse();
		if(!MyScanner.currentToken().equals("ELSE")){
			System.out.println("ERROR: Expected ELSE after caselet-list in CASE block");
			System.exit(0);
		}
		MyScanner.nextToken(); //<expr>
		expr = new Expr();
		expr.parse();
		if(!MyScanner.currentToken().equals("END")){
			System.out.println("ERROR: Expected END at end of CASE block");
			System.exit(0);
		}
		MyScanner.nextToken(); //SEMICOL
		if(!MyScanner.currentToken().equals("SEMICOL")){
			System.out.println("ERROR: Expected SEMICOL after END in CASE block");
			System.exit(0);
		}
		MyScanner.nextToken();
		
	}

}
