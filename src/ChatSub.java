/*
 * This is the chat client/subscriber
 * 
 * */

import java.util.Scanner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class ChatSub {

	public static void main(String args[]) {
		Jedis jed = new Jedis("localhost");
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter channel name to be subscribed:");
        String channel = sc.nextLine();
        System.out.println("You have successfully subscribed to Channel " + channel);

        while (true) {
            jed.subscribe(new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                    super.onMessage(channel, message);
                    System.out.println("Message from channel "+ channel +" : " + message);
                }

                @Override
                public void onSubscribe(String channel, int subscribedChannels) {
                }

                @Override
                public void onUnsubscribe(String channel, int subscribedChannels) {
                }

                @Override
                public void onPMessage(String pattern, String channel, String message) {
                }

                @Override
                public void onPUnsubscribe(String pattern, int subscribedChannels) {
                }
                
                @Override
                public void onPSubscribe(String pattern, int subscribedChannels) {
                }

            }, channel);
        }
    }

}
