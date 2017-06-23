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
    	        System.out.println("迷路了吗？你可以做的命令有：go bye help");
    	        System.out.println("如：\tgo east");
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
        //	制造房间
			//一楼
		outside = new Room("城堡外");
		lobby = new Room("大堂");
		kitchen = new Room("厨房");
		pub = new Room("酒吧");
			//地下室
		collection = new Room("收藏室");
			//二楼
		study = new Room("书房");
		bedroom = new Room("卧室");
		guestroom = new Room("客房");
			//顶楼
		outside.setExit("north", lobby);
		
		currentRoom = outside;
	}

	public static void main(String[] args) {
		Game game = new Game();
	}

}
