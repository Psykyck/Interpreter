package interpreter;

public class StmtSeq {
	private StmtSeq stmtseq;
	private Stmt stmt;
	
	StmtSeq(){
		stmtseq = null;
		stmt = null;
	}
	
	public void parse() {
		stmt = new Stmt();
		stmt.parse();
		if(MyScanner.currentToken().substring(0,2).equals("ID") || MyScanner.currentToken().equals("IF") || MyScanner.currentToken().equals("DO") || MyScanner.currentToken().equals("INPUT") || MyScanner.currentToken().equals("OUTPUT") || MyScanner.currentToken().equals("CASE")){
			stmtseq = new StmtSeq();
			stmtseq.parse();
		}
		
	}

	public void print() {
		stmt.print();
		if(stmtseq != null){
			stmtseq.print();
		}
	}
}
