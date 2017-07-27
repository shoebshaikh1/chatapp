/*
 * This is the chat server/publisher
 * 
 * 
 * */

import java.util.Scanner;

import redis.clients.jedis.Jedis;

public class ChatMain {

	public static void main(String  args[]){
        Jedis jed = new Jedis("localhost");
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter channel name:");
        String pubChannel = sc.nextLine();
        
        while (true){
            System.out.println("Enter the message:");
            String message = sc.nextLine();
            jed.publish(pubChannel ,message);

        }
    }

}
