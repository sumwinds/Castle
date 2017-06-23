package Equipments;

import Skills.Skill;

public interface Equipment {
	double socpe = Math.random();
	String description = null;
	String name = null;
	Skill[] skill = null;
	
	public void setsetInformation(int AKT, String description, int AC);
	public void uesSkill(String skillName);
	public String[] show();
	
}
