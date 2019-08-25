public class Thread1 extends Thread {
	
	Chat chat;

	public Thread1(Chat chat) {
		this.chat = chat;
	}

	//@Override
	public void run() {
		try {
			while(true) {
				chat.getTalk1();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}