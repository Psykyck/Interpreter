package interpreter;

import java.util.LinkedList;

public class IDList {
	
	private IDList idlist;
	private static LinkedList<String> ids = new LinkedList<String>();
	
	IDList(){
		idlist = null;
	}
	
	public LinkedList<String> parse() {
		if(!MyScanner.currentToken().substring(0,2).equals("ID")){
			System.out.println("ERROR: Expected ID in id-list");
			System.exit(0);
		}
		StringBuilder id = new StringBuilder();
		int x = 3;
		char c;
		while((c = MyScanner.currentToken().charAt(x)) != ']'){
			id.append(c);
			x++;
		}
		ids.add(id.toString());
		MyScanner.nextToken(); //COMMA
		if(MyScanner.currentToken().equals("COMMA")){
			MyScanner.nextToken(); //<id-list>
			idlist = new IDList();
			idlist.parse();
		}
		return ids;
	}
	
	public void clearList(){
		ids.clear();
	}

}
