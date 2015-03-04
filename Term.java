package interpreter;

public class Term {
	private Factor factor;
	private Term term;
	
	Term(){
		factor = null;
		term = null;
	}
		
	public int[] parse() {
		factor = new Factor();
		int[] array = factor.parse();
		if(MyScanner.currentToken().equals("TIMES")){
			MyScanner.nextToken(); //<term>
			term = new Term();
			term.parse();
		}
		return array;
	}

	public void print() {
		factor.print();
		if (term != null){
			System.out.print("*");
			term.print();
		}
	}

}
