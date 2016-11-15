package de.morphyum.owheroselect.heroes;

import java.util.ArrayList;
import java.util.List;

public class HeroFactory {

	public static Hero generateHero(String inputHero) {
		Hero hero;
		switch (inputHero) {

		case "Genji": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(true);
			hero.setOffUltOut(false);
			hero.setName("Genji");
			hero.setLeftclick(28 * 3 / 1);
			hero.setRightclick(28 * 3 / 1.33);

			// assume 2 hits for swift
			hero.setAbility1(50 / 8 * 2);
			hero.setAbility2(0);

			hero.setSustain(200);
			hero.setSelfheal(0);
			hero.setHeal(0);
			hero.setUltCharge(1200*1.25);
			hero.setUltDamage(120 * 6);

			hero.init();
			break;
		}

		case "McCree": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(false);
			hero.setName("McCree");
			hero.setLeftclick(70 * 2);
			hero.setRightclick(45 * 6);

			hero.setAbility1(0);
			hero.setAbility2(25);

			hero.setSustain(200);
			hero.setSelfheal(0);
			hero.setHeal(0);
			hero.setUltCharge(1200*1.25);
			hero.setUltDamage(250 * 6 * 2);

			hero.init();
			break;

		}

		case "Pharah": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(false);
			hero.setName("Pharah");
			hero.setLeftclick(120 * 1.1);
			hero.setRightclick(0);

			// assume 2 hits for swift
			hero.setAbility1(0);
			hero.setAbility2(0);

			hero.setSustain(200);
			hero.setSelfheal(0);
			hero.setHeal(0);
			hero.setUltCharge(1500*1.25);
			hero.setUltDamage(40 * 90);

			hero.init();
			break;

		}

		case "Reaper": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(true);
			hero.setName("Reaper");
			hero.setLeftclick(20 * 7 * 2);
			hero.setRightclick(0);

			// assume 2 hits for swift
			hero.setAbility1(0);
			hero.setAbility2(0);

			hero.setSustain(250);
			// 2 orbs per fight every 30 seconds fight
			hero.setSelfheal(50 * 2 / 30);
			hero.setHeal(0);
			hero.setUltCharge(1500*1.25);
			// assume 2 targets
			hero.setUltDamage(510 * 2);
			hero.init();
			break;

		}

		case "Soldier": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(false);
			hero.setName("Soldier");
			hero.setLeftclick(20 * 10);
			// rightclick is an ability will be part of ability 1
			hero.setRightclick(0);

			// Rockets instead of sprint assume 2 hits
			hero.setAbility1(120 / 8 * 2);
			// Ability 2 is healing
			hero.setAbility2(0);

			hero.setSustain(200);
			hero.setSelfheal(0);
			hero.setHeal(40 / 5);
			hero.setUltCharge(1660*1.25);
			hero.setUltDamage(hero.getLeftclick() * 6);
			hero.init();
			break;

		}

		case "Tracer": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(false);
			hero.setName("Tracer");
			hero.setLeftclick(12 * 20);
			hero.setRightclick(0);

			hero.setAbility1(0);
			hero.setAbility2(0);

			hero.setSustain(150);
			// recall as selfheal
			hero.setSelfheal(100 / 12);
			hero.setHeal(0);
			hero.setUltCharge(900*1.25);
			hero.setUltDamage(400 * 2);
			hero.init();
			break;

		}

		case "Bastion": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(false);
			hero.setName("Bastion");
			// recon
			hero.setLeftclick(20 * 8);
			// sentry
			hero.setRightclick(15 * 35);

			hero.setAbility1(0);
			hero.setAbility2(0);

			hero.setSustain(200 + (100 * 1.5));
			// repair
			hero.setSelfheal(75/3);
			hero.setHeal(0);
			hero.setUltCharge(1650*1.25);
			hero.setUltDamage(205 * 8 * 1.11);
			hero.init();
			break;

		}

		case "Hanzo": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(false);
			hero.setName("Hanzo");
			hero.setLeftclick(125);
			hero.setRightclick(0);

			hero.setAbility1(0);
			hero.setAbility2(75 * 6 / 10);

			hero.setSustain(200);
			hero.setSelfheal(0);
			hero.setHeal(0);
			hero.setUltCharge(1200*1.25);
			// 2heroes get hit for 2 seconds
			hero.setUltDamage(200 * 2 * 2);
			hero.init();
			break;

		}

		case "Junkrat": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(false);
			hero.setName("Junkrat");
			hero.setLeftclick(120 * 1.66);
			hero.setRightclick(0);

			hero.setAbility1(120 / 8);
			hero.setAbility2(80 / 10);

			hero.setSustain(200);
			hero.setSelfheal(0);
			hero.setHeal(0);
			hero.setUltCharge(1250*1.25);
			hero.setUltDamage(600 * 2);
			hero.init();
			break;

		}

		case "Mei": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(false);
			hero.setName("Mei");
			hero.setLeftclick(45);
			hero.setRightclick(75);

			// assume 2 hits for swift
			hero.setAbility1(50 / 8 * 2);
			hero.setAbility2(0);

			hero.setSustain(250 + (2500 / 10));
			// Cyro
			hero.setSelfheal(150 / 4 / 12);
			hero.setHeal(0);
			hero.setUltCharge(1000*1.25*1.15);
			// assume 2 hero frozen
			hero.setUltDamage(97 * 5 * 2);
			hero.init();
			break;

		}

		case "Torbjörn": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(false);
			hero.setName("Torbjörn");
			hero.setLeftclick(70 * 2);
			hero.setRightclick(15 * 10 * 1.33);

			// turet lv for average
			hero.setAbility1(14 * 2);
			hero.setAbility2(0);
			
			double ultSustain = (300 * 1.5) / (1300*1.25 / (5 + hero.getRightclick() + hero.getAbility1()));
			// assume 2.5 friends are shielded in average
			hero.setSustain(200 + (75 * 2.5 * 1.5) + ultSustain);
			hero.setSelfheal(0);
			hero.setHeal(0);
			hero.setUltCharge(1300*1.25);
			hero.setUltDamage((hero.getRightclick() + hero.getAbility1()) * 12 * 1.5);
			hero.init();
			break;

		}

		case "Widowmaker": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(false);
			hero.setName("Widowmaker");
			hero.setLeftclick(120 / 1.12);
			hero.setRightclick(13 * 10);

			// assume 2 hits for swift
			hero.setAbility1(0);
			hero.setAbility2(15 * 5 / 15);

			hero.setSustain(200);
			hero.setSelfheal(0);
			hero.setHeal(0);
			hero.setUltCharge(1100*1.25);
			hero.setUltDamage(0);
			hero.init();
			break;

		}

		case "D.Va": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(true);
			hero.setOffUltOut(true);
			hero.setName("D.Va");
			hero.setLeftclick(3 * 8 * 6.67);
			hero.setRightclick(0);

			// assume 2 hits
			hero.setAbility1(25 * 2 / 5);
			hero.setAbility2(0);

			hero.setSustain(200 + (400 * 1.5));
			hero.setSelfheal(0);
			hero.setHeal(0);
			hero.setUltCharge(1100);
			// assume 2 hits
			hero.setUltDamage(1000 * 2);
			hero.init();
			break;

		}

		case "Reinhardt": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(true);
			hero.setOffUltOut(true);
			hero.setName("Reinhardt");
			// assume 2 hits
			hero.setLeftclick(75 * 2);
			hero.setRightclick(0);

			// assume 2 hits for swift
			hero.setAbility1(300 / 10);
			// assume 2 hits
			hero.setAbility2(100 / 6 * 2);

			//Balance shield values
			hero.setSustain(300 + (200 * 1.5) + 2000/10);
			// Shield heal
			hero.setSelfheal(225/10);
			hero.setHeal(0);
			hero.setUltCharge(1100*1.25);
			// assume 2 hits
			hero.setUltDamage(50 * 2);
			hero.init();
			break;

		}

		case "Roadhog": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(false);
			hero.setName("Roadhog");
			hero.setLeftclick(9 * 25);
			hero.setRightclick(9 * 25);

			// assume 2 hits for swift
			hero.setAbility1(0);
			hero.setAbility2(30 / 6);

			hero.setSustain(600);
			hero.setSelfheal(300 / 8);
			hero.setHeal(0);
			hero.setUltCharge(1600*1.25);
			hero.setUltDamage(5000);
			hero.init();
			break;

		}

		case "Winston": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(true);
			hero.setOffUltOut(true);
			hero.setName("Winston");
			hero.setLeftclick(60);
			hero.setRightclick(0);

			// assume 2 hits for swift
			hero.setAbility1(50 / 6);
			hero.setAbility2(0);

			double ultSustain = 500 / (1100 / (5 + hero.getLeftclick() + hero.getAbility1()));
			//
			hero.setSustain(400 + (100 * 1.5) + (800 / 13) + ultSustain);
			hero.setSelfheal(0);
			hero.setHeal(0);
			hero.setUltCharge(1100*1.25);
			hero.setUltDamage(40 * 10);
			hero.init();
			break;

		}

		case "Zarya": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(true);
			hero.setOffUltOut(false);
			hero.setName("Zarya");
			// assume 35% energy
			hero.setLeftclick(95 * 1.35);
			// assume 35% energy and 2 hits
			hero.setRightclick(45 * 2 * 1.35);

			// assume 2 hits for swift
			hero.setAbility1(50 / 8 * 2);
			hero.setAbility2(0);

			hero.setSustain(200 + 200 + (200 / 10) + (200 / 8));
			hero.setSelfheal(20.5);
			hero.setHeal(0);
			hero.setUltCharge(1500*1.25);
			hero.setUltDamage(22);
			hero.init();
			break;

		}

		case "Ana": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(false);
			hero.setName("Ana");
			hero.setLeftclick(80 * 1.2);
			hero.setRightclick(0);

			// assume 2 hits for swift
			hero.setAbility1(5 / 12);
			hero.setAbility2(60);
			// average sustain 200 assumed
			double ultSustain = 200 / (1300 / (5 + hero.getLeftclick() + hero.getAbility2()));
			hero.setSustain(200 + ultSustain);
			hero.setSelfheal(0);
			// grenade up time can be 50% of the whole time
			hero.setHeal((70 * 1.2 * 1.5) + 100 / 10);
			hero.setUltCharge(1300*1.25);
			// average dps assumed 100
			hero.setUltDamage(100 * 1.5 * 8);
			hero.init();
			break;

		}

		case "Lucio": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(true);
			hero.setOffUltOut(true);
			hero.setName("Lucio");
			hero.setLeftclick(16 * 4);
			hero.setRightclick(0);

			// rightclick
			hero.setAbility1(25 / 4);
			hero.setAbility2(0);
			double ultSustain = 500 * 6 / (2100 / (5 + hero.getLeftclick() + hero.getAbility1()));
			hero.setSustain(200 + ultSustain);
			hero.setSelfheal(0);
			// assume 3 people healed per time + amp
			hero.setHeal(12.5 * 3 + 36*3*3/12);
			hero.setUltCharge(2100*1.25);
			hero.setUltDamage(0);
			hero.init();
			break;

		}

		case "Mercy": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(true);
			hero.setName("Mercy");
			hero.setLeftclick(20 * 5);
			// damage boost assuming 100 average dps
			hero.setRightclick(150 * 1.3 - 150);

			// assume 2 hits for swift
			hero.setAbility1(0);
			hero.setAbility2(0);

			// assume 3 ressuracts with 200 average health
			hero.setSustain(200);
			hero.setSelfheal(20);
			double ultHeal = 200 * 3 / (1300 / (5 + 60 + hero.getLeftclick()));
			hero.setHeal(60+ultHeal);
			hero.setUltCharge(1300*1.25);
			hero.setUltDamage(0);
			hero.init();
			break;

		}

		case "Symmetra": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(false);
			hero.setName("Symmetra");
			hero.setLeftclick(60);
			hero.setRightclick(125 / 2);

			// assume 1 turrets shooting at all time
			hero.setAbility1(25);
			hero.setAbility2(0);
			// plus whole team shielded
			hero.setSustain(100 + 100 + 150);
			hero.setSelfheal(20.5);
			hero.setHeal(0);
			hero.setUltCharge(800*1.25);
			hero.setUltDamage(0);
			hero.init();
			break;
		}

		case "Zenyatta": {
			// dps per ability
			hero = new Hero();
			hero.setInitiation(false);
			hero.setOffUltOut(true);
			hero.setName("Zenyatta");
			hero.setLeftclick(46*2.5);
			hero.setRightclick(230/4);

			// assume 150 average damage
			hero.setAbility1(150 * 1.3 -150);
			hero.setAbility2(0);

			hero.setSustain(50 +150);
			hero.setSelfheal(20.5);
			//assume 2 heal targets while ult
			double ultHeal = 300 * 6 * 2 / (1650 / (5 + 30));
			hero.setHeal(30 + ultHeal);
			hero.setUltCharge(1650*1.25);
			hero.setUltDamage(0);
			hero.init();
			break;
		}
		
		case "Sombra": {
			//PTR PTR PTR
			// dps per ability
			hero = new Hero();
			hero.setInitiation(true);
			hero.setOffUltOut(false);
			hero.setName("Sombra");
			hero.setLeftclick(8*20);
			hero.setRightclick(0);

			
			hero.setAbility1(0);
			hero.setAbility2(0);

			hero.setSustain(200);
			hero.setSelfheal(0);
			
			hero.setHeal(250/4.5/2);
			hero.setUltCharge(0);
			//assume average damage = Reinhardt shield destroyed
			hero.setUltDamage(2000);
			hero.init();
			break;
		}

		default:
			hero = null;
			break;
		}

		return hero;

	}

	public static List<Hero> getAllHeroes() {
		List<Hero> heroes = new ArrayList<Hero>();
		heroes.add(generateHero("Ana"));
		heroes.add(generateHero("Bastion"));
		heroes.add(generateHero("D.Va"));
		heroes.add(generateHero("Genji"));
		heroes.add(generateHero("Hanzo"));
		heroes.add(generateHero("Junkrat"));
		heroes.add(generateHero("Lucio"));
		heroes.add(generateHero("McCree"));
		heroes.add(generateHero("Mei"));
		heroes.add(generateHero("Mercy"));
		heroes.add(generateHero("Pharah"));
		heroes.add(generateHero("Reaper"));
		heroes.add(generateHero("Reinhardt"));
		heroes.add(generateHero("Roadhog"));
		heroes.add(generateHero("Soldier"));
		heroes.add(generateHero("Sombra"));
		heroes.add(generateHero("Symmetra"));
		heroes.add(generateHero("Torbjörn"));
		heroes.add(generateHero("Tracer"));
		heroes.add(generateHero("Widowmaker"));
		heroes.add(generateHero("Winston"));
		heroes.add(generateHero("Zarya"));
		heroes.add(generateHero("Zenyatta"));
		return heroes;
	}

	public static List<Hero> getStringToHeroList(List<String> inputList) {
		List<Hero> heroes = new ArrayList<Hero>();
		for (String elem : inputList) {
			heroes.add(generateHero(elem));
		}
		return heroes;
	}
}
