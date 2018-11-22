package project;


import java.io.IOException;
import java.util.List;


import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;



public class TwitterMain extends Thread  {


	private TwitterFrame janela;
	private Twitter twitter;

	public TwitterMain() {


	}
	
	@Override
	public void run() {
		while(!interrupted()) {
			startTwitter();

		}
	}


	public static void main(String[] args) {

		
		// http://twitter4j.org
		// http://twitter4j.org/en/code-examples.html
		// https://www.youtube.com/watch?v=uYPmkzMpnxw

	}


	public void search() {

		try {
			List<Status> statuses = twitter.getHomeTimeline();
			System.out.println("------------------------\n Showing home timeline \n------------------------");
			int counter=0;
			int counterTotal = 0;
			for (Status status : statuses) {
				if (status.getUser().getName() != null && status.getUser().getName().contains("asdasdasd")) {
					System.out.println(status.getUser().getName() + ":" + status.getText());
					counter++;
				}
				counterTotal++;
			}
			System.out.println("-------------\nNº of Results: " + counter+"/"+counterTotal);

			//enviar a lista pro retweet
			//            Retweet.retweet();

		} catch (Exception e) { System.out.println(e.getMessage()); }
	}


	public void authentication() {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("m47BhNIxXyzqBLD9zDEbivGOG")
		.setOAuthConsumerSecret("h0gtAwWXzVaTb9YltZVMXJy8md3MPKNSPGVYg3xbU9aWaKtdM5")
		.setOAuthAccessToken("1055232838059077632-lIAQzn5Gvhj3H7Ox4hH4FHxn1vQYCP")
		.setOAuthAccessTokenSecret("p6aES0HNDcJOCPxjtkJzS6gT2E0ZKy2uKQT82uVP8JrEE");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();        		
	}


	public static void retweet() {

		//obter o texto que o utilizador quiser inserir no retweet;
		//if(!retweet.isEmpty()) {
			try {
				ConfigurationBuilder cb = new ConfigurationBuilder();
				cb.setDebugEnabled(true)
				.setOAuthConsumerKey("m47BhNIxXyzqBLD9zDEbivGOG")
				.setOAuthConsumerSecret("h0gtAwWXzVaTb9YltZVMXJy8md3MPKNSPGVYg3xbU9aWaKtdM5")
				.setOAuthAccessToken("1055232838059077632-lIAQzn5Gvhj3H7Ox4hH4FHxn1vQYCP")
				.setOAuthAccessTokenSecret("p6aES0HNDcJOCPxjtkJzS6gT2E0ZKy2uKQT82uVP8JrEE");
				TwitterFactory tf = new TwitterFactory(cb.build());
				Twitter twitter = tf.getInstance();
				List<Status> statuses = twitter.getHomeTimeline();
				//twitter.retweetStatus(arg0);
				twitter.updateStatus("asdasdasd");
			} catch (Exception e) { System.out.println(e.getMessage()); }
		}
	
	public void startTwitter() {
		authentication();
		//search();
		//retweet(List<Status> retweet);
		//retweet();
		
	}
}



