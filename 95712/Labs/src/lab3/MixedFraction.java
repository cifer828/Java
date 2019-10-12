// Name: Qiuchen Zhang
// AndrewId: qiuchenz

package lab3;

public class MixedFraction extends Fraction{
	int naturalNumber;
	
	MixedFraction(int naturalNumber, int numerator, int denominator) {
		this.naturalNumber = naturalNumber;
		this.numerator = numerator;
		this.denominator = denominator;
	}

	@Override
	public String toString() {
		return "" + naturalNumber + " " + super.toString();
	}
	
	@Override
	double toDecimal() {
		return super.toDecimal() + naturalNumber;
	}
	
	Fraction toFraction() {
		return new Fraction(naturalNumber * denominator + numerator, denominator);
	}

	Fraction add(MixedFraction mf) {
		return this.toFraction().add(mf.toFraction());
	}
}
