// Name: Qiuchen Zhang
// AndrewId: qiuchenz

package lab3;

public class Fraction {
	int numerator;
	int denominator;
	
	Fraction(){
		this.numerator = 1;
		this.denominator = 1;
	}
	
	Fraction(int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	@Override
	public String toString() {
		return "" + numerator + "/" + denominator;
	}
	
	double toDecimal() {
		return (double)numerator / (double)denominator;
	}
	
	Fraction add(Fraction f) {
		int newDenominator = this.denominator * f.denominator;
		int newNumerator = this.numerator * f.denominator + this.denominator * f.numerator;
		int gcd = findGCD(newNumerator, newDenominator);
		return new Fraction(newNumerator / gcd, newDenominator / gcd);
	}
	
	int findGCD(int numerator, int denominator) {
		if (numerator == 0)
			return 1;
		else if (denominator == 0)
			return numerator;
		else {
			return findGCD(denominator, numerator % denominator);
		}
	}
}
