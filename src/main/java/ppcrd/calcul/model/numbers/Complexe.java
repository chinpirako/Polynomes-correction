package ppcrd.calcul.model.numbers;

public class Complexe extends Nombre {

	public static final Complexe I = new Complexe(0, 1);

	public Complexe() {
		super();
	}

	public Complexe(double partieReelle, double partieImaginaire) {
		super();
		this.setPartieReelle(partieReelle);
		this.setPartieImaginaire(partieImaginaire);
	}

	public Complexe(Complexe complexe) {
		super();
		this.setPartieReelle(complexe.getPartieReelle());
		this.setPartieImaginaire(complexe.getPartieImaginaire());
	}

	@Override
	public String toString() {
		return Double.toString(getPartieReelle()) + (this.getPartieImaginaire() > 0 ? "+" : "")
				+ (this.getPartieImaginaire() != 0 ? Double.toString(getPartieImaginaire()) + "i" : "");
	}

	@Override
	public Nombre getNegativeNumber() {
		return new Complexe(-this.getPartieReelle(), -this.getPartieImaginaire());
	}

	public Complexe getConjugate() {
		return new Complexe(this.getPartieReelle(), -this.getPartieImaginaire());
	}
}
