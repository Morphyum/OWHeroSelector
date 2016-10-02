package de.morphyum.owheroselect.heroes;

import junit.framework.TestCase;

public class HeroFactoryTest extends TestCase {
 
    public void testGetAllHeroes()
    {
        assertEquals(22, HeroFactory.getAllHeroes().size());
    }

    
    public void testGenerateHero()
    {
        assertEquals("Ana", HeroFactory.generateHero("Ana").getName());
        assertEquals("Bastion", HeroFactory.generateHero("Bastion").getName());
        assertEquals("D.Va", HeroFactory.generateHero("D.Va").getName());
        assertEquals("Genji", HeroFactory.generateHero("Genji").getName());
        assertEquals("Hanzo", HeroFactory.generateHero("Hanzo").getName());
        assertEquals("Junkrat", HeroFactory.generateHero("Junkrat").getName());
        assertEquals("Lucio", HeroFactory.generateHero("Lucio").getName());
        assertEquals("McCree", HeroFactory.generateHero("McCree").getName());
        assertEquals("Mei", HeroFactory.generateHero("Mei").getName());
        assertEquals("Mercy", HeroFactory.generateHero("Mercy").getName());
        assertEquals("Pharah", HeroFactory.generateHero("Pharah").getName());
        assertEquals("Reaper", HeroFactory.generateHero("Reaper").getName());
        assertEquals("Reinhardt", HeroFactory.generateHero("Reinhardt").getName());
        assertEquals("Roadhog", HeroFactory.generateHero("Roadhog").getName());
        assertEquals("Soldier", HeroFactory.generateHero("Soldier").getName());
        assertEquals("Symmetra", HeroFactory.generateHero("Symmetra").getName());
        assertEquals("Torbjörn", HeroFactory.generateHero("Torbjörn").getName());
        assertEquals("Tracer", HeroFactory.generateHero("Tracer").getName());
        assertEquals("Widowmaker", HeroFactory.generateHero("Widowmaker").getName());
		assertEquals("Winston", HeroFactory.generateHero("Winston").getName());
		assertEquals("Zarya", HeroFactory.generateHero("Zarya").getName());
		assertEquals("Zenyatta", HeroFactory.generateHero("Zenyatta").getName());
    }
}
