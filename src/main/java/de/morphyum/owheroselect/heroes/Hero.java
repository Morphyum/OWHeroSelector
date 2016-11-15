package de.morphyum.owheroselect.heroes;

import lombok.Data;

@Data
public class Hero {
	private double ability1;
	private double ability2;
	private double leftclick;
	private double rightclick;
	private double selfheal;
	private double heal;
	private double damage;
	private Boolean initiation;
	private Boolean offUltOut;
	private double sustain;
	private String name;
	private double ultCharge;
	private double mainDmg;
	private double dps;
	private double healing;
	private double ultChargeTime;
	// private double ultDps;
	private double ultDamage;

	public void init() {
		pickMainDmg();
		calcDps();
		calcHealing();
		calcUltChargeTime();
		// calcUltDps();
		calcDamage();
		calcSustain();
	}

	private void pickMainDmg() {
		mainDmg = 0;
		if (leftclick > rightclick)
			mainDmg = leftclick;
		else
			mainDmg = rightclick;
	}

	private void calcDps() {
		dps = mainDmg + ability1 + ability2;
	}

	private void calcHealing() {
		double hps = heal;
		if (hps > 100)
			healing = 1;
		else if (hps > 50)
			healing = 0.75;
		else if (hps > 25)
			healing = 0.5;
		else if (hps > 0)
			healing = 0.25;
		else
			healing = 0;
		// healing = heal;
	}

	private void calcUltChargeTime() {
		ultChargeTime = ultCharge / (5 + dps + selfheal);
	}

	// private void calcUltDps(){
	// ultDps = ultDamage / ultChargeTime;
	// }

	private void calcDamage() {
		double damagepersecond = dps;
		if (damagepersecond > 240)
			damage = 1;
		else if (damagepersecond > 190)
			damage = 0.75;
		else if (damagepersecond > 140)
			damage = 0.5;
		else if (damagepersecond > 90)
			damage = 0.25;
		else
			damage = 0;

		// damage = dps;//+ ultDps;
	}

	private void calcSustain() {
		double ehp = sustain + selfheal * 2;
		if (ehp > 600)
			sustain = 1;
		else if (ehp > 400)
			sustain = 0.75;
		else if (ehp > 300)
			sustain = 0.5;
		else if (ehp > 200)
			sustain = 0.25;
		else
			sustain = 0;
		// sustain = sustain + selfheal*2;
	}

}
