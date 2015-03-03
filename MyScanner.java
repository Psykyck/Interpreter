package interpreter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.LinkedList;


public class MyScanner {
	
	private String file;
	private static LinkedList<String> tokenlist;
	private boolean error = false;
	
	MyScanner(String filename) throws IOException{
		file = filename;
		tokenlist = new LinkedList<String>();
		Tokenizer();
	}
	
	private void Tokenizer() throws IOException{
		
		BufferedReader reader = new BufferedReader(
			    new InputStreamReader(
			        new FileInputStream(file), Charset.forName("UTF-8")));
			int c;
			while((c = reader.read()) != -1) {
				char character = (char) c;
				if (character != ' ' && character != '\n' && character != '\t'){
					switch (character) {
						case ';': tokenlist.add("SEMICOL");
							break;
						case ',': tokenlist.add("COMMA");
							break;
						case '(': tokenlist.add("LEFTPAREN");
							break;
						case ')': tokenlist.add("RIGHTPAREN");
							break;
						case '[': tokenlist.add("LEFTBRACK");
							break;
						case ']': tokenlist.add("RIGHTBRACK");
							break;
						case '=': tokenlist.add("EQUAL");
							break;
						case '+': tokenlist.add("PLUS");
							break;
						case '-': tokenlist.add("MINUS");
							break;
						case '*': tokenlist.add("TIMES");
							break;
						case '|': tokenlist.add("BAR");
							break;
						case ':':
							reader.mark(1);
							if(reader.read() == '='){
								tokenlist.add("ASSIGN");
							} else {
								tokenlist.add("COLON");
								reader.reset();
							}
							break;
						case '!':
							reader.mark(1);
							if(reader.read() == '='){
								tokenlist.add("NOTEQUAL");
							} else {
								tokenlist.add("NOT");
								reader.reset();
							}
							break;
						case '>':
							reader.mark(1);
							if(reader.read() == '='){
								tokenlist.add("GREATERTHANEQUAL");
							} else {
								tokenlist.add("GREATERTHAN");
								reader.reset();
							}
							break;
						case '<':
							reader.mark(1);
							if(reader.read() == '='){
								tokenlist.add("LESSTHANEQUAL");
							} else {
								tokenlist.add("LESSTHAN");
								reader.reset();
							}
							break;
						default:
							StringBuilder keyword = new StringBuilder();
							if(Character.isLetter(character)){
								while(Character.isLetter(character) || Character.isDigit(character)){
									reader.mark(1);
									keyword.append(character);
									character = (char) reader.read();
								}
								String key = keyword.toString();
								switch (key) {
									case "program": tokenlist.add(key.toUpperCase());
										break;
									case "begin": tokenlist.add(key.toUpperCase());
										break;
									case "int": tokenlist.add(key.toUpperCase());
										break;
									case "input": tokenlist.add(key.toUpperCase());
										break;
									case "output": tokenlist.add(key.toUpperCase());
										break;
									case "if": tokenlist.add(key.toUpperCase());
										break;
									case "then": tokenlist.add(key.toUpperCase());
										break;
									case "else": tokenlist.add(key.toUpperCase());
										break;
									case "endif": tokenlist.add(key.toUpperCase());
										break;
									case "do": tokenlist.add(key.toUpperCase());
										break;
									case "while": tokenlist.add(key.toUpperCase());
										break;
									case "enddo": tokenlist.add(key.toUpperCase());
										break;
									case "end": tokenlist.add(key.toUpperCase());
										break;
									case "case": tokenlist.add(key.toUpperCase());
										break;
									case "of": tokenlist.add(key.toUpperCase());
										break;
									case "AND": tokenlist.add(key);
										break;
									case "OR": tokenlist.add(key);
										break;
									default:
										tokenlist.add("ID[" + key + "]");
								}
								reader.reset();
							} else if (Character.isDigit(character)){
								while(Character.isDigit(character)){
									reader.mark(1);
									keyword.append(character);
									character = (char) reader.read();
								}
								tokenlist.add("CONST[" + keyword.toString() + "]");
								reader.reset();
							} else {
								tokenlist.add("SCANNER_ERROR");
								error = true;
							}
					}
				}
			}
			reader.close();
	}
	
	public static String currentToken(){
		String token = tokenlist.peekFirst();
		if(token == null){
			token = "%SYNTAX%ERROR%";
		}
		return token;
	}
	
	public static void nextToken(){
		tokenlist.pop();
	}
	
	public void print(){
		if(error){
			System.out.println("ERROR: Invalid token in token stream");
		} else {
			for(String token : tokenlist){
				System.out.print(token + " ");
			}
		}
	}
}
