package NPC;

public interface NPC {
	int row = 0;
	int col = 0;
	String color = null;
	String description = null;
	String[] sentence = null;
	
	public void setsetInformation(int row, int col, String description, String color);
	public void communicate();
}
