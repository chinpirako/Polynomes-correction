package ppcrd.calcul.model.equations;

import ppcrd.calcul.model.numbers.Nombre;
import ppcrd.calcul.model.numbers.Reel;

public class FirstDegreeEquations {
	private Nombre a;
	private Nombre b;

	public FirstDegreeEquations(Nombre a) {
		this(a, new Reel(0));
	}

	public FirstDegreeEquations(Nombre a, Nombre b) {
		this.a = a;
		this.b = b;
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

	public String toString() {
		return "y = " + this.a + "x + " + this.b;
	}

	public Nombre solve() throws Exception {
		return Nombre.Divide(b, a).getNegativeNumber();
	}
}
