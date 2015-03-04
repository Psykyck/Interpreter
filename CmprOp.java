package interpreter;

public class CmprOp {
	private int altNo;
	
	CmprOp(){
		altNo = 0;
	}
	
	public void parse() {
		String token = MyScanner.currentToken();
		if(token.equals("LESSTHAN")){
			altNo = 1;
		} else if (token.equals("EQUAL")){
			altNo = 2;
		} else if (token.equals("NOTEQUAL")){
			altNo = 3;
		} else if (token.equals("GREATERTHAN")){
			altNo = 4;
		} else if (token.equals("GREATERTHANEQUAL")){
			altNo = 5;
		} else if (token.equals("LESSTHANEQUAL")){
			altNo = 6;
		} else {
			System.out.println("ERROR: Invalid comparison operator");
			System.exit(0);
		}
		MyScanner.nextToken();
	}

	public void print() {
		if (altNo == 1){
			System.out.print("<");
		} else if (altNo == 2){
			System.out.print("=");
		} else if (altNo == 3){
			System.out.print("!=");
		} else if (altNo == 4){
			System.out.print(">");
		} else if (altNo == 5){
			System.out.print(">=");
		} else {
			System.out.print("<=");
		}
	}

}
