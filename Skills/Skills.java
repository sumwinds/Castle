package Skills;

import java.util.HashMap;

import Monster.Monsters;
import magicCastle.Player;

public class Skills {
	private HashMap<String, Skill> skills = new HashMap<String, Skill>();
	
	public void setSkill() {
		skills.put("顺劈斩", new Skill(1, 2, "武器从上而下用力劈砍", "敌人被劈 了个趔趄") {
			@Override
			public void effect(Monsters monster, Player player) {
				monster.setHP(monster.getHP() - super.getATK());
			}
		});
		skills.put("盾反", new Skill(2, 1, "挡住一次攻击并用盾牌反击敌人", "敌人后退了好几步") {
			@Override
			public void effect(Monsters monster, Player player) {
				monster.setHP(monster.getHP() - super.getATK());
			}
		});
		skills.put("三连劈", new Skill(4, 2, "快速的砍出三刀", "敌人慌手慌脚的招架") {
			@Override
			public void effect(Monsters monster, Player player) {
				monster.setHP(monster.getHP() - super.getATK());
				monster.setHP(monster.getHP() - super.getATK());
				monster.setHP(monster.getHP() - super.getATK());
			}
		});
		skills.put("力劈华山", new Skill(5, 8, "来自东方的精妙招式", "敌人受到了巨大的伤害") {
			@Override
			public void effect(Monsters monster, Player player) {
				monster.setHP(monster.getHP() - super.getATK());
			}
		});
		skills.put("雷霆一击", new Skill(4, 6, "让怪物感受雷霆吧", "敌人的身上出现了严重的伤痕") {
			@Override
			public void effect(Monsters monster, Player player) {
				monster.setHP(monster.getHP() - super.getATK());
			}
		});
	}
	
}
