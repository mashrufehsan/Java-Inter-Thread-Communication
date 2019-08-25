public class Conversation {
	
    public static void main(String[] args) {
    	
        Chat chat = new Chat();
        
        new Thread1(chat).start();
        new Thread2(chat).start();
        
    }
}