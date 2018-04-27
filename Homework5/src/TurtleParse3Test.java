import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class TurtleParse3Test {


	Point testTurtlePosition;
	Point realTurtlePosition;
	@Before
	public void setUpTestTurtle() throws FileNotFoundException {
		TurtleParse3.read("testProgramStep3.txt");
		TurtleParse3.turtle.draw();
		testTurtlePosition = TurtleParse3.turtle.currentPosition;
	}
	
	@Before
	public void setUpRealTurtle() {
		DrawableTurtle realTurtle = new DrawableTurtle();
		realTurtle.forward(10);
		realTurtle.turn(90);
		for(int i = 0; i<4; i++) {
			realTurtle.forward(40);
			realTurtle.turn(60);
		}
		realTurtle.turn(90);
		realTurtle.turn(90);
		realTurtle.forward(40);
		realTurtle.draw();
		realTurtlePosition = realTurtle.currentPosition;
	}
	
	@Test
	public void Step3Test() {
		assertTrue(testTurtlePosition.x==realTurtlePosition.x);
		assertTrue(testTurtlePosition.y==realTurtlePosition.y);	
	}
}
