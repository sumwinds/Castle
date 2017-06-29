package Skills;

import Monster.Monsters;
import magicCastle.Player;

public class Skill {
	private int CD = 0;
	private int f_CD = 0;
	private int ATK = 0;
	private String description = null;
	private String d_effect = null;
	private boolean used = false;
	
	public Skill(int CD, int ATK, String description, String effect) {
		this.CD = CD;
		this.f_CD = CD;
		this.ATK = ATK;
		this.description = description;
		this.d_effect = effect;
	}
	
	public boolean isCD() {
		if(CD == f_CD) {
			return true;
		}
		return false;
	}
	
	public void learn() {
		used = true;
	}
	
	public void effect(Monsters monster, Player player) {
		
	}
	
	public int getATK() {
		return ATK;
	}
}
