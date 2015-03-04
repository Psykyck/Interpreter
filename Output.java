package interpreter;

public class Output {
	private IDList idlist;
	
	Output(){
		idlist = null;
	}
	
	public void parse() {
		if(!MyScanner.currentToken().equals("OUTPUT")){
			System.out.println("ERROR: Expected INPUT at start of output");
			System.exit(0);
		}
		MyScanner.nextToken(); //<id-list>
		idlist = new IDList();
		idlist.parse();
		if(!MyScanner.currentToken().equals("SEMICOL")){
			System.out.println("ERROR: Expected SEMICOL at end of output");
			System.exit(0);
		}
		MyScanner.nextToken();
		
	}

	public void print() {
		System.out.print("  output ");
		idlist.print();
		System.out.println(";");
	}

}
