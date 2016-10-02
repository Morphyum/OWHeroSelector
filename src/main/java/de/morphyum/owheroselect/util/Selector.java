package de.morphyum.owheroselect.util;

import java.util.ArrayList;
import java.util.List;

import de.morphyum.owheroselect.heroes.Hero;
import de.morphyum.owheroselect.heroes.HeroFactory;

public class Selector {

	final static double MIN_DAMAGE = 3.5;
	final static double MIN_SUSTAIN = 3.25;

	public static List<String> pickHero(String string, String string2, String string3, String string4, String string5, String string6) {
		List<String> inputList = new ArrayList<String>();
		if (!string.isEmpty())
			inputList.add(string);
		if (!string2.isEmpty())
			inputList.add(string2);
		if (!string3.isEmpty())
			inputList.add(string3);
		if (!string4.isEmpty())
			inputList.add(string4);
		if (!string5.isEmpty())
			inputList.add(string5);
		if (!string6.isEmpty())
			inputList.add(string6);
		List<Hero> heroList = new ArrayList<Hero>();
		for (String elem : inputList) {
			heroList.add(HeroFactory.generateHero(elem));
		}

		double totalDamage = 0;
		for (Hero hero : heroList) {
			totalDamage += hero.getDamage();
		}

		Boolean totalInitiation = false;
		for (Hero hero : heroList) {
			if (hero.getInitiation() == true) {
				totalInitiation = true;
				break;
			}
		}

		Boolean totalOffUltOut = false;
		for (Hero hero : heroList) {
			if (hero.getOffUltOut() == true) {
				totalOffUltOut = true;
				break;
			}
		}

		Boolean totalHealer = false;
		for (Hero hero : heroList) {
			if (hero.getHealer() == true) {
				totalHealer = true;
				break;
			}
		}

		double totalSustain = 0;
		for (Hero hero : heroList) {
			totalSustain += hero.getSustain();
		}
		List<String> pickList = new ArrayList<String>();

		pickList = filterHeroes(totalDamage, totalInitiation, totalHealer, totalOffUltOut, totalSustain, inputList);
		if (pickList == null) {
			pickList = emercencySelect(totalDamage, totalInitiation, totalHealer, totalOffUltOut, totalSustain, inputList);
		}
		return pickList;
	}

	private static List<String> filterHeroes(double totalDamage, Boolean totalInitiation, Boolean totalHealer, Boolean totalOffUltOut, double totalSustain,
			List<String> inputList) {
		List<Hero> heroList = HeroFactory.getAllHeroes();
		List<String> pickList = new ArrayList<String>();
		Boolean perfectTeam = true;
		if (totalDamage < MIN_DAMAGE) {
			heroList = filterDamageHeroes(heroList, MIN_DAMAGE - totalDamage, inputList);
			pickList.add(0, "Need More Damage: ");
			perfectTeam = false;
		}
		if (totalInitiation == false) {
			heroList = filterInitHeroes(heroList, inputList);
			pickList.add(0, "Need Initiator: ");
			perfectTeam = false;
		}
		if (totalOffUltOut == false) {
			heroList = filterUltOffHeroes(heroList, inputList);
			pickList.add(0, "Need Counter Ult: ");
			perfectTeam = false;
		}
		if (totalHealer == false) {
			heroList = filterHealerHeroes(heroList, inputList);
			pickList.add(0, "Need Healer: ");
			perfectTeam = false;
		}
		if (totalSustain < MIN_SUSTAIN) {
			heroList = filterSustainHeroes(heroList, MIN_SUSTAIN - totalSustain, inputList);
			pickList.add(0, "Need More Sustain: ");
			perfectTeam = false;
		}

		if (heroList.isEmpty()) {
			return null;
		}

		if (perfectTeam) {
			pickList.add("Perfect Setup!");
		} else {
			for (Hero hero : heroList) {
				pickList.add(hero.getName());
			}
		}
		return pickList;
	}

	private static List<Hero> filterSustainHeroes(List<Hero> heroList, double neededSustain, List<String> inputList) {
		List<Hero> pickList = new ArrayList<Hero>();
		for (Hero hero : heroList) {
			if (hero.getSustain() >= neededSustain && !inputList.contains(hero.getName())) {
				pickList.add(hero);
			}
		}

		return pickList;
	}

	private static List<Hero> filterHealerHeroes(List<Hero> heroList, List<String> inputList) {
		List<Hero> pickList = new ArrayList<Hero>();
		for (Hero hero : heroList) {
			if (hero.getHealer() == true && !inputList.contains(hero.getName())) {
				pickList.add(hero);
			}
		}

		return pickList;
	}

	private static List<Hero> filterUltOffHeroes(List<Hero> heroList, List<String> inputList) {
		List<Hero> pickList = new ArrayList<Hero>();
		for (Hero hero : heroList) {
			if (hero.getOffUltOut() == true && !inputList.contains(hero.getName())) {
				pickList.add(hero);
			}
		}

		return pickList;
	}

	private static List<Hero> filterInitHeroes(List<Hero> heroList, List<String> inputList) {
		List<Hero> pickList = new ArrayList<Hero>();
		for (Hero hero : heroList) {
			if (hero.getInitiation() == true && !inputList.contains(hero.getName())) {
				pickList.add(hero);
			}
		}

		return pickList;
	}

	private static List<Hero> filterDamageHeroes(List<Hero> heroList, double neededDamage, List<String> inputList) {
		List<Hero> pickList = new ArrayList<Hero>();
		for (Hero hero : heroList) {
			if (hero.getDamage() >= neededDamage && !inputList.contains(hero.getName())) {
				pickList.add(hero);
			}
		}

		return pickList;
	}

	private static List<String> selectHealerHeroes(List<String> inputList) {
		List<Hero> heroes = HeroFactory.getAllHeroes();
		List<String> pickList = new ArrayList<String>();
		for (Hero hero : heroes) {
			if (hero.getHealer() == true && !inputList.contains(hero.getName())) {
				pickList.add(hero.getName());
			}
		}

		return pickList;
	}

	private static List<String> selectSustainHeroes(double neededSustain, List<String> inputList) {
		List<Hero> heroes = HeroFactory.getAllHeroes();
		List<String> pickList = new ArrayList<String>();
		for (Hero hero : heroes) {
			if (hero.getSustain() >= neededSustain && !inputList.contains(hero.getName())) {
				pickList.add(hero.getName());
			}
		}

		return pickList;
	}

	private static List<String> selectUltOffHeroes(List<String> inputList) {
		List<Hero> heroes = HeroFactory.getAllHeroes();
		List<String> pickList = new ArrayList<String>();
		for (Hero hero : heroes) {
			if (hero.getOffUltOut() == true && !inputList.contains(hero.getName())) {
				pickList.add(hero.getName());
			}
		}

		return pickList;
	}

	private static List<String> selectInitHeroes(List<String> inputList) {
		List<Hero> heroes = HeroFactory.getAllHeroes();
		List<String> pickList = new ArrayList<String>();
		for (Hero hero : heroes) {
			if (hero.getInitiation() == true && !inputList.contains(hero.getName())) {
				pickList.add(hero.getName());
			}
		}

		return pickList;
	}

	private static List<String> selectDamageHeroes(double neededDamage, List<String> inputList) {
		List<Hero> heroes = HeroFactory.getAllHeroes();
		List<String> pickList = new ArrayList<String>();
		for (Hero hero : heroes) {
			if (hero.getDamage() >= neededDamage && !inputList.contains(hero.getName())) {
				pickList.add(hero.getName());
			}
		}

		return pickList;
	}

	private static List<String> emercencySelect(double totalDamage, boolean totalInitiation, boolean totalHealer, boolean totalOffUltOut, double totalSustain,
			List<String> inputList) {
		List<String> pickList = new ArrayList<String>();
		if (totalDamage < MIN_DAMAGE) {
			pickList = selectDamageHeroes(MIN_DAMAGE - totalDamage, inputList);
			if (pickList.isEmpty()) {
				pickList.add(0, "No Single Hero can Help!! ");
			} else {
				pickList.add(0, "No perfect fit Emergency More Damage: ");
			}
		} else if (totalInitiation == false) {
			pickList = selectInitHeroes(inputList);
			if (pickList.isEmpty()) {
				pickList.add(0, "No Single Hero can Help!! ");
			} else {
				pickList.add(0, "No perfect fit Emergency Initiator: ");
			}
		} else if (totalOffUltOut == false) {
			pickList = selectUltOffHeroes(inputList);
			if (pickList.isEmpty()) {
				pickList.add(0, "No Single Hero can Help!! ");
			} else {
				pickList.add(0, "No perfect fit Emergency Counter Ult: ");
			}
		} else if (totalHealer == false) {
			pickList = selectHealerHeroes(inputList);
			if (pickList.isEmpty()) {
				pickList.add(0, "No Single Hero can Help!! ");
			} else {
				pickList.add(0, "No perfect fit Emergency Healer: ");
			}
		} else if (totalSustain < MIN_SUSTAIN) {
			pickList = selectSustainHeroes(MIN_SUSTAIN - totalSustain, inputList);
			if (pickList.isEmpty()) {
				pickList.add(0, "No Single Hero can Help!! ");
			} else {
				pickList.add(0, "No perfect fit Emergency More Sustain: ");
			}
		}

		if (totalDamage < 3.5) {
			pickList.add(0, "Damage ");
		}
		if (totalInitiation == false) {
			pickList.add(0, "Initiator ");
		}
		if (totalOffUltOut == false) {
			pickList.add(0, "Counter Ult ");
		}
		if (totalHealer == false) {
			pickList.add(0, "Healer ");
		}
		if (totalSustain < 3.5) {
			pickList.add(0, "Sustain ");
		}
		pickList.add(0, "Missing: ");
		return pickList;
	}
}
