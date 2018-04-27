import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class TurtleParse2Test {

	Point testTurtlePosition;
	Point realTurtlePosition;
	@Before
	public void setUpTestTurtle() throws FileNotFoundException {
		TurtleParse2.read("testProgramStep2.txt");
		TurtleParse2.turtle.draw();
		testTurtlePosition = TurtleParse2.turtle.currentPosition;
	}
	
	@Before
	public void setUpRealTurtle() {
		DrawableTurtle realTurtle = new DrawableTurtle();
		realTurtle.forward(10);
		realTurtle.turn(90);
		for(int i = 0; i<4; i++) {
			realTurtle.forward(40);
			realTurtle.turn(90);
		}
		realTurtle.turn(60);
		realTurtle.turn(60);
		realTurtle.forward(100);
		realTurtle.draw();
		realTurtlePosition = realTurtle.currentPosition;
	}
	
	@Test
	public void Step2Test() {
		assertTrue(testTurtlePosition.x==realTurtlePosition.x);
		assertTrue(testTurtlePosition.y==realTurtlePosition.y);	
	}
}
