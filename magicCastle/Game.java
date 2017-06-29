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
    	        System.out.println("��·������������������У�go bye help find fight");
    	        System.out.println("�磺\tgo east");
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
				System.out.println("��������"+getMonsterNum()+"ֻ����");
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
			System.out.println("�����Ѿ���ȫ��������");
			return false;
		}
		Ordinary monster = new Ordinary();
		System.out.println("���ﻹ��"+monster.getHP()+"��Ѫ");
		System.out.println("�㻹��"+player.getHP()+"��Ѫ");
		while(true) {
			monster.beAttacked(player.attack());
			System.out.println("������˹��");
			if(monster.getHP()<=0) {
				System.out.println("���ɱ�˹��");
				currentRoom.setMonsterNumber();
				System.out.println("�㻹��"+player.getHP()+"��Ѫ");
				return false;
				}
			player.beAttacked(monster.attack());
			System.out.println("����������㡣");
			if(player.getHP()<=0) {
				System.out.println("GAME OVER��");
				return true;
				}
		}
	}

	private void creatPlayer() {
		System.out.println("�����������ǳ�");
		String name = in.nextLine();
		System.out.println("��ѡ�������Ա�");
		System.out.println("����--1   Ů��--2");
		int sex = in.nextInt();
		
		player = new Player(5, sex, name);
	}

	private void creatRooms() {
		Room outside, lobby, pub, study, bedroom;
        //	���췿��
//			һ¥, kitchen, collection, guestroom
//		outside = new Room("�Ǳ���");
//		lobby = new Room("����");
//		kitchen = new Room("����");
//		pub = new Room("�ư�");
//			//������
//		collection = new Room("�ղ���");
//			//��¥
//		study = new Room("�鷿");
//		bedroom = new Room("����");
//		guestroom = new Room("�ͷ�");
//			//��¥
//		outside.setExit("north", lobby);
        outside = new Room("�Ǳ���");
        lobby = new Room("����");
        pub = new Room("С�ư�");
        study = new Room("�鷿");
        bedroom = new Room("����");

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
        System.out.println(player.toString()+",��ӭ�����Ǳ���");
        System.out.println("����һ���������ĵ�������Ϸ��");
        System.out.println("�����Ҫ������������ 'help'��");
        System.out.println();
        showPrompt();
	}

	private void showPrompt() {
		System.out.println("");
		System.out.println("����" + currentRoom);
		System.out.print("�����У�");
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
            System.out.println("����û���ţ�");
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
        System.out.println("��л���Ĺ��١��ټ���");
	}

}
