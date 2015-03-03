package interpreter;


public class Factor {
	private Factor factor;
	private Expr expr;
	private int altNo;
	private Decl declList;
	
	Factor(){
		factor = null;
		expr = null;
		altNo = 0;
		declList = new Decl();
	}
	
	public int[] parse() {
		int[] array = {0,0};
		if(MyScanner.currentToken().substring(0, 5).equals("CONST")){
			altNo = 1;
			array[0] = 1;
			StringBuilder num = new StringBuilder();
			int x = 6;
			char c;
			while((c = MyScanner.currentToken().charAt(x)) != ']'){
				num.append(c);
				x++;
			}
			array[1] = Integer.parseInt(num.toString());
			MyScanner.nextToken();
		} else if (MyScanner.currentToken().substring(0, 2).equals("ID")){
			altNo = 2;
			StringBuilder id = new StringBuilder();
			int x = 3;
			char c;
			while((c = MyScanner.currentToken().charAt(x)) != ']'){
				id.append(c);
				x++;
			}
			if(!(declList.getDeclared()).containsKey(id.toString())){
				System.out.println("ERROR: Cannot assign undeclared ID[" + id + "]");
				System.exit(0);
			}
			if(declList.getDeclared().get(id.toString()) == null){
				System.out.println("ERROR: ID[" + id + "] cannot be used without an assigned value");
				System.exit(0);
			} else {
				array[0] = 1;
				array[1] = declList.getDeclared().get(id.toString());
			}
			MyScanner.nextToken();
		} else if (MyScanner.currentToken().equals("MINUS")){
			altNo = 3;
			MyScanner.nextToken(); //<factor>
			factor = new Factor();
			factor.parse();
		} else if (MyScanner.currentToken().equals("LEFTPAREN")){
			altNo = 4;
			MyScanner.nextToken(); //<expr>
			expr = new Expr();
			expr.parse();
			if(!MyScanner.currentToken().equals("RIGHTPAREN")){
				System.out.println("ERROR: Expected RIGHTPAREN to close expr in factor");
				System.exit(0);
			}
			MyScanner.nextToken();
		} else {
			System.out.println("ERROR: Invalid factor");
			System.exit(0);
		}
		return array;
	}

}
