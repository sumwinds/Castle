package Monster;

import Skills.Skill;

public interface Monster {
	int HP = 0;
	int MP = 0;
	String name = null;
	String description = null;
	String[] items = null;
	Skill[] skill = null;
	Double ATK = Math.random();
	Double AC = Math.random();
	
	public void setInformation(int HP, int MP, String name, String description, String[] communicate);
	public void attack();
	public void useSkill();
	public String[] drop();
}
