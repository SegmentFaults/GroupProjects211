import org.junit.*;

import junit.framework.TestCase;

public class ComplexTest extends TestCase {

	private Complex positive = new Complex(5.0f, 3.0f);
	private Complex zero = new Complex(0.0f, 0.0f);
	private Complex negative = new Complex(-2.0f, -4.0f);
	
	@Test
	public void add_equivalencePartitioning() {
		assertEquals(3.0f, positive.add(negative).getReal());
		assertEquals(-1.0f, positive.add(negative).getImag());
		assertEquals(5.0f, zero.add(positive).getReal());
		assertEquals(3.0f, zero.add(positive).getImag());
		assertEquals(-2.0f, negative.add(zero).getReal());
		assertEquals(-4.0f, negative.add(zero).getImag());
	}
	
	@Test
	public void add_boundaryValue() {
		assertEquals();
	}
	
	@Test
	public void subtract_equivalencePartitioning() {
		assertEquals();
	}
	
	@Test
	public void subtract_boundaryValue() {
		assertEquals();
	}
	
	@Test
	public void multiply_equivalencePartitioning() {
		assertEquals();
	}
	
	@Test
	public void multiply_boundaryValue() {
		assertEquals();
	}
	
	@Test
	public void divide_equivalencePartitioning() {
		assertEquals();
	}
	
	@Test
	public void divide_boundaryValue() {
		assertEquals();
	}
	
	@Test
	public void toString_correctFunction() {
		assertEquals();
	}
}
