import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class TurtleParse1Test {

	Point testTurtlePosition;
	Point realTurtlePosition;
	@Before
	public void setUpTestTurtle() throws FileNotFoundException {
		TurtleParse1.read("testProgramStep1.txt");
		TurtleParse1.turtle.draw();
		testTurtlePosition = TurtleParse1.turtle.currentPosition;
	}
	
	@Before
	public void setUpRealTurtle() {
		DrawableTurtle realTurtle = new DrawableTurtle();
		realTurtle.forward(10);
		realTurtle.turn(90);
		realTurtle.forward(10);
		realTurtle.turn(90);
		realTurtle.forward(10);
		realTurtle.turn(90);
		realTurtle.forward(10);
		realTurtle.turn(90);
		realTurtle.draw();
		realTurtlePosition = realTurtle.currentPosition;
	}
	
	@Test
	public void Step1Test() {
		assertTrue(testTurtlePosition.x==realTurtlePosition.x);
		assertTrue(testTurtlePosition.y==realTurtlePosition.y);	
	}

}
