package magicCastle;

import java.util.HashMap;

public class Game {
	private Room currentRoom;
	private HashMap<String, Handler> handlers = new HashMap<String, Handler>();

	public Game() {
		handlers.put("go", new Handler() {

			@Override
			public void doCmd(String word) {
				super.doCmd(word);
			}
			
		});
		handlers.put("help", new Handler() {

			@Override
			public void doCmd(String word) {
    	        System.out.println("��·������������������У�go bye help");
    	        System.out.println("�磺\tgo east");
			}
			
		});
		handlers.put("bye", new Handler() {

			@Override
			public boolean isBye() {
				return true;
			}
			
		});
		creatRooms();
	}
	
	private void creatRooms() {
		Room outside, lobby, pub, study, bedroom, kitchen, collection, guestroom;
        //	���췿��
			//һ¥
		outside = new Room("�Ǳ���");
		lobby = new Room("����");
		kitchen = new Room("����");
		pub = new Room("�ư�");
			//������
		collection = new Room("�ղ���");
			//��¥
		study = new Room("�鷿");
		bedroom = new Room("����");
		guestroom = new Room("�ͷ�");
			//��¥
		outside.setExit("north", lobby);
		
		currentRoom = outside;
	}

	public static void main(String[] args) {
		Game game = new Game();
	}

}
