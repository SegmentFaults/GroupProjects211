import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TurtleParse3 {
	private static HashMap<String, Integer> variables = new HashMap<String, Integer>();
	private static ArrayList<String> commands = new ArrayList<>();
	static ArrayList<String> runStrings = new ArrayList<>();
	static ArrayList<Integer> values = new ArrayList<Integer>();
	static DrawableTurtle turtle = new DrawableTurtle();
	private static int index = 0;
	public static void main(String[] args) throws FileNotFoundException {
//		read("testProgramStep1.txt");
//		read("testProgramStep2.txt");
		read("testProgramStep3.txt");
		turtle.draw();
	}
	static void read(String filename) throws FileNotFoundException {
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
		if(!(commands.get(index).equals("begin") || commands.get(index).equals("end"))) {
			statement();
			statementList();
		}
	}
	static private void statement() {
		if(commands.get(index).equals("forward") || commands.get(index).equals("turn")) {
			command();
		}
		else if (commands.get(index).equals("loop")){
			loop();
		}
		else {
			assignment();
		}
	}

	static private void assignment() {
		if (commands.get(index + 1).equals("=") && Integer.parseInt(commands.get(index + 2)) >= 0){
			variables.put(commands.get(index), Integer.parseInt(commands.get(index + 2)));
		}
		index += 3; //skip over variable name, equals sign, and value
	}
	static private void loop() {
		index++;
		int loopCount;
		if (variables.containsKey(commands.get(index))){
		    loopCount = variables.get(commands.get(index));
        }
        else {
            loopCount = Integer.parseInt(commands.get(index));
        }
		index++;
		int loopBegin = index;
		for(int i = 0; i<loopCount-1; i++) {
			block();
			index = loopBegin;
		}
		block();
		index++;
	}
	static private void command() {
		if(commands.get(index).equals("forward")) {
			index++;
			if (variables.containsKey(commands.get(index))) {
			    turtle.forward(variables.get(commands.get(index)));
            }
            else {
                turtle.forward(Integer.parseInt(commands.get(index)));
            }
		}
		else {
			index++;
            if (variables.containsKey(commands.get(index))) {
                turtle.turn(variables.get(commands.get(index)));
            }
            else {
                turtle.turn(Integer.parseInt(commands.get(index)));
            }
		}
		index++;
	}
}