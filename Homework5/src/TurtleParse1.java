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
	public static void main(String[] args) throws FileNotFoundException {
		read("testProgramStep1.txt");
//		read("testProgramStep2.txt");
//		read("testProgramStep3.txt:");
		turtle.draw();
	}
	static private void read(String filename) throws FileNotFoundException {
		Scanner s = new Scanner(new File(filename));
		while(s.hasNext()) {
			commands.add(s.next());
		}
		program();
		
	}
	
	static private void program() {
		block();
	}
	
	static private void block() {
		if(commands.get(index).equals("begin")) {
			index++;
			statementList();	
		}
		else if(commands.get(index).equals("end")) {
			index++;
		}
		
	}
	static private void statementList() {
		if(commands.get(index).equals("forward") || commands.get(index).equals("turn") || commands.get(index).equals("loop")) {
			statement();
			statementList();
		}
	}
	static private void statement() {
		if(commands.get(index).equals("forward") || commands.get(index).equals("turn")) {
			command();
		}
	}

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
