package send;

import java.util.List;

import project.TwitterMain;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Retweet{
	
	public static void retweet(List<Status> retweet) {
		
		//obter o texto que o utilizador quiser inserir no retweet;
		if(!retweet.isEmpty()) {
			 try {
		        	ConfigurationBuilder cb = new ConfigurationBuilder();
		        	cb.setDebugEnabled(true)
		        	  .setOAuthConsumerKey("m47BhNIxXyzqBLD9zDEbivGOG")
		        	  .setOAuthConsumerSecret("h0gtAwWXzVaTb9YltZVMXJy8md3MPKNSPGVYg3xbU9aWaKtdM5")
		        	  .setOAuthAccessToken("1055232838059077632-lIAQzn5Gvhj3H7Ox4hH4FHxn1vQYCP")
		        	  .setOAuthAccessTokenSecret("p6aES0HNDcJOCPxjtkJzS6gT2E0ZKy2uKQT82uVP8JrEE");
		        	TwitterFactory tf = new TwitterFactory(cb.build());
		        	Twitter twitter = tf.getInstance();
	//	        	twitter.retweetStatus(arg0);
			 } catch (Exception e) { System.out.println(e.getMessage()); }
		}
		
	}
	
}