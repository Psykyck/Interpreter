package interpreter;

public class IfLoop {
	private Cond cond;
	private StmtSeq stmtseq1;
	private StmtSeq stmtseq2;
	
	IfLoop(){
		cond = null;
		stmtseq1 = null;
		stmtseq2 = null;
	}
	
	public void parse() {
		if(!MyScanner.currentToken().equals("IF")){
			System.out.println("ERROR: Expexcted IF at start of if statment");
			System.exit(0);
		}
		MyScanner.nextToken(); //<cond>
		cond = new Cond();
		cond.parse();
		if(!MyScanner.currentToken().equals("THEN")){
			System.out.println("ERROR: Expexcted THEN after cond in if statement");
			System.exit(0);
		}
		MyScanner.nextToken(); //<stmt-seq>
		stmtseq1 = new StmtSeq();
		stmtseq1.parse();
		if (MyScanner.currentToken().equals("ELSE")){
			MyScanner.nextToken(); //<stmt-seq>
			stmtseq2 = new StmtSeq();
			stmtseq2.parse();
		}
		if (!MyScanner.currentToken().equals("ENDIF")){
			System.out.println("ERROR: Expexcted ENDIF at end of if statment");
			System.exit(0);
		}
		MyScanner.nextToken(); //SEMICOL
		if (!MyScanner.currentToken().equals("SEMICOL")){
			System.out.println("ERROR: Expexcted SEMICOL at end of if statment");
			System.exit(0);
		}
		MyScanner.nextToken();	
	}

	public void print() {
		System.out.print("  if ");
		cond.print();
		System.out.println(" then");
		System.out.print("  ");
		stmtseq1.print();
		if (stmtseq2 != null){
			System.out.println("  else");
			System.out.print("  ");
			stmtseq2.print();
		}
		System.out.println("  endif;");
		
	}
}
