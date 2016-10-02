package de.morphyum.owheroselect.heroes;

import lombok.Data;

@Data
public class Hero {
	private double damage;
	private Boolean initiation;
	private Boolean offUltOut;
	private double sustain;
	private String name;
	private Boolean healer;
	
	
	public Hero(double damage, boolean initiation, boolean offUltOut, double sustain, String name, boolean healer) {
		this.damage = damage;
		this.initiation = initiation;
		this.offUltOut = offUltOut;
		this.sustain = sustain;
		this.name = name;
		this.healer = healer;
	}
}
