package de.morphyum.owheroselect.util;

import java.util.ArrayList;
import java.util.List;

import de.morphyum.owheroselect.heroes.Hero;
import de.morphyum.owheroselect.heroes.HeroFactory;

public class Selector {

	// final static double MIN_DAMAGE =
	// HeroFactory.generateHero("Reinhardt").getDamage() +
	// HeroFactory.generateHero("Zarya").getDamage()
	// + HeroFactory.generateHero("McCree").getDamage() +
	// HeroFactory.generateHero("Genji").getDamage() +
	// HeroFactory.generateHero("Ana").getDamage()
	// + HeroFactory.generateHero("Lucio").getDamage();
	// final static double MIN_SUSTAIN =
	// HeroFactory.generateHero("Reinhardt").getSustain() +
	// HeroFactory.generateHero("Zarya").getSustain()
	// + HeroFactory.generateHero("McCree").getSustain() +
	// HeroFactory.generateHero("Genji").getSustain() +
	// HeroFactory.generateHero("Ana").getSustain()
	// + HeroFactory.generateHero("Lucio").getSustain();
	// final static double MIN_HEALING =
	// HeroFactory.generateHero("Reinhardt").getHealing() +
	// HeroFactory.generateHero("Zarya").getHealing()
	// + HeroFactory.generateHero("McCree").getHealing() +
	// HeroFactory.generateHero("Genji").getHealing() +
	// HeroFactory.generateHero("Ana").getHealing()
	// + HeroFactory.generateHero("Lucio").getHealing();

	final static double MIN_DAMAGE = 3;
	final static double MIN_SUSTAIN = 2.5;
	final static double MIN_HEALING = 1.75;

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
		List<Hero> heroList = HeroFactory.getStringToHeroList(inputList);

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

		double totalHealer = 0;
		for (Hero hero : heroList) {
			totalHealer += hero.getHealing();
		}

		double totalSustain = 0;
		for (Hero hero : heroList) {
			totalSustain += hero.getSustain();
		}
		List<String> pickList = new ArrayList<String>();

		pickList = filterHeroes(totalHealer, totalDamage, totalInitiation, totalOffUltOut, totalSustain, inputList);
		if (pickList == null) {
			pickList = emercencySelect(totalHealer, totalDamage, totalInitiation, totalOffUltOut, totalSustain, inputList);
		}
		return pickList;
	}

	private static List<String> filterHeroes(double totalHealing, double totalDamage, Boolean totalInitiation, Boolean totalOffUltOut, double totalSustain,
			List<String> inputList) {
		List<Hero> heroList = HeroFactory.getAllHeroes();
		List<String> pickList = new ArrayList<String>();
		Boolean perfectTeam = true;
		if (totalHealing == 0) {
			heroList = filterHealerHeroes(heroList, MIN_HEALING - totalHealing, inputList);
			pickList.add(0, "Need Healer: ");
			perfectTeam = false;
		}
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
		if (totalSustain < MIN_SUSTAIN) {
			heroList = filterSustainHeroes(heroList, MIN_SUSTAIN - totalSustain, inputList);
			pickList.add(0, "Need More Sustain: ");
			perfectTeam = false;
		}
		if (totalHealing < MIN_HEALING && totalHealing != 0) {
			heroList = filterHealerHeroes(heroList, MIN_HEALING - totalHealing, inputList);
			pickList.add(0, "Need Healer: ");
			perfectTeam = false;
		}

		if (heroList.isEmpty()) {
			return null;
		}

		if (perfectTeam) {
			List<String> allheroes = new ArrayList<String>();
			for (Hero hero : HeroFactory.getAllHeroes()) {
				if (!inputList.contains(hero.getName())) {
					allheroes.add(hero.getName());
				}
			}
			pickList.add("Perfect Setup!");
			totalHealing *= (MIN_DAMAGE + MIN_SUSTAIN) / MIN_HEALING;
			totalSustain *= (MIN_DAMAGE + MIN_HEALING) / MIN_SUSTAIN;
			totalDamage *= (MIN_HEALING + MIN_SUSTAIN) / MIN_DAMAGE;
			if ((totalHealing <= totalDamage) && (totalHealing <= totalSustain)) {
				pickList.add("<br> Suggestion: " + selectBestHealerHero(allheroes));
			} else if ((totalSustain <= totalHealing) && (totalSustain <= totalDamage)) {
				pickList.add("<br> Suggestion: " + selectHighestDamageHero(allheroes));
			} else if ((totalDamage <= totalHealing) && (totalDamage <= totalSustain)) {
				pickList.add("<br> Suggestion: " + selectHighestDamageHero(allheroes));
			}

		} else {
			for (Hero hero : heroList) {
				pickList.add("<br>" + hero.getName());
			}
		}
		return pickList;
	}

	private static List<String> filterHeroesNoOutput(double totalHealing, double totalDamage, Boolean totalInitiation, Boolean totalOffUltOut,
			double totalSustain, List<String> inputList) {
		List<Hero> heroList = HeroFactory.getAllHeroes();
		List<String> pickList = new ArrayList<String>();
		if (totalHealing == 0) {
			heroList = filterHealerHeroes(heroList, MIN_HEALING - totalHealing, inputList);
		}
		if (totalDamage < MIN_DAMAGE) {
			heroList = filterDamageHeroes(heroList, MIN_DAMAGE - totalDamage, inputList);
		}
		if (totalInitiation == false) {
			heroList = filterInitHeroes(heroList, inputList);
		}
		if (totalOffUltOut == false) {
			heroList = filterUltOffHeroes(heroList, inputList);
		}
		if (totalSustain < MIN_SUSTAIN) {
			heroList = filterSustainHeroes(heroList, MIN_SUSTAIN - totalSustain, inputList);
		}
		if (totalHealing < MIN_HEALING) {
			heroList = filterHealerHeroes(heroList, MIN_HEALING - totalHealing, inputList);
		}

		if (heroList.isEmpty()) {

			heroList = HeroFactory.getAllHeroes();
		}
		for (Hero hero : heroList) {
			if (!inputList.contains(hero.getName()))
				pickList.add(hero.getName());
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

	private static List<Hero> filterHealerHeroes(List<Hero> heroList, double neededHealing, List<String> inputList) {
		List<Hero> pickList = new ArrayList<Hero>();
		for (Hero hero : heroList) {
			if (hero.getHealing() >= neededHealing && !inputList.contains(hero.getName())) {
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

	private static List<String> selectHealerHeroes(double neededHealing, List<String> inputList) {
		List<Hero> heroes = HeroFactory.getAllHeroes();
		List<String> pickList = new ArrayList<String>();
		for (Hero hero : heroes) {
			if (hero.getHealing() >= neededHealing && !inputList.contains(hero.getName())) {
				pickList.add("<br>" + hero.getName());
			}
		}

		return pickList;
	}

	private static List<String> selectSustainHeroes(double neededSustain, List<String> inputList) {
		List<Hero> heroes = HeroFactory.getAllHeroes();
		List<String> pickList = new ArrayList<String>();
		for (Hero hero : heroes) {
			if (hero.getSustain() >= neededSustain && !inputList.contains(hero.getName())) {
				pickList.add("<br>" + hero.getName());
			}
		}

		return pickList;
	}

	private static List<String> selectUltOffHeroes(List<String> inputList) {
		List<Hero> heroes = HeroFactory.getAllHeroes();
		List<String> pickList = new ArrayList<String>();
		for (Hero hero : heroes) {
			if (hero.getOffUltOut() == true && !inputList.contains(hero.getName())) {
				pickList.add("<br>" + hero.getName());
			}
		}

		return pickList;
	}

	private static List<String> selectInitHeroes(List<String> inputList) {
		List<Hero> heroes = HeroFactory.getAllHeroes();
		List<String> pickList = new ArrayList<String>();
		for (Hero hero : heroes) {
			if (hero.getInitiation() == true && !inputList.contains(hero.getName())) {
				pickList.add("<br>" + hero.getName());
			}
		}

		return pickList;
	}

	private static List<String> selectDamageHeroes(double neededDamage, List<String> inputList) {
		List<Hero> heroes = HeroFactory.getAllHeroes();
		List<String> pickList = new ArrayList<String>();
		for (Hero hero : heroes) {
			if (hero.getDamage() >= neededDamage && !inputList.contains(hero.getName())) {
				pickList.add("<br>" + hero.getName());
			}
		}

		return pickList;
	}

	private static String selectHighestDamageHero(List<String> inputList) {
		List<Hero> heroes = new ArrayList<Hero>();
		for (String input : inputList) {
			heroes.add(HeroFactory.generateHero(input));
		}
		String pickList = null;
		List<Hero> picks = new ArrayList<Hero>();
		double highestDamage = 0;
		for (Hero hero : heroes) {

			if (hero.getDamage() > highestDamage) {
				highestDamage = hero.getDamage();
			}

		}
		for (Hero hero : heroes) {
			if (hero.getDamage() == highestDamage) {
				picks.add(hero);
			}
		}

		double totalStats = 0;
		for (Hero hero : picks) {
			if ((hero.getDamage() + hero.getSustain() + hero.getHealing()) > totalStats) {
				pickList = hero.getName();
				totalStats = hero.getDamage() + hero.getSustain();
			}
		}

		return pickList;
	}

	private static String selectHighestSustainHero(List<String> inputList) {
		List<Hero> heroes = new ArrayList<Hero>();
		for (String input : inputList) {
			heroes.add(HeroFactory.generateHero(input));
		}
		String pickList = null;
		List<Hero> picks = new ArrayList<Hero>();
		double highestSustain = 0;
		for (Hero hero : heroes) {

			if (hero.getSustain() > highestSustain) {
				highestSustain = hero.getSustain();
			}

		}
		for (Hero hero : heroes) {
			if (hero.getSustain() == highestSustain) {
				picks.add(hero);
			}
		}

		double totalStats = 0;
		for (Hero hero : picks) {
			if ((hero.getDamage() + hero.getSustain() + hero.getHealing()) > totalStats) {
				pickList = hero.getName();
				totalStats = hero.getDamage() + hero.getSustain();
			}
		}

		return pickList;
	}

	private static String selectBestInitHero(List<String> inputList) {
		List<Hero> heroes = new ArrayList<Hero>();
		for (String input : inputList) {
			heroes.add(HeroFactory.generateHero(input));
		}
		String pickList = null;
		List<Hero> picks = new ArrayList<Hero>();
		for (Hero hero : heroes) {
			if (hero.getInitiation()) {
				picks.add(hero);
			}
		}

		double totalStats = 0;
		for (Hero hero : picks) {
			if ((hero.getDamage() + hero.getSustain()) > totalStats) {
				pickList = hero.getName();
				totalStats = hero.getDamage() + hero.getSustain();
			}
		}

		return pickList;
	}

	private static String selectBestUltOffHero(List<String> inputList) {
		List<Hero> heroes = new ArrayList<Hero>();
		for (String input : inputList) {
			heroes.add(HeroFactory.generateHero(input));
		}
		String pickList = null;
		List<Hero> picks = new ArrayList<Hero>();
		for (Hero hero : heroes) {
			if (hero.getOffUltOut()) {
				picks.add(hero);
			}
		}

		double totalStats = 0;
		for (Hero hero : picks) {
			if ((hero.getDamage() + hero.getSustain()) > totalStats) {
				pickList = hero.getName();
				totalStats = hero.getDamage() + hero.getSustain();
			}
		}

		return pickList;
	}

	private static String selectBestHealerHero(List<String> inputList) {
		List<Hero> heroes = new ArrayList<Hero>();
		for (String input : inputList) {
			heroes.add(HeroFactory.generateHero(input));
		}
		String pickList = null;
		List<Hero> picks = new ArrayList<Hero>();
		double highestHealing = 0;
		for (Hero hero : heroes) {

			if (hero.getHealing() > highestHealing) {
				highestHealing = hero.getHealing();
			}

		}
		for (Hero hero : heroes) {
			if (hero.getHealing() == highestHealing) {
				picks.add(hero);
			}
		}

		double totalStats = 0;
		for (Hero hero : picks) {
			if ((hero.getDamage() + hero.getSustain() + hero.getHealing()) > totalStats) {
				pickList = hero.getName();
				totalStats = hero.getDamage() + hero.getSustain() + hero.getHealing();
			}
		}

		return pickList;
	}

	private static List<String> emercencySelect(double totalHealer, double totalDamage, boolean totalInitiation, boolean totalOffUltOut, double totalSustain,
			List<String> inputList) {
		List<String> pickList = new ArrayList<String>();
		if (totalHealer == 0) {
			pickList = selectHealerHeroes(MIN_HEALING - totalHealer, inputList);
			if (pickList.isEmpty()) {
				pickList.add(0, "<br>No Single Hero can Help!! ");
			} else {
				pickList.add(0, "<br>No perfect fit, Most Important Healer: ");
			}
		} else if (totalDamage < MIN_DAMAGE) {
			pickList = selectDamageHeroes(MIN_DAMAGE - totalDamage, inputList);
			if (pickList.isEmpty()) {
				pickList.add(0, "<br>No Single Hero can Help!! ");
			} else {
				pickList.add(0, "<br>No perfect fit, Most Important More Damage: ");
			}
		} else if (totalInitiation == false) {
			pickList = selectInitHeroes(inputList);
			if (pickList.isEmpty()) {
				pickList.add(0, "<br>No Single Hero can Help!! ");
			} else {
				pickList.add(0, "<br>No perfect fit, Most Important Initiator: ");
			}
		} else if (totalOffUltOut == false) {
			pickList = selectUltOffHeroes(inputList);
			if (pickList.isEmpty()) {
				pickList.add(0, "<br>No Single Hero can Help!! ");
			} else {
				pickList.add(0, "<br>No perfect fit, Most Important Counter Ult: ");
			}
		} else if (totalSustain < MIN_SUSTAIN) {
			pickList = selectSustainHeroes(MIN_SUSTAIN - totalSustain, inputList);
			if (pickList.isEmpty()) {
				pickList.add(0, "<br>No Single Hero can Help!! ");
			} else {
				pickList.add(0, "<br>No perfect fit, Most Important More Sustain: ");
			}
		} else if (totalHealer < MIN_HEALING) {
			pickList = selectHealerHeroes(MIN_HEALING - totalHealer, inputList);
			if (pickList.isEmpty()) {
				pickList.add(0, "<br>No Single Hero can Help!! ");
			} else {
				pickList.add(0, "<br>No perfect fit, Most Important Healer: ");
			}
		}

		if (totalDamage < MIN_DAMAGE) {
			pickList.add(0, "Damage |");
		}
		if (totalInitiation == false) {
			pickList.add(0, "Initiator |");
		}
		if (totalOffUltOut == false) {
			pickList.add(0, "Counter Ult |");
		}
		if (totalHealer < MIN_HEALING) {
			pickList.add(0, "Healer |");
		}
		if (totalSustain < MIN_SUSTAIN) {
			pickList.add(0, "Sustain |");
		}
		pickList.add(0, "Missing: ");
		return pickList;
	}

	public static List<String> autoFillHero(String string, String string2, String string3, String string4, String string5, String string6) {
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
		List<Hero> heroList = HeroFactory.getStringToHeroList(inputList);
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

		double totalHealer = 0;
		for (Hero hero : heroList) {
			totalHealer += hero.getHealing();
		}

		double totalSustain = 0;
		for (Hero hero : heroList) {
			totalSustain += hero.getSustain();
		}
		List<String> pickList = new ArrayList<String>();

		pickList = autoFillHeroes(totalDamage, totalInitiation, totalHealer, totalOffUltOut, totalSustain, inputList);

		return pickList;
	}

	private static List<String> autoFillHeroes(double totalDamage, Boolean totalInitiation, double totalHealer, Boolean totalOffUltOut, double totalSustain,
			List<String> inputList) {
		List<String> pickList;
		while (inputList.size() < 6) {
			pickList = filterHeroesNoOutput(totalHealer, totalDamage, totalInitiation, totalOffUltOut, totalSustain, inputList);
			if (totalHealer == 0) {
				Hero hero = HeroFactory.generateHero(selectBestHealerHero(pickList));
				inputList.add(hero.getName());
				totalDamage += hero.getDamage();
				totalSustain += hero.getSustain();
				totalHealer += hero.getHealing();
				if (hero.getInitiation())
					totalInitiation = true;
				if (hero.getOffUltOut())
					totalOffUltOut = true;
			} else if (totalDamage < MIN_DAMAGE) {
				Hero hero = HeroFactory.generateHero(selectHighestDamageHero(pickList));
				inputList.add(hero.getName());
				totalDamage += hero.getDamage();
				totalSustain += hero.getSustain();
				totalHealer += hero.getHealing();
				if (hero.getInitiation())
					totalInitiation = true;
				if (hero.getOffUltOut())
					totalOffUltOut = true;
			} else if (totalInitiation == false) {
				Hero hero = HeroFactory.generateHero(selectBestInitHero(pickList));
				inputList.add(hero.getName());
				totalDamage += hero.getDamage();
				totalSustain += hero.getSustain();
				totalHealer += hero.getHealing();
				if (hero.getInitiation())
					totalInitiation = true;
				if (hero.getOffUltOut())
					totalOffUltOut = true;
			} else if (totalOffUltOut == false) {
				Hero hero = HeroFactory.generateHero(selectBestUltOffHero(pickList));
				inputList.add(hero.getName());
				totalDamage += hero.getDamage();
				totalSustain += hero.getSustain();
				totalHealer += hero.getHealing();
				if (hero.getInitiation())
					totalInitiation = true;
				if (hero.getOffUltOut())
					totalOffUltOut = true;
			} else if (totalSustain < MIN_SUSTAIN) {
				Hero hero = HeroFactory.generateHero(selectHighestSustainHero(pickList));
				inputList.add(hero.getName());
				totalDamage += hero.getDamage();
				totalSustain += hero.getSustain();
				totalHealer += hero.getHealing();
				if (hero.getInitiation())
					totalInitiation = true;
				if (hero.getOffUltOut())
					totalOffUltOut = true;
			} else if (totalHealer < MIN_HEALING) {
				Hero hero = HeroFactory.generateHero(selectBestHealerHero(pickList));
				inputList.add(hero.getName());
				totalDamage += hero.getDamage();
				totalSustain += hero.getSustain();
				totalHealer += hero.getHealing();
				if (hero.getInitiation())
					totalInitiation = true;
				if (hero.getOffUltOut())
					totalOffUltOut = true;
			} else {
				Hero hero = HeroFactory.generateHero(selectHighestDamageHero(pickList));
				inputList.add(hero.getName());
				totalDamage += hero.getDamage();
				totalSustain += hero.getSustain();
				totalHealer += hero.getHealing();
				if (hero.getInitiation())
					totalInitiation = true;
				if (hero.getOffUltOut())
					totalOffUltOut = true;
			}
		}
		return inputList;
	}

}
