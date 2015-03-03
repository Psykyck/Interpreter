package interpreter;

public class IntList {
	private IntList intlist;
	
	IntList(){
		intlist = null;
	}
	
	public void parse() {
		if(!MyScanner.currentToken().substring(0,5).equals("CONST")){
			System.out.println("ERROR: Expected CONST at start of INTLIST");
			System.exit(0);
		}
		MyScanner.nextToken(); //COMMA
		if(MyScanner.currentToken().equals("COMMA")){
			intlist = new IntList();
			intlist.parse();
		}		
	}

}
