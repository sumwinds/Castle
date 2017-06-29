package magicCastle;

import java.util.HashMap;
import java.util.Scanner;

import Monster.Ordinary;

public class Game {
	private Room currentRoom;
	private Player player;
	private HashMap<String, Handler> handlers = new HashMap<String, Handler>();
	Scanner in = new Scanner(System.in);

	public Game() {
		handlers.put("go", new Handler() {

			@Override
			public void doCmd(String word) {
				goRoom(word);
			}
			
		});
		handlers.put("help", new Handler() {

			@Override
			public void doCmd(String word) {
    	        System.out.println("迷路了吗？你可以做的命令有：go bye help find fight");
    	        System.out.println("如：\tgo east");
			}
			
		});
		handlers.put("bye", new Handler() {

			@Override
			public boolean isBye() {
				return true;
			}
			
		});
		handlers.put("find", new Handler() {

			@Override
			public void doCmd(String word) {
				System.out.println("");
				System.out.println("房间里有"+getMonsterNum()+"只怪物");
			}
			
		});
		handlers.put("fight", new Handler() {

			@Override
			public boolean iswin() {
				System.out.println("");
				return fight();
			}
		});
		creatRooms();
	}
	
	private boolean fight() {
		if(currentRoom.getMonsterNumber(currentRoom) == 0) {
			System.out.println("怪物已经被全部消灭了");
			return false;
		}
		Ordinary monster = new Ordinary();
		System.out.println("怪物还有"+monster.getHP()+"点血");
		System.out.println("你还有"+player.getHP()+"点血");
		while(true) {
			monster.beAttacked(player.attack());
			System.out.println("你击中了怪物。");
			if(monster.getHP()<=0) {
				System.out.println("你击杀了怪物。");
				currentRoom.setMonsterNumber();
				System.out.println("你还有"+player.getHP()+"点血");
				return false;
				}
			player.beAttacked(monster.attack());
			System.out.println("怪物击中了你。");
			if(player.getHP()<=0) {
				System.out.println("GAME OVER！");
				return true;
				}
		}
	}

	private void creatPlayer() {
		System.out.println("请输入人物昵称");
		String name = in.nextLine();
		System.out.println("请选择人物性别");
		System.out.println("男性--1   女性--2");
		int sex = in.nextInt();
		
		player = new Player(5, sex, name);
	}

	private void creatRooms() {
		Room outside, lobby, pub, study, bedroom;
        //	制造房间
//			一楼, kitchen, collection, guestroom
//		outside = new Room("城堡外");
//		lobby = new Room("大堂");
//		kitchen = new Room("厨房");
//		pub = new Room("酒吧");
//			//地下室
//		collection = new Room("收藏室");
//			//二楼
//		study = new Room("书房");
//		bedroom = new Room("卧室");
//		guestroom = new Room("客房");
//			//顶楼
//		outside.setExit("north", lobby);
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");

        outside.setExit("east", lobby);
        outside.setExit("south", study);
        outside.setExit("west", pub);
        lobby.setExit("west", outside);
        lobby.setExit("up", pub);
        pub.setExit("east", outside);
        pub.setExit("down", lobby);
        study.setExit("north",outside);
        study.setExit("east", bedroom);
        bedroom.setExit("west", study);
		
		currentRoom = outside;
	}
	
	private void printWelcome() {
        System.out.println();
        System.out.println(player.toString()+",欢迎来到城堡！");
        System.out.println("这是一个超级无聊的勇者游戏。");
        System.out.println("如果需要帮助，请输入 'help'。");
        System.out.println();
        showPrompt();
	}

	private void showPrompt() {
		System.out.println("");
		System.out.println("你在" + currentRoom);
		System.out.print("出口有：");
		System.out.println(currentRoom.getExitDesc());
	}

	private int getMonsterNum() {
		return currentRoom.getMonsterNumber(currentRoom);
	}
	
	private void play() {
		while(true) {
			String line = in.nextLine();
			String[] words = line.split(" ");
			Handler handler = handlers.get(words[0]);
			String value = "";
			if(words.length>1) {
				value = words[1];
			}
			if(handler != null) {
				handler.doCmd(value);
				if(handler.isBye()||handler.iswin()) {
					break;
				}
			}
		}
		in.close();
	}
	
	private void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }
	
	public static void main(String[] args) {
		Game game = new Game();
		game.creatPlayer();
		game.printWelcome();
		game.play();
        System.out.println("感谢您的光临。再见！");
	}

}
