package fr.imt.albi.polynomes.model.equations;

import fr.imt.albi.polynomes.model.numbers.Nombre;
import fr.imt.albi.polynomes.model.numbers.Reel;

public class FirstDegreeEquations {
	private Nombre coefficientA;
	private Nombre coefficientB;

	public FirstDegreeEquations(Nombre coefficientA) {
		this(coefficientA, new Reel(0));
	}

	public FirstDegreeEquations(Nombre coefficientA, Nombre coefficientB) {
		this.coefficientA = coefficientA;
		this.coefficientB = coefficientB;
	}

	public Nombre getCoefficientA() {
		return coefficientA;
	}

	public void setCoefficientA(Nombre coefficientA) {
		this.coefficientA = coefficientA;
	}

	public Nombre getCoefficientB() {
		return coefficientB;
	}

	public void setCoefficientB(Nombre coefficientB) {
		this.coefficientB = coefficientB;
	}

	public String toString() {
		return "y = " + this.coefficientA + "x + " + this.coefficientB;
	}

	public Nombre solve() throws Exception {
		return Nombre.Divide(coefficientB, coefficientA).getNegativeNumber();
	}
}
