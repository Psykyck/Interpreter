package interpreter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.LinkedList;

public class Interpreter {
	private static LinkedList<Integer> intList = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {	
		if(args.length > 0){
			MyScanner scanner = new MyScanner(args[0]);
			scanner.print(); //Print token list
			System.out.println("\n");
			if(args.length == 2){
				File file = new File(args[1]);
				if(file.exists()){
					BufferedReader reader = new BufferedReader(
						    new InputStreamReader(
						        new FileInputStream(file), Charset.forName("UTF-8")));
					int c;
					while((c = reader.read()) != -1) {
						char character = (char) c;
						if (character != ' ' && character != '\n' && character != '\t'){
							if (character == '-'){
								StringBuilder negInt = new StringBuilder();
								while(character != ' ' && character != '\n' && character != '\t' && (int)character != -1){
									negInt.append(character);
									character = (char) reader.read();
								}
								intList.add(Integer.parseInt(negInt.toString()));			
							} else if (Character.isDigit(character)){
								StringBuilder posInt = new StringBuilder();
								while(Character.isDigit(character) && (int)character != -1){
									posInt.append(character);
									character = (char) reader.read();
								}
								intList.add(Integer.parseInt(posInt.toString()));
							} else {
								System.out.println("ERROR: Invalid input in data file");
								System.exit(0);
							}
						}
					}
					reader.close();
				} else {
					System.out.println("ERROR: Data file does not exist!");
					System.exit(0);
				}
			}
			/*for(Integer value : intList){
				System.out.print(value + " ");
			}*/
			
			Prog program = new Prog();
			program.parse();
			program.print();
		} else {
			System.out.println("ERROR: Please enter at least one argument");
			System.exit(0);
		}
		
	}
 
	public static Integer inputValue(){
		return intList.peekFirst();
	}
	
	
}