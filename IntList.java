package interpreter;

import java.util.LinkedList;

public class IntList {
	private IntList intlist;
	private static LinkedList<Integer> consts = new LinkedList<Integer>();
	
	IntList(){
		intlist = null;
	}
	
	public LinkedList<Integer> parse() {
		if(!MyScanner.currentToken().substring(0,5).equals("CONST")){
			System.out.println("ERROR: Expected CONST at start of INTLIST");
			System.exit(0);
		}
		StringBuilder constant = new StringBuilder();
		int x = 6;
		char c;
		while((c = MyScanner.currentToken().charAt(x)) != ']'){
			constant.append(c);
			x++;
		}
		consts.add(Integer.parseInt(constant.toString()));
		MyScanner.nextToken(); //COMMA
		if(MyScanner.currentToken().equals("COMMA")){
			MyScanner.nextToken(); //intlist
			intlist = new IntList();
			intlist.parse();
		}
		return consts;
	}
	
	public void clearList(){
		consts.clear();
	}

	public void print() {
		if(consts.size() == 1){
			System.out.print(consts.getFirst());
		} else {
			for(Integer constant : consts){
				if(constant.equals(consts.getLast())){
					System.out.print(constant);
				} else {
					System.out.print(constant + ", ");
				}
			}
		}	
	}

}
