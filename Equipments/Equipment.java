package Equipments;

import Skills.Skill;

public interface Equipment {
	
	public void setsetInformation(int AKT, String description, int AC);
	public void uesSkill(String skillName);
	public String[] show();
	
}
