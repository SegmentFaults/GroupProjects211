import org.junit.*;

import junit.framework.TestCase;

public class ComplexTest extends TestCase {

	// Equivalence partitioning:
	private Complex positive = new Complex(5.0f, 3.0f);
	private Complex positive2 = new Complex(3.0f,1.0f);
	private Complex negative = new Complex(-2.0f, -4.0f);
	private Complex negative2 = new Complex(-4.0f, -5.0f);

	// Boundary values:
	private Complex zero = new Complex(0.0f, 0.0f);
	private Complex max = new Complex(Float.MAX_VALUE, Float.MAX_VALUE);
	private Complex min = new Complex(Float.MIN_VALUE, Float.MIN_VALUE);
	
	@Test
	public void add_equivalencePartitioning() {
		// positive + positive
		assertEquals(10.0f, positive.add(positive).getReal());
		assertEquals(6.0f, positive.add(positive).getImag());
		// negative + negative
		assertEquals(-4.0f, negative.add(negative).getReal());
		assertEquals(-8.0f, negative.add(negative).getImag());
		// positive + negative
		assertEquals(3.0f, positive.add(negative).getReal());
		assertEquals(-1.0f, positive.add(negative).getImag());
	}
	
	@Test
	public void add_boundaryValue() {
		// add positive to zero
		assertEquals(5.0f, zero.add(positive).getReal());
		assertEquals(3.0f, zero.add(positive).getImag());
		// add zero to negative
		assertEquals(-2.0f, negative.add(zero).getReal());
		assertEquals(-4.0f, negative.add(zero).getImag());

		// add zero and zero
		// ---asdf
		// add max + max
		// ---asdf
		// add max + min
		// --asdf
	}
	
	@Test
	public void subtract_equivalencePartitioning() {
		// positive - positive
		assertEquals(2.0f, positive.subtract(positive2).getReal());
		assertEquals(2.0f, positive.subtract(positive2).getImag());
		// negative - negative
		assertEquals(-6.0f, negative.subtract(negative2).getReal());
		assertEquals(-9.0f, negative.subtract(negative2).getImag());
		// positive - negative
		assertEquals(7.0f, positive.subtract(negative).getReal());
		assertEquals(7.0f, positive.subtract(negative).getImag());
	}
	
	@Test
	public void subtract_boundaryValue() {
		// subtract zero by positive
		assertEquals(-5.0f, zero.subtract(positive).getReal());
		assertEquals(-3.0f, zero.subtract(positive).getImag());
		// subtract negative by zero
		assertEquals(-2.0f, negative.subtract(zero).getReal());
		assertEquals(-4.0f, negative.subtract(zero).getImag());

		// subtract zero and zero
		// ---asdf
		// subtract max + max
		// ---asdf
		// subtract max + min
		// --asdf
	}
	
	@Test
	public void multiply_equivalencePartitioning() {
		// multiply positive and positive
		assertEquals(15.0f, positive.multiply(positive2).getReal());
		assertEquals(15.0f, positive.multiply(positive2).getImag());
		// multiply negative and negative
		assertEquals(8.0f, negative.multiply(negative2).getReal());
		assertEquals(20.0f, negative.multiply(negative2).getImag());
		// positive * negative
		assertEquals(-10.0f, positive.multiply(negative).getReal());
		assertEquals(-12.0f, positive.multiply(negative).getImag());
	}
	
	@Test
	public void multiply_boundaryValue() {
		// multiply zero by positive
		assertEquals(0.0f, zero.multiply(positive).getReal());
		assertEquals(0.0f, zero.multiply(positive).getImag());
		// multiply negative by zero
		assertEquals(0.0f, negative.multiply(zero).getReal());
		assertEquals(0.0f, negative.multiply(zero).getImag());

		// multiply zero and zero
		// ---asdf
		// multiply max + max
		// ---asdf
		// multiply max + min
		// --asdf
	}
	
	@Test
	public void divide_equivalencePartitioning() {
		// check for allowable error
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
