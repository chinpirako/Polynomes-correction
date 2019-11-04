package ppcrd.calcul.main;

import ppcrd.calcul.model.equations.FirstDegreeEquations;
import ppcrd.calcul.model.equations.SecondDegreeEquations;
import ppcrd.calcul.model.numbers.Complexe;
import ppcrd.calcul.model.numbers.Nombre;
import ppcrd.calcul.model.numbers.Reel;
import ppcrd.calcul.tools.FormeTrigo;

public class Main {
	public static void main(String[] args) throws Exception {
		Nombre t = new Reel(1);
		Nombre tt = new Reel(3);
		Nombre ttt = new Reel(1);

		System.out.println(new SecondDegreeEquations(t, tt, ttt).solve());

		t = new Reel(3);
		tt = new Reel(3);
		ttt = new Reel(1);

		System.out.println(new SecondDegreeEquations(t, tt, ttt).solve());

		t = new Reel(1);
		tt = new Reel(2);
		ttt = new Reel(1);

		System.out.println(new SecondDegreeEquations(t, tt, ttt).solve());

		t = new Reel(1);
		tt = new Complexe(2, 1);
		ttt = new Reel(1);

		System.out.println(new SecondDegreeEquations(t, tt, ttt).solve());
	}
}
