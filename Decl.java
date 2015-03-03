package interpreter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Decl{
	private IDList idlist;
	public static Map<String, Integer> list = new HashMap<String, Integer>();
	private LinkedList<String> ids;

	Decl(){
		idlist = null;
		ids = new LinkedList<String>();
	}

	public void parse(){
		if(!MyScanner.currentToken().equals("INT")){
			System.out.println("ERROR: Expected INT to begin decl");
			System.exit(0);
		}
		MyScanner.nextToken(); //skip INT
		idlist = new IDList();
		ids = idlist.parse();
		for(String id : ids){
			if(list.containsKey(id)){
				System.out.println("ERROR: Confliciting ID names in decl");
				System.exit(0);
			} else {
				list.put(id, null);
			}
		}
		idlist.clearList();
		if(!MyScanner.currentToken().equals("SEMICOL")){
			System.out.println("ERROR: Expected SEMICOL at end of decl");
			System.exit(0);
		}
		MyScanner.nextToken();
	}
	
	public Map<String, Integer> getDeclared(){
		return list;
	}
}