package ppcrd.calcul.model.equations;

import java.util.ArrayList;
import java.util.List;

import ppcrd.calcul.model.numbers.Complexe;
import ppcrd.calcul.model.numbers.Nombre;
import ppcrd.calcul.model.numbers.Reel;

public class SecondDegreeEquations {
	private Nombre a;
	private Nombre b;
	private Nombre c;

	public SecondDegreeEquations(Nombre a) {
		this(a, new Reel(0));
	}

	public SecondDegreeEquations(Nombre a, Nombre b) {
		this(a, b, new Reel(0));
	}

	public SecondDegreeEquations(Nombre a, Nombre b, Nombre c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Nombre getA() {
		return a;
	}

	public void setA(Nombre a) {
		this.a = a;
	}

	public Nombre getB() {
		return b;
	}

	public void setB(Nombre b) {
		this.b = b;
	}

	public Nombre getC() {
		return c;
	}

	public void setC(Nombre c) {
		this.c = c;
	}

	public List<Nombre> solve() throws Exception {
		List<Nombre> result = new ArrayList<Nombre>();
		if (this.a.isZero()) {
			FirstDegreeEquations actualEquation = new FirstDegreeEquations(this.a, this.c);
			result.add(actualEquation.solve());
		}

		Nombre discriminant = this.getDiscriminant();
		if (discriminant.isZero()) {
			result.add(Nombre.Divide(this.b.getNegativeNumber(), Nombre.Multiply(this.a, new Reel(2))));
		} else if (discriminant instanceof Reel && discriminant.getPartieReelle() < 0) {
			Nombre twoA = Nombre.Multiply(this.getA(), new Reel(2));
			Nombre minusBOverA = Nombre.Divide(this.b.getNegativeNumber(), twoA);
			Complexe iTimesDiscriminant = (Complexe) Nombre.Multiply(Nombre.SquareRoot(discriminant.getNegativeNumber()), Complexe.I);
			Complexe iTimesDiscriminantOverA = (Complexe) Nombre.Divide(iTimesDiscriminant, twoA);

			Complexe firstRoot = (Complexe) Nombre.Subtract(minusBOverA, iTimesDiscriminantOverA);
			Complexe secondRoot = (Complexe) Nombre.Subtract(minusBOverA, iTimesDiscriminantOverA.getNegativeNumber());
			
			result.add(firstRoot);
			result.add(secondRoot);
		} else if (discriminant instanceof Reel && discriminant.getPartieReelle() > 0) {
			Reel twoA = (Reel) Nombre.Multiply(this.getA(), new Reel(2));
			Reel minusBOverA = (Reel) Nombre.Divide(this.b.getNegativeNumber(), twoA);
			Reel discriminantOverA = (Reel) Nombre.Divide(Nombre.SquareRoot(discriminant), twoA);

			Reel firstRoot = (Reel) Nombre.Subtract(minusBOverA, discriminantOverA);
			Reel secondRoot = (Reel) Nombre.Add(minusBOverA, discriminantOverA);
			
			result.add(firstRoot);
			result.add(secondRoot);
		} else if (discriminant instanceof Complexe) {
			Nombre twoA =  Nombre.Multiply(this.getA(), new Reel(2));
			Nombre minusBOverA = Nombre.Divide(this.b.getNegativeNumber(), twoA);
			Complexe discriminantOverA = (Complexe) Nombre.Divide(Nombre.SquareRoot(discriminant), twoA);

			Complexe firstRoot = (Complexe) Nombre.Subtract(minusBOverA, discriminantOverA);
			Complexe secondRoot = (Complexe) Nombre.Add(minusBOverA, discriminantOverA);
			
			result.add(firstRoot);
			result.add(secondRoot);
		}

		return result;
	}

	public Nombre getDiscriminant() {
		return Nombre.Subtract(Nombre.SquarePower(this.b), Nombre.Multiply(new Reel(4), Nombre.Multiply(a, c)));
	}

	public String toString() {
		return "y = " + this.a + "x^2 + " + this.b + "x + " + this.c;
	}
}