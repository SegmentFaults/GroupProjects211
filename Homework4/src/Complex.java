
public class Complex {
	
	private float real;
	private float imag;
	
	public Complex() {
		
	}
	public Complex(float x, float y) {
		this.real = x;
		this.imag = y;
	}
	public Complex add(Complex other) {
	    this.real = (this.real + other.getReal());
	    this.imag = (this.imag + other.getImag());
	    return this;
	}
	public Complex subtract(Complex other) {
        this.real = (this.real - other.getReal());
        this.imag = (this.imag - other.getImag());
        return this;
	}
	public Complex multiply(Complex other) {
		
	}
	public Complex divide(Complex other) {
		 
	}
	public Complex toString() {
		
	}
	public float getReal() {
		return this.real;
	}
	public void setReal(float newReal) {
		this.real = newReal;
	}
	public float getImag() {
		return this.imag;
	}
	public void setImag(float newImag) {
		this.imag = newImag;
	}
}
