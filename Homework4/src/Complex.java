
public class Complex {
	
	private float real;
	private float imag;
	
	public Complex() {
		
	}
	public Complex(float real, float imag) {
		this.real = real;
		this.imag = imag;
	}
	public Complex add(Complex other) {
	    float newReal = (this.real + other.getReal());
	    float newImag = (this.imag + other.getImag());
	    return new Complex(newReal, newImag);
	}
	public Complex subtract(Complex other) {
        float newReal = (this.real - other.getReal());
        float newImag = (this.imag - other.getImag());
        return new Complex(newReal, newImag);
	}
	public Complex multiply(Complex other) {
		float newReal = (this.real * other.getReal()) - (this.imag * other.getImag());
		float newImag = (this.real * other.getImag()) + (this.imag * other.getReal());
        return new Complex(newReal, newImag);
	}
	public Complex divide(Complex other) {
		 return this.multiply(other.reciprocal());
	}
	public String toString() {
		return this.real + " + " + this.imag + "i";
	}
	public Complex reciprocal() {
	    float scale = this.real * this.real + this.imag * this.imag;
	    return new Complex(this.real/scale, -this.imag/scale);
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
