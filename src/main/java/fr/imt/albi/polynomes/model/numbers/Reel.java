package fr.imt.albi.polynomes.model.numbers;

public class Reel extends Nombre {
	public Reel() {
		super();
	}

	public Reel(double partieReelle) {
		super();
		this.setPartieReelle(partieReelle);
		this.setPartieImaginaire(0);
	}
	
	public Reel(Reel reel) {
		super();
		this.setPartieReelle(reel.getPartieReelle());
	}

	@Override
	public String toString() {
		return Double.toString(this.getPartieReelle());
	}

	@Override
	public Nombre getNegativeNumber() {
		return new Reel(-this.getPartieReelle());
	}
}
