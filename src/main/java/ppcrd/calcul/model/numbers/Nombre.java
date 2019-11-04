package ppcrd.calcul.model.numbers;

import ppcrd.calcul.tools.FormeTrigo;

/**
 *
 */
public abstract class Nombre {
	private double partieReelle;
	private double partieImaginaire;

	public double getPartieReelle() {
		return partieReelle;
	}

	public void setPartieReelle(double partieReelle) {
		this.partieReelle = partieReelle;
	}

	public double getPartieImaginaire() {
		return partieImaginaire;
	}

	public void setPartieImaginaire(double partieImaginaire) {
		this.partieImaginaire = partieImaginaire;
	}

	public double getModule() {
		return Math.sqrt(Math.pow(this.getPartieReelle(), 2) + Math.pow(this.getPartieImaginaire(), 2));
	}

	public double getArgument() {
		return Math.atan2(this.getPartieImaginaire(), this.getPartieReelle());
	}

	public FormeTrigo getTrigonometicForm() {
		return new FormeTrigo(this.getModule(), this.getArgument());
	}

	public static Nombre Add(Nombre a, Nombre b) {
		Nombre result;
		if (a.getPartieImaginaire() != 0 || b.getPartieImaginaire() != 0) {
			result = new Complexe(a.getPartieReelle() + b.getPartieReelle(),
					a.getPartieImaginaire() + b.getPartieImaginaire());
		} else {
			result = new Reel(a.getPartieReelle() + b.getPartieReelle());
		}

		return result;
	}

	public static Nombre Subtract(Nombre a, Nombre b) {
		return Nombre.Add(a, b.getNegativeNumber());
	};

	public static Nombre Multiply(Nombre a, Nombre b) {
		Nombre result;
		if (a.getPartieImaginaire() != 0 || b.getPartieImaginaire() != 0) {
			FormeTrigo temp = new FormeTrigo(a.getModule() * b.getModule(), a.getArgument() + b.getArgument());
			result = temp.convertToAlgebraic();
		} else {
			result = new Reel(a.getPartieReelle() * b.getPartieReelle());
		}

		return result;
	};

	public static Nombre Divide(Nombre a, Nombre b) throws Exception {
		if (b.getModule() == 0) {
			throw new Exception("b cannot have a zero module.");
		}

		Nombre result;
		if (a.getPartieImaginaire() != 0 || b.getPartieImaginaire() != 0) {
			FormeTrigo temp = new FormeTrigo(a.getModule() / b.getModule(), a.getArgument() - b.getArgument());
			result = temp.convertToAlgebraic();
		} else {
			result = new Reel(a.getPartieReelle() / b.getPartieReelle());
		}

		return result;
	};

	public static Nombre SquarePower(Nombre a) {
		return Nombre.Multiply(a, a);
	}

	public static Nombre SquareRoot(Nombre a) throws Exception {
		if (a.getModule() == 0) {
			throw new Exception("a cannot have a zero module.");
		}

		Nombre result;
		if (a.getPartieImaginaire() != 0) {
			FormeTrigo temp = new FormeTrigo(Math.sqrt(a.getModule()), a.getArgument() / 2);
			result = temp.convertToAlgebraic();
		} else {
			result = new Reel(Math.sqrt(a.getModule()));
		}
		
		return result;
	}

	public boolean isZero() {
		return this.getModule() == 0;
	}

	public abstract Nombre getNegativeNumber();

	@Override
	public abstract String toString();
}
