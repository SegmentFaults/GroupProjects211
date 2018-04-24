import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TurtleParse {
	static HashMap<String, Integer> variables = new HashMap();
	static ArrayList<String> commands = new ArrayList<String>();
	static ArrayList<String> runStrings = new ArrayList<String>();
	static ArrayList<Integer> values = new ArrayList<Integer>();
	static DrawableTurtle turtle = new DrawableTurtle();
	public static void main(String[] args) throws FileNotFoundException {
//		read("testProgramStep1.txt");
		read("testProgramStep2.txt");
//		read("testProgramStep3.txt:");
		turtle.draw();
	}
	static private void read(String filename) throws FileNotFoundException {
		Scanner s = new Scanner(new File(filename));
		while(s.hasNext()) {
			commands.add(s.next());
		}
		startParse();

	}
	static private void startParse() {
		if(commands.get(0).equals("begin") && commands.get(commands.size()-1).equals("programEnd")){
			commands.remove(0);
			commands.remove(commands.size()-1);
		}
		else {
			//it's broken
			System.exit(0);
		}
		parseCommands();
	}
	static private void parseCommands() {
		while(commands.size() != 1) {
			// parse each separate command and translate it.
			if (commands.get(0).equals("forward")) {
				turtle.forward(Integer.parseInt(commands.get(1)));
			}
			else if (commands.get(0).equals("turn")) {
				turtle.turn(Double.parseDouble(commands.get(1)));
			}
			else if (commands.get(0).equals("loop")) {
				//get the value of the loop
				int loopCount = Integer.parseInt(commands.get(1));
				for(int i = 0; i<loopCount; i++) {
					parseCommands();
				}
			}
			commands.remove(0);
			commands.remove(0);
		}
		if (commands.get(0).equals("end")) {
			
		}
		else {
			//fail
		}
	}
}
