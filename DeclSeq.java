package interpreter;

public class DeclSeq{
	private DeclSeq decl_seq; 
	private Decl decl;

	DeclSeq(){
		decl_seq = null;
		decl = null;
	}

	public void parse(){
		decl = new Decl();
		decl.parse();
		if(MyScanner.currentToken().equals("INT")){
			decl_seq = new DeclSeq();
			decl_seq.parse();
		}
	}
}
