package interpreter;

public class Case {
	private CaseletList caseletlist;
	private Expr expr;
	private String var;
	private Decl declList;
	
	Case(){
		caseletlist = null;
		expr = null;
		var = null;
		declList = new Decl();
	}
	
	public void parse() {
		if(!MyScanner.currentToken().equals("CASE")){
			System.out.println("ERROR: Expected CASE at beginning of case statement");
			System.exit(0);
		}
		MyScanner.nextToken(); //ID
		if(MyScanner.currentToken().substring(0,2).equals("ID")){
			StringBuilder id = new StringBuilder();
			int x = 3;
			char c;
			while((c = MyScanner.currentToken().charAt(x)) != ']'){
				id.append(c);
				x++;
			}
			var = id.toString();
			if(declList.getDeclared().get(var) == null){
				System.out.println("ERROR: ID[" + var + "] cannot be used without an assigned value");
				System.exit(0);
			}
		} else {
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

	public void print() {
		System.out.println("  case " + var + " of");
		System.out.print("    ");
		caseletlist.print();
		System.out.print("\n    else ");
		expr.print();
		System.out.println("\n  end;");
	}

}
