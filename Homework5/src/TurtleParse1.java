import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TurtleParse1 {
	static HashMap<String, Integer> variables = new HashMap();
	static ArrayList<String> commands = new ArrayList<String>();
	static ArrayList<String> runStrings = new ArrayList<String>();
	static ArrayList<Integer> values = new ArrayList<Integer>();
	static DrawableTurtle turtle = new DrawableTurtle();
	static int index = 0;
	/**
	* @pre No conditions needed in the arguments
	* @post will return a drawing of the turtle commands
	 */
	public static void main(String[] args) throws FileNotFoundException {
		read("testProgramStep1.txt");
//		read("testProgramStep2.txt");
//		read("testProgramStep3.txt:");
		turtle.draw();
	}
	/**
	* @Pre Requires a file that is in *.txt format that is of valid turtle syntax.
	* @Post will read all the text within the files and break it into chunks to be handled by the rest of the code. 
	* @return nothing
	 */
	static void read(String filename) throws FileNotFoundException {
		Scanner s = new Scanner(new File(filename));
		while(s.hasNext()) {
			commands.add(s.next());
		}
		program();
		
	}
	/**
	* @pre requires valid turtle syntax.
	* @post will send all info to the block
	 */
	static private void program() {
		block();
	}
	/**
	* @pre Requires that the file begin with the phrase "begin" and end with the phrase "end"
	* @post will begin processing the statements
	 */
	static private void block() {
		if(commands.get(index).equals("begin")) {
			index++;
			statementList();	
		}
		else if(commands.get(index).equals("end")) {
			index++;
		}
		
	}
	/**
	* @pre Requires that the file begin or end with end. 
	* @post will call statement get all phrases within the actual command section of the Turtle syntax
	 */
	static private void statementList() {
		if(commands.get(index).equals("forward") || commands.get(index).equals("turn") || commands.get(index).equals("loop")) {
			statement();
			statementList();
		}
	}
	/**
	* @pre variable value must be in the hashmap and loop must have something to execute
	* @post will add the command the correct amount of times to the list of operations to be done on the Turtle.
	 */
	static private void statement() {
		if(commands.get(index).equals("forward") || commands.get(index).equals("turn")) {
			command();
		}
	}
	/**
	* @pre has a list of commands in the list that are valid and all values to be executed are valid. 
	* @post will make the turtle do the moves that are required. 
	 */
	static private void command() {
		if(commands.get(index).equals("forward")) {
			index++;
			turtle.forward(Integer.parseInt(commands.get(index)));
		}
		else {
			index++;
			turtle.turn(Integer.parseInt(commands.get(index)));
		}
		index++;
	}
}