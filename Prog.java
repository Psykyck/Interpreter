package interpreter;


public class Prog{
	private DeclSeq decl_seq; 
	private StmtSeq stmt_seq;

	Prog(){
		decl_seq = null;
		stmt_seq = null;
	}

	public void parse(){
		if(!MyScanner.currentToken().equals("PROGRAM")){
			System.out.println("ERROR: Expected PROGRAM to begin program");
			System.exit(0);
		}
		MyScanner.nextToken(); //skip PROGRAM
		decl_seq = new DeclSeq();
		decl_seq.parse();
		if(!MyScanner.currentToken().equals("BEGIN")){
			System.out.println("ERROR: Expected BEGIN after PROGRAM in program");
			System.exit(0);
		}
		MyScanner.nextToken(); //skip BEGIN
		stmt_seq = new StmtSeq();
		stmt_seq.parse();
		if(!MyScanner.currentToken().equals("END")){
			System.out.println("ERROR: Expected END after BEGIN in program");
			System.exit(0);
		}
	}
}
