Clement Lu
CSE 3341 MWF 1:50

Assign.java - parses the ASSIGN non-terminal
Case.java - parses the CASE non-terminal
Caselet.java - parses the CASELET non-terminal
CaseletList.java - parses the CASELETLIST non-terminal
Cmpr.java - parses the CMPR non-terminal
CmprOp.java - parses the CMPROP non-terminal
Cond.java - parses the COND non-terminal
Decl.java - parses the DECL non-terminal
DeclSeq.java - parses the DECLSEQ non-terminal
Expr.java - parses the EXPR non-terminal
Factor.java - parses the FACTOR non-terminal
IDList.java - parses the IDLIST non-terminal
IfLoop.java - parses the IF non-terminal
Input.java - parses the INPUT non-terminal
Interpreter.java - *THIS IS THE MAIN PROGRAM FILE*
IntList.java - parses the INTLIST non-terminal
Loop.java - parses the LOOP non-terminal
MyScanner.java - this is the scanner that scans the input file for tokens and
                 builds the token stream
Output.java - parses the OUTPUT non-terminal
Prog.java - parses the PROGRAM non-terminal
Stmt.java - parses the STMT non-terminal
StmtSeq.java - parses the STMTSEQ non-terminal
Term.java - parses the TERM non-terminal


\\\\\\****How to Compile****//////

1. cd to parent directory of folder containing all of the .java files
	e.g. "~/CSE3341/"
2. run this command: "javac folder_name/Interpreter.java"
	e.g. "javac ~/CSE3341/interpreter/Interpreter.java" (if all of the .java files are in the interpreter folder under the CSE3341 directory)
3. to execute, run: "java folder_name/Interpreter arg0 arg1"
	e.g. "java interpreter/Interpreter weak_tests/t1.code weak_tests/t1.data"

*NOTE*: BE SURE TO COMPILE FROM THE PARENT DIRECTORY OF THE FOLDER WITH ALL OF THE JAVA FILES AND NOT WITHIN THE FOLDER ITSELF