package de.morphyum.owheroselect.heroes;

import java.util.ArrayList;
import java.util.List;

public class HeroFactory {

	public static Hero generateHero(String inputHero) {
		Hero hero;
		switch (inputHero) {

		case "Genji": {
			hero = new Hero(0.5, true, false, 0, "Genji", false);
			break;
		}

		case "McCree": {
			hero = new Hero(1.5, false, false, 0, "McCree", false);
			break;
		}

		case "Pharah": {
			hero = new Hero(0.5, false, false, 0, "Pharah", false);
			break;
		}

		case "Reaper": {
			hero = new Hero(1.5, false, false, 0.25, "Reaper", false);
			break;
		}

		case "Soldier": {
			hero = new Hero(1, false, false, 0.25, "Soldier", false);
			break;
		}

		case "Tracer": {
			hero = new Hero(1.5, false, false, 0.25, "Tracer", false);
			break;
		}

		case "Bastion": {
			hero = new Hero(1.5, false, false, 0.25, "Bastion", false);
			break;
		}

		case "Hanzo": {
			hero = new Hero(0.5, false, false, 0, "Hanzo", false);
			break;
		}

		case "Junkrat": {
			hero = new Hero(1, false, false, 0, "Junkrat", false);
			break;
		}

		case "Mei": {
			hero = new Hero(0.5, false, false, 0.5, "Mei", false);
			break;
		}

		case "Torbjörn": {
			hero = new Hero(1, false, false, 0.25, "Torbjörn", false);
			break;
		}

		case "Widowmaker": {
			hero = new Hero(0.5, false, false, 0, "Widowmaker", false);
			break;
		}

		case "D.Va": {
			hero = new Hero(1, true, true, 0.5, "D.Va", false);
			break;
		}

		case "Reinhardt": {
			hero = new Hero(0, true, true, 0.5, "Reinhardt", false);
			break;
		}

		case "Roadhog": {
			hero = new Hero(1.5, false, false, 0.75, "Roadhog", false);
			break;
		}

		case "Winston": {
			hero = new Hero(0, true, false, 0.5, "Winston", false);
			break;
		}

		case "Zarya": {
			hero = new Hero(1, true, false, 1, "Zarya", false);
			break;
		}

		case "Ana": {
			hero = new Hero(0.5, true, false, 1, "Ana", true);
			break;
		}

		case "Lucio": {
			hero = new Hero(0, true, true, 1, "Lucio", true);
			break;
		}

		case "Mercy": {
			hero = new Hero(0, false, true, 1.5, "Mercy", true);
			break;
		}

		case "Symmetra": {
			hero = new Hero(0.5, false, false, 0.25, "Symmetra", false);
			break;
		}

		case "Zenyatta": {
			hero = new Hero(0.5, false, true, 0.5, "Zenyatta", true);
			break;
		}

		default:
			hero = null;
			break;
		}

		return hero;

	}
	
	public static List<Hero> getAllHeroes(){
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
		heroes.add(generateHero("Symmetra"));
		heroes.add(generateHero("Torbjörn"));
		heroes.add(generateHero("Tracer"));
		heroes.add(generateHero("Widowmaker"));
		heroes.add(generateHero("Winston"));
		heroes.add(generateHero("Zarya"));
		heroes.add(generateHero("Zenyatta"));
		return heroes;
	}
}
