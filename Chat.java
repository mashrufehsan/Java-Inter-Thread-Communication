import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Chat {
	
	Scanner sc1 = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	
	String str1,str2;
	int flag = 2;
	
	File f1 = new File("D:\\eclipse-workspace\\Project\\User1\\FileOfUser1.txt");
	File f2 = new File("D:\\eclipse-workspace\\Project\\User2\\FileOfUser1.txt");
	File f3 = new File("D:\\eclipse-workspace\\Project\\User2\\FileOfUser2.txt");
	File f4 = new File("D:\\eclipse-workspace\\Project\\User1\\FileOfUser2.txt");

    public synchronized void getTalk1() throws InterruptedException {
        if (flag==1) {
            wait();
        }
        System.out.print("User1: ");
        str1 = sc1.nextLine();
        if(str1.equalsIgnoreCase("bye")) {
        	System.out.println("\nUser1 has left the chat. Conversation ended.");
        	System.exit(0);
        }
        else if(str1.equalsIgnoreCase("file")) {
        		try {
        			Files.copy(f1.toPath(), f2.toPath());
        			System.out.println("\nFile of User1 sent to User2\n");
        		}catch(IOException e) {
        			e.printStackTrace();
        		}
        }
        flag = 1;
        notify();
    }

    public synchronized void getTalk2() throws InterruptedException {
        if (flag == 2) {
            wait();
        }
        System.out.print("User2: ");
        str2 = sc2.nextLine();
        if(str2.equalsIgnoreCase("bye")) {
        	System.out.println("\nUser2 has left the chat. Conversation ended.");
        	System.exit(0);
        }
        else if(str2.equalsIgnoreCase("file")) {
        	try {
    			Files.copy(f3.toPath(), f4.toPath());
    			System.out.println("\nFile of User2 sent to User1\n");
    		}catch(IOException e) {
    			e.printStackTrace();
    		}
        }
        flag = 2;
        notify();
    }
}