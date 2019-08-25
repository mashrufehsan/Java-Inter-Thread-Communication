public class Thread2 extends Thread {
	
	Chat chat;

	public Thread2(Chat chat) {
		this.chat = chat;
	}

	//@Override
	public void run() {
		try {
			while(true) {
				chat.getTalk2();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}