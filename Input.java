package interpreter;

import java.util.LinkedList;

public class Input {
	private IDList idlist;
	private LinkedList<String> ids;
	private Decl declList;
	
	Input(){
		idlist = null;
		ids = new LinkedList<String>();
		declList = new Decl();
	}
	
	public void parse() {
		if(!MyScanner.currentToken().equals("INPUT")){
			System.out.println("ERROR: Expected INPUT at start of input");
			System.exit(0);
		}
		MyScanner.nextToken(); //<id-list>
		idlist = new IDList();
		ids = idlist.parse();
		for(String id : ids){
			if(!(declList.getDeclared()).containsKey(id)){
				System.out.println("ERROR: ID[" + id + "] is undeclared in INPUT");
				System.exit(0);
			} else {
				declList.getDeclared().put(id, Interpreter.inputValue());
			}
		}
		idlist.clearList();
		if(!MyScanner.currentToken().equals("SEMICOL")){
			System.out.println("ERROR: Expected SEMICOL at end of input");
			System.exit(0);
		}
		MyScanner.nextToken();
		
	}

	public void print() {
		System.out.print("  input ");
		idlist.print();
		System.out.println(";");
	}

}
