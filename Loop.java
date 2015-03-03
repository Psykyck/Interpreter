package interpreter;

public class Loop {
	private StmtSeq stmtseq;
	private Cond cond;
	
	Loop(){
		stmtseq = null;
		cond = null;
	}
	
	public void parse() {
		if(!MyScanner.currentToken().equals("DO")){
			System.out.println("Expected DO at start of loop");
			System.exit(0);
		}
		MyScanner.nextToken(); //<stmt-seq>
		stmtseq = new StmtSeq();
		stmtseq.parse();
		if(!MyScanner.currentToken().equals("WHILE")){
			System.out.println("Expected WHILE after cond in loop");
			System.exit(0);
		}
		MyScanner.nextToken(); //<cond>
		cond = new Cond();
		cond.parse();
		if(!MyScanner.currentToken().equals("ENDDO")){
			System.out.println("Expected ENDDO at end of loop");
			System.exit(0);
		}
		MyScanner.nextToken(); //SEMICOL
		if(!MyScanner.currentToken().equals("SEMICOL")){
			System.out.println("Expected SEMICOL at end of loop");
			System.exit(0);
		}
		MyScanner.nextToken();
		
	}

}
