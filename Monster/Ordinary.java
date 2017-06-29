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
		com[0] = "�������һ������Ź����գ�";
		com[1] = "��������ⲻ���ܣ�";
		com[2] = "�����������";
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
