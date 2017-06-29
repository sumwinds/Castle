package Skills;

import java.util.HashMap;

import Monster.Monsters;
import magicCastle.Player;

public class Skills {
	private HashMap<String, Skill> skills = new HashMap<String, Skill>();
	
	public void setSkill() {
		skills.put("˳��ն", new Skill(1, 2, "�������϶�����������", "���˱��� �˸�����") {
			@Override
			public void effect(Monsters monster, Player player) {
				monster.setHP(monster.getHP() - super.getATK());
			}
		});
		skills.put("�ܷ�", new Skill(2, 1, "��סһ�ι������ö��Ʒ�������", "���˺����˺ü���") {
			@Override
			public void effect(Monsters monster, Player player) {
				monster.setHP(monster.getHP() - super.getATK());
			}
		});
		skills.put("������", new Skill(4, 2, "���ٵĿ�������", "���˻��ֻŽŵ��м�") {
			@Override
			public void effect(Monsters monster, Player player) {
				monster.setHP(monster.getHP() - super.getATK());
				monster.setHP(monster.getHP() - super.getATK());
				monster.setHP(monster.getHP() - super.getATK());
			}
		});
		skills.put("������ɽ", new Skill(5, 8, "���Զ����ľ�����ʽ", "�����ܵ��˾޴���˺�") {
			@Override
			public void effect(Monsters monster, Player player) {
				monster.setHP(monster.getHP() - super.getATK());
			}
		});
		skills.put("����һ��", new Skill(4, 6, "�ù������������", "���˵����ϳ��������ص��˺�") {
			@Override
			public void effect(Monsters monster, Player player) {
				monster.setHP(monster.getHP() - super.getATK());
			}
		});
	}
	
}
