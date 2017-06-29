package Monster;

public class Ordinary extends Monsters implements Monster {
	private int HP = (int)(9*Math.random()+1);
	private String description = null;
	private int ATK = (int)(3*Math.random()+1);
	private int AC = (int)(2*Math.random()+1);
	private String[] com = new String[2];
	
	public Ordinary() {
		
	}

	private void setCommunicate() {
		com[0] = "怪物：大王一定不会放过你哒！";
		com[1] = "怪物：不，这不可能！";
		com[2] = "怪物：呃啊……";
	}
	
	public String communicate() {
		int m = (int)(2*Math.random());
		return com[m];
	}
	
	@Override
	public int attack() {
		return ATK;
	}

//	@Override
//	public String[] drop() {
//		return null;
//	}

	@Override
	public int getHP() {
		return HP;
	}
	
	public void beAttacked(int ATK) {
		HP = HP + AC - ATK;
	}
}
