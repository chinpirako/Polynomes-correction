package fr.imt.albi.polynomes.main;

import fr.imt.albi.polynomes.model.equations.SecondDegreeEquations;
import fr.imt.albi.polynomes.model.numbers.Complexe;
import fr.imt.albi.polynomes.model.numbers.Nombre;
import fr.imt.albi.polynomes.model.numbers.Reel;

public class Main {
	public static void main(String[] args) throws Exception {
		Nombre coefficientA = new Reel(1);
		Nombre coefficientB = new Reel(3);
		Nombre coefficientC = new Reel(1);

		System.out.println(new SecondDegreeEquations(coefficientA, coefficientB, coefficientC).solve());

		coefficientA = new Reel(3);
		coefficientB = new Reel(3);
		coefficientC = new Reel(1);

		System.out.println(new SecondDegreeEquations(coefficientA, coefficientB, coefficientC).solve());

		coefficientA = new Reel(1);
		coefficientB = new Reel(2);
		coefficientC = new Reel(1);

		System.out.println(new SecondDegreeEquations(coefficientA, coefficientB, coefficientC).solve());

		coefficientA = new Reel(1);
		coefficientB = new Complexe(2, 1);
		coefficientC = new Reel(1);

		System.out.println(new SecondDegreeEquations(coefficientA, coefficientB, coefficientC).solve());
	}
}
