package de.morphyum.owheroselect.util;

import java.util.ArrayList;
import java.util.List;

import de.morphyum.owheroselect.heroes.Hero;
import de.morphyum.owheroselect.heroes.HeroFactory;

public class Selector {

	final static double MIN_DAMAGE = 3.75;
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
		if (totalHealer == false) {
			heroList = filterHealerHeroes(heroList, inputList);
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

		if (heroList.isEmpty()) {
			return null;
		}

		if (perfectTeam) {
			pickList.add("Perfect Setup!");
		} else {
			for (Hero hero : heroList) {
				pickList.add("<br>" + hero.getName());
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
		List<Hero> heroes = HeroFactory.getAllHeroes();
		String pickList = null;
		List<Hero> picks = new ArrayList<Hero>();
		double highestDamage = 0;
		for (Hero hero : heroes) {
			if (!inputList.contains(hero.getName())) {
				if (hero.getDamage() > highestDamage) {
					highestDamage = hero.getDamage();
				}
			}
		}
		for (Hero hero : heroes) {
			if (hero.getDamage() == highestDamage && !inputList.contains(hero.getName())) {
				picks.add(hero);
			}
		}

		double totalStats = 0;
		for (Hero hero : picks) {
			if ((hero.getDamage() + hero.getDamage()) > totalStats) {
				pickList = hero.getName();
				totalStats = hero.getDamage() + hero.getSustain();
			}
		}

		return pickList;
	}

	private static String selectHighestSustainHero(List<String> inputList) {
		List<Hero> heroes = HeroFactory.getAllHeroes();
		String pickList = null;
		List<Hero> picks = new ArrayList<Hero>();
		double highestSustain = 0;
		for (Hero hero : heroes) {
			if (!inputList.contains(hero.getName())) {
				if (hero.getDamage() > highestSustain) {
					highestSustain = hero.getSustain();
				}
			}
		}
		for (Hero hero : heroes) {
			if (hero.getDamage() == highestSustain && !inputList.contains(hero.getName())) {
				picks.add(hero);
			}
		}

		double totalStats = 0;
		for (Hero hero : picks) {
			if ((hero.getDamage() + hero.getDamage()) > totalStats) {
				pickList = hero.getName();
				totalStats = hero.getDamage() + hero.getSustain();
			}
		}

		return pickList;
	}

	private static String selectBestInitHero(List<String> inputList) {
		List<Hero> heroes = HeroFactory.getAllHeroes();
		String pickList = null;
		List<Hero> picks = new ArrayList<Hero>();
		for (Hero hero : heroes) {
			if (hero.getInitiation() && !inputList.contains(hero.getName())) {
				picks.add(hero);
			}
		}

		double totalStats = 0;
		for (Hero hero : picks) {
			if ((hero.getDamage() + hero.getDamage()) > totalStats) {
				pickList = hero.getName();
				totalStats = hero.getDamage() + hero.getSustain();
			}
		}

		return pickList;
	}

	private static String selectBestUltOffHero(List<String> inputList) {
		List<Hero> heroes = HeroFactory.getAllHeroes();
		String pickList = null;
		List<Hero> picks = new ArrayList<Hero>();
		for (Hero hero : heroes) {
			if (hero.getOffUltOut() && !inputList.contains(hero.getName())) {
				picks.add(hero);
			}
		}

		double totalStats = 0;
		for (Hero hero : picks) {
			if ((hero.getDamage() + hero.getDamage()) > totalStats) {
				pickList = hero.getName();
				totalStats = hero.getDamage() + hero.getSustain();
			}
		}

		return pickList;
	}

	private static String selectBestHealerHero(List<String> inputList) {
		List<Hero> heroes = HeroFactory.getAllHeroes();
		String pickList = null;
		List<Hero> picks = new ArrayList<Hero>();
		for (Hero hero : heroes) {
			if (hero.getHealer() && !inputList.contains(hero.getName())) {
				picks.add(hero);
			}
		}

		double totalStats = 0;
		for (Hero hero : picks) {
			if ((hero.getDamage() + hero.getDamage()) > totalStats) {
				pickList = hero.getName();
				totalStats = hero.getDamage() + hero.getSustain();
			}
		}

		return pickList;
	}

	private static List<String> emercencySelect(double totalDamage, boolean totalInitiation, boolean totalHealer, boolean totalOffUltOut, double totalSustain,
			List<String> inputList) {
		List<String> pickList = new ArrayList<String>();
		if (totalHealer == false) {
			pickList = selectHealerHeroes(inputList);
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
		}

		if (totalDamage < 3.5) {
			pickList.add(0, "Damage |");
		}
		if (totalInitiation == false) {
			pickList.add(0, "Initiator |");
		}
		if (totalOffUltOut == false) {
			pickList.add(0, "Counter Ult |");
		}
		if (totalHealer == false) {
			pickList.add(0, "Healer |");
		}
		if (totalSustain < 3.5) {
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

		pickList = autoFillHeroes(totalDamage, totalInitiation, totalHealer, totalOffUltOut, totalSustain, inputList);

		return pickList;
	}

	private static List<String> autoFillHeroes(double totalDamage, Boolean totalInitiation, Boolean totalHealer, Boolean totalOffUltOut, double totalSustain,
			List<String> inputList) {
		List<String> pickList = inputList;
		while (pickList.size() < 6) {
			if (totalHealer == false) {
				Hero hero = HeroFactory.generateHero(selectBestHealerHero(pickList));
				pickList.add(hero.getName());
				totalDamage += hero.getDamage();
				totalSustain += hero.getSustain();
				if (hero.getHealer())
					totalHealer = true;
				if (hero.getInitiation())
					totalInitiation = true;
				if (hero.getOffUltOut())
					totalOffUltOut = true;
			} else if (totalDamage < MIN_DAMAGE) {
				Hero hero = HeroFactory.generateHero(selectHighestDamageHero(pickList));
				pickList.add(hero.getName());
				totalDamage += hero.getDamage();
				totalSustain += hero.getSustain();
				if (hero.getHealer())
					totalHealer = true;
				if (hero.getInitiation())
					totalInitiation = true;
				if (hero.getOffUltOut())
					totalOffUltOut = true;
			} else if (totalInitiation == false) {
				Hero hero = HeroFactory.generateHero(selectBestInitHero(pickList));
				pickList.add(hero.getName());
				totalDamage += hero.getDamage();
				totalSustain += hero.getSustain();
				if (hero.getHealer())
					totalHealer = true;
				if (hero.getInitiation())
					totalInitiation = true;
				if (hero.getOffUltOut())
					totalOffUltOut = true;
			} else if (totalOffUltOut == false) {
				Hero hero = HeroFactory.generateHero(selectBestUltOffHero(pickList));
				pickList.add(hero.getName());
				totalDamage += hero.getDamage();
				totalSustain += hero.getSustain();
				if (hero.getHealer())
					totalHealer = true;
				if (hero.getInitiation())
					totalInitiation = true;
				if (hero.getOffUltOut())
					totalOffUltOut = true;
			} else if (totalSustain < MIN_SUSTAIN) {
				Hero hero = HeroFactory.generateHero(selectHighestSustainHero(pickList));
				pickList.add(hero.getName());
				totalDamage += hero.getDamage();
				totalSustain += hero.getSustain();
				if (hero.getHealer())
					totalHealer = true;
				if (hero.getInitiation())
					totalInitiation = true;
				if (hero.getOffUltOut())
					totalOffUltOut = true;
			} else {
				Hero hero = HeroFactory.generateHero(selectHighestDamageHero(pickList));
				pickList.add(hero.getName());
				totalDamage += hero.getDamage();
				totalSustain += hero.getSustain();
				if (hero.getHealer())
					totalHealer = true;
				if (hero.getInitiation())
					totalInitiation = true;
				if (hero.getOffUltOut())
					totalOffUltOut = true;
			}
		}
		return pickList;
	}

}
