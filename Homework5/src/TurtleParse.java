import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TurtleParse {
	static HashMap<String, Integer> variables = new HashMap();
	static ArrayList<String> commands = new ArrayList<String>();
	static ArrayList<String> runStrings = new ArrayList<String>();
	static ArrayList<Integer> values = new ArrayList<Integer>();
	public static void main(String[] args) {
		read("testProgramStep1.txt");
		read("testProgramStep2.txt");
		read("testProgramStep3.txt:");
	}
	static private void read(String filename) {
		Scanner s = new Scanner(filename);
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
				//push to forward
			}
			else if (commands.get(0).equals("turn")) {
				//push to turn
			}
			else if (commands.get(0).equals("loop")) {
				//get the value of the loop
				//ignore the begin statement and remove it
				//call parse commands that many time
			}
			commands.remove(0);
			commands.remove(0);
		}
		if (commands.get(0).equals("end")) {
			// good
		}
		else {
			//fail
		}
	}
}
