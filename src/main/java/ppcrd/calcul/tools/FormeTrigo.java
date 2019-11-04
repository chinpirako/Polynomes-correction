package ppcrd.calcul.tools;

import ppcrd.calcul.model.numbers.Complexe;
import ppcrd.calcul.model.numbers.Nombre;
import ppcrd.calcul.model.numbers.Reel;

public class FormeTrigo {
	private double rayon;
	private double angle;

	public FormeTrigo(double rayon, double angle) {
		super();
		this.angle = angle % (2 * Math.PI);
		this.rayon = rayon;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public Nombre convertToAlgebraic() {
		if (this.angle == 0) {
			return new Reel(this.rayon);
		}

		if (this.angle == Math.PI || this.angle == -Math.PI) {
			return new Reel(-this.rayon);
		}

		return new Complexe(this.rayon * Math.cos(this.angle), this.rayon * Math.sin(this.angle));
	}

	@Override
	public String toString() {
		if (this.angle == Math.PI || this.angle == -Math.PI) {
			return Double.toString(-this.rayon);
		}

		if (this.angle == 0) {
			return Double.toString(this.rayon);
		}

		String result;
		result = Double.toString(this.rayon) + "*e^(" + Double.toString(angle) + "i)";

		return result;
	}
}
