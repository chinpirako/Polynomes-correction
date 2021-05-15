package fr.imt.albi.polynomes.model.equations;

import java.util.ArrayList;
import java.util.List;

import fr.imt.albi.polynomes.model.numbers.Complexe;
import fr.imt.albi.polynomes.model.numbers.Nombre;
import fr.imt.albi.polynomes.model.numbers.Reel;

public class SecondDegreeEquations {
	private Nombre coefficientA;
	private Nombre coefficientB;
	private Nombre coefficientC;

	public SecondDegreeEquations(Nombre coefficientA) {
		this(coefficientA, new Reel(0));
	}

	public SecondDegreeEquations(Nombre coefficientA, Nombre coefficientB) {
		this(coefficientA, coefficientB, new Reel(0));
	}

	public SecondDegreeEquations(Nombre coefficientA, Nombre coefficientB, Nombre coefficientC) {
		this.coefficientA = coefficientA;
		this.coefficientB = coefficientB;
		this.coefficientC = coefficientC;
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

	public Nombre getCoefficientC() {
		return coefficientC;
	}

	public void setCoefficientC(Nombre coefficientC) {
		this.coefficientC = coefficientC;
	}

	public List<Nombre> solve() throws Exception {
		List<Nombre> result = new ArrayList<Nombre>();
		if (this.coefficientA.isZero()) {
			FirstDegreeEquations actualEquation = new FirstDegreeEquations(this.coefficientA, this.coefficientC);
			result.add(actualEquation.solve());
		}

		Nombre discriminant = this.getDiscriminant();
		if (discriminant.isZero()) {
			result.add(Nombre.Divide(this.coefficientB.getNegativeNumber(), Nombre.Multiply(this.coefficientA, new Reel(2))));
		} else if (discriminant instanceof Reel && discriminant.getPartieReelle() < 0) {
			Nombre twoA = Nombre.Multiply(this.getCoefficientA(), new Reel(2));
			Nombre minusBOverA = Nombre.Divide(this.coefficientB.getNegativeNumber(), twoA);
			Complexe iTimesDiscriminant = (Complexe) Nombre.Multiply(Nombre.SquareRoot(discriminant.getNegativeNumber()), Complexe.I);
			Complexe iTimesDiscriminantOverA = (Complexe) Nombre.Divide(iTimesDiscriminant, twoA);

			Complexe firstRoot = (Complexe) Nombre.Subtract(minusBOverA, iTimesDiscriminantOverA);
			Complexe secondRoot = (Complexe) Nombre.Subtract(minusBOverA, iTimesDiscriminantOverA.getNegativeNumber());
			
			result.add(firstRoot);
			result.add(secondRoot);
		} else if (discriminant instanceof Reel && discriminant.getPartieReelle() > 0) {
			Reel twoA = (Reel) Nombre.Multiply(this.getCoefficientA(), new Reel(2));
			Reel minusBOverA = (Reel) Nombre.Divide(this.coefficientB.getNegativeNumber(), twoA);
			Reel discriminantOverA = (Reel) Nombre.Divide(Nombre.SquareRoot(discriminant), twoA);

			Reel firstRoot = (Reel) Nombre.Subtract(minusBOverA, discriminantOverA);
			Reel secondRoot = (Reel) Nombre.Add(minusBOverA, discriminantOverA);
			
			result.add(firstRoot);
			result.add(secondRoot);
		} else if (discriminant instanceof Complexe) {
			Nombre twoA =  Nombre.Multiply(this.getCoefficientA(), new Reel(2));
			Nombre minusBOverA = Nombre.Divide(this.coefficientB.getNegativeNumber(), twoA);
			Complexe discriminantOverA = (Complexe) Nombre.Divide(Nombre.SquareRoot(discriminant), twoA);

			Complexe firstRoot = (Complexe) Nombre.Subtract(minusBOverA, discriminantOverA);
			Complexe secondRoot = (Complexe) Nombre.Add(minusBOverA, discriminantOverA);
			
			result.add(firstRoot);
			result.add(secondRoot);
		}

		return result;
	}

	public Nombre getDiscriminant() {
		return Nombre.Subtract(Nombre.SquarePower(this.coefficientB), Nombre.Multiply(new Reel(4), Nombre.Multiply(coefficientA, coefficientC)));
	}

	public String toString() {
		return "y = " + this.coefficientA + "x^2 + " + this.coefficientB + "x + " + this.coefficientC;
	}
}