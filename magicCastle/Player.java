package magicCastle;

import Equipments.Equipment;
import Skills.Skill;
import Tasks.Task;

public class Player {
	private int HP = 20;
	private int MP = 20;
	private int sex = 1;
	private Skill[] skills = null;
	private Task[] tasks = null;
	private Equipment[] equipment = null;
	private String name = null;
	private String description = null;
	
	public void setInformation(int HP, int MP, int sex, String name) {
		this.HP   = HP;
		this.MP   = MP;
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
		String[] I = new String[7];
		I[0] = "name: " + name;
		I[1] = "sex: " + isMan(sex);
		I[2] = "HP: " + HP + "  " +"MP: " + MP;
		I[3] = "Skills: " + showSkills();
		I[4] = "Tasks: " + showTasks();
		I[5] = "Equipment: " + showEquipment();
		I[6] = "Description: " + description;
		return I;
	}
	
	private String isMan(int sex) {
		if(sex == 1){
			return "Man";
		}else
		return "Woman";
	}
	private String showSkills() {
		StringBuffer sb = new StringBuffer();
		for(Skill s : skills){
			sb.append(s.toString() + " ");
		}
		return sb.toString();
	}
	private String showEquipment() {
		StringBuffer sb = new StringBuffer();
		for(Equipment s : equipment){
			sb.append(s.toString() + " ");
		}
		return sb.toString();
	}
	private String showTasks() {
		StringBuffer sb = new StringBuffer();
		for(Task s : tasks){
			sb.append(s.toString() + " ");
		}
		return sb.toString();
	}
	
//	使用物品
}
