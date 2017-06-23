package Skills;

public interface Skill {
	int CD = 0;
	int ATK = 0;
	String description = null;
	String effect = null;
	
	public void setInformation(int CD, int ATK, String description, String effect);
	public boolean isCD();
}
