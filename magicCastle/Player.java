package magicCastle;

import Equipments.Equipment;
import Skills.Skill;
import Tasks.Task;

public class Player {
	private int HP = 20;
//	private int MP = 20;
	private int ATK = 5;
	private int sex = 1;
//	private Skill[] skills = null;
//	private Task[] tasks = null;
//	private Equipment[] equipment = null;
	private String name = null;
	private String description = "这个人很懒，什么都没写。";
	
	public Player(int HP, int sex, String name, String description) {
		this.HP   = HP;
		this.sex  = sex;
		this.name = name;
		this.description = description;
	}
	public Player(int HP, int sex, String name) {
		this.HP   = HP;
		this.sex  = sex;
		this.name = name;
	}
	
//	展示属性
	public String toString() {
		return name;
	}
	public void showAttribute() {
		for(String o : getInformation()) {
			System.out.println(o);
		}
	}
	private String[] getInformation() {
		String[] I = new String[4];
		I[0] = "name: " + name;
		I[1] = "sex: " + isMan(sex);
		I[2] = "HP: " + HP + "  ";
//		I[3] = "Skills: " + showSkills();
//		I[4] = "Tasks: " + showTasks();
//		I[5] = "Equipment: " + showEquipment();
		I[3] = "Description: " + description;
		return I;
	}
	
	private String isMan(int sex) {
		if(sex == 1){
			return "Man";
		}else
		return "Woman";
	}
	
//	private String showSkills() {
//		StringBuffer sb = new StringBuffer();
//		for(Skill s : skills){
//			sb.append(s.toString() + " ");
//		}
//		return sb.toString();
//	}
//	private String showEquipment() {
//		StringBuffer sb = new StringBuffer();
//		for(Equipment s : equipment){
//			sb.append(s.toString() + " ");
//		}
//		return sb.toString();
//	}
//	private String showTasks() {
//		StringBuffer sb = new StringBuffer();
//		for(Task s : tasks){
//			sb.append(s.toString() + " ");
//		}
//		return sb.toString();
//	}
	
//	玩家指令
	public int attack() {
		return ATK;
	}
	
	public int getHP() {
		return HP;
	}
	
	public void beAttacked(int ATK) {
		HP = HP - ATK;
	}
}
