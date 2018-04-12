import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexTest {

	// Equivalence partitioning:
	private Complex positive = new Complex(5.0f, 3.0f);
	private Complex positive2 = new Complex(3.0f,1.0f);
	private Complex negative = new Complex(-2.0f, -4.0f);
	private Complex negative2 = new Complex(-4.0f, -5.0f);

	// Boundary values:
	private Complex zero = new Complex(0.0f, 0.0f);
	private Complex max = new Complex(Float.MAX_VALUE, Float.MAX_VALUE);
	private Complex min = new Complex(Float.MIN_VALUE, Float.MIN_VALUE);
	
	@SuppressWarnings("deprecation")
	@Test
	public void add_equivalencePartitioning() {
		// positive + positive
		assertEquals(10.0f, positive.add(positive).getReal(), 0.0001);
		assertEquals(6.0f, positive.add(positive).getImag(), 0.0001);
		// negative + negative
		assertEquals(-4.0f, negative.add(negative).getReal(), 0.0001);
		assertEquals(-8.0f, negative.add(negative).getImag(), 0.0001);
		// positive + negative
		assertEquals(3.0f, positive.add(negative).getReal(), 0.0001);
		assertEquals(-1.0f, positive.add(negative).getImag(), 0.0001);
	}
	
	@Test
	public void add_boundaryValue() {
		// add positive to zero
		assertEquals(5.0f, zero.add(positive).getReal(), 0.0001);
		assertEquals(3.0f, zero.add(positive).getImag(), 0.0001);
		// add zero to negative
		assertEquals(-2.0f, negative.add(zero).getReal(), 0.0001);
		assertEquals(-4.0f, negative.add(zero).getImag(), 0.0001);

		// add zero and zero
		assertEquals(0, zero.add(zero).getImag(), 0.0001);
		// add max + max
		assertEquals(Float.POSITIVE_INFINITY, max.add(max).getImag(), 0.0001);
		// add max + min
		assertEquals(3.4028234663852886E38f, max.add(min).getImag(), 0.0001);
	}
	
	@Test
	public void subtract_equivalencePartitioning() {
		// positive - positive
		assertEquals(2.0f, positive.subtract(positive2).getReal(), 0.0001);
		assertEquals(2.0f, positive.subtract(positive2).getImag(), 0.0001);
		// negative - negative
		assertEquals(2.0f, negative.subtract(negative2).getReal(), 0.0001);
		assertEquals(1.0f, negative.subtract(negative2).getImag(), 0.0001);
		// positive - negative
		assertEquals(7.0f, positive.subtract(negative).getReal(), 0.0001);
		assertEquals(7.0f, positive.subtract(negative).getImag(), 0.0001);
	}
	
	@Test
	public void subtract_boundaryValue() {
		// subtract zero by positive
		assertEquals(-5.0f, zero.subtract(positive).getReal(), 0.0001);
		assertEquals(-3.0f, zero.subtract(positive).getImag(), 0.0001);
		// subtract negative by zero
		assertEquals(-2.0f, negative.subtract(zero).getReal(), 0.0001);
		assertEquals(-4.0f, negative.subtract(zero).getImag(), 0.0001);

		// subtract zero and zero
		assertEquals(0.0f, zero.subtract(zero).getImag(), 0.0001);
		// subtract max - max
		assertEquals(0.0f, max.subtract(max).getImag(), 0.0001);
		// subtract max and min
		assertEquals(3.4028234663852886E38f, max.subtract(min).getImag(), 0.0001);
	}
	
	@Test
	public void multiply_equivalencePartitioning() {
		// multiply positive and positive
		assertEquals(12.0f, positive.multiply(positive2).getReal(), 0.0001);
		assertEquals(14.0f, positive.multiply(positive2).getImag(), 0.0001);
		// multiply negative and negative
		assertEquals(-12.0f, negative.multiply(negative2).getReal(), 0.0001);
		assertEquals(26.0f, negative.multiply(negative2).getImag(), 0.0001);
		// positive * negative
		assertEquals(2.0f, positive.multiply(negative).getReal(), 0.0001);
		assertEquals(-26.0f, positive.multiply(negative).getImag(), 0.0001);
	}
	
	@Test
	public void multiply_boundaryValue() {
		// multiply zero by positive
		assertEquals(0.0f, zero.multiply(positive).getReal(), 0.0001);
		assertEquals(0.0f, zero.multiply(positive).getImag(), 0.0001);
		// multiply negative by zero
		assertEquals(0.0f, negative.multiply(zero).getReal(), 0.0001);
		assertEquals(0.0f, negative.multiply(zero).getImag(), 0.0001);

		// multiply zero and zero
		assertEquals(0.0f, zero.multiply(zero).getImag(), 0.0001);
		// multiply max + max
		assertEquals(Float.POSITIVE_INFINITY, max.multiply(max).getImag(), 0.0001);
		// multiply max + min
		assertEquals(0.0f, max.multiply(min).getImag(), 0.0001);
	}
	
	@Test
	public void divide_equivalencePartitioning() {
		// check for allowable error
        // divide positive and positive
        assertEquals(1.8f, positive.divide(positive2).getReal(), .00001);
        assertEquals(0.4f, positive.divide(positive2).getImag(), .00001);
        // divide negative and negative
        assertEquals(.68293f, negative.divide(negative2).getReal(), 0.0001);
        assertEquals(.14634f, negative.divide(negative2).getImag(), 0.0001);
        // positive / negative
        assertEquals(-1.1f, positive.divide(negative).getReal(), .00001);
        assertEquals(0.7f, positive.divide(negative).getImag(), .00001);
	}
	
	@Test
	public void divide_boundaryValue() {
        // divide zero by positive
        assertEquals(0.0f, zero.divide(positive).getReal(), 0.0001);
        assertEquals(0.0f, zero.divide(positive).getImag(), 0.0001);

        // multiply max + max
        assertEquals(0.0f, max.divide(max).getImag(), 0.0001);
        // multiply max + min
        assertEquals(Float.NaN, max.divide(min).getImag(), 0.0001);
	}
	
	@Test
	public void toString_correctFunction() {
		assertEquals(new Complex(2, 3).toString(), "2.0 + 3.0i");
	}
}
