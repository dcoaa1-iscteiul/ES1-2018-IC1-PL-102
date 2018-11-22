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
	private ConfigurationBuilder cb;
	private TwitterFactory tf;

	
	
	@Override
	public void run() {
		while(!interrupted()) {
			startTwitter();

		}
	}

	public void authentication() {

		cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("gSs8YTJ2uMDSdBHImPqxbEHxA")
		.setOAuthConsumerSecret("SUPKAPtB9wNc0r6qlixXHxgthWt9LR66KccA02j9CMSu166jCF")
		.setOAuthAccessToken("1055232838059077632-aQRtKqJfuvhUyF9Nr7O5YdWExQCFsL")
		.setOAuthAccessTokenSecret("FIlIGoPWqPwV3qKgpKohI16Pw91mQTtLj0aTSLYD2qo0n");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();        		
	}


	public static void retweet(String retweet) {
			try {
				ConfigurationBuilder cb = new ConfigurationBuilder();
				cb.setDebugEnabled(true)
				.setOAuthConsumerKey("gSs8YTJ2uMDSdBHImPqxbEHxA")
				.setOAuthConsumerSecret("SUPKAPtB9wNc0r6qlixXHxgthWt9LR66KccA02j9CMSu166jCF")
				.setOAuthAccessToken("1055232838059077632-aQRtKqJfuvhUyF9Nr7O5YdWExQCFsL")
				.setOAuthAccessTokenSecret("FIlIGoPWqPwV3qKgpKohI16Pw91mQTtLj0aTSLYD2qo0n");
				TwitterFactory tf = new TwitterFactory(cb.build());
				Twitter twitter = tf.getInstance();
				twitter.updateStatus(retweet);
			} catch (Exception e) { System.out.println(e.getMessage()); }
		}
	
	public void startTwitter() {
		authentication();
		//search();
		//retweet(List<Status> retweet);
		//retweet();
		
	}

	public static void search(String search) {
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			.setOAuthConsumerKey("gSs8YTJ2uMDSdBHImPqxbEHxA")
			.setOAuthConsumerSecret("SUPKAPtB9wNc0r6qlixXHxgthWt9LR66KccA02j9CMSu166jCF")
			.setOAuthAccessToken("1055232838059077632-aQRtKqJfuvhUyF9Nr7O5YdWExQCFsL")
			.setOAuthAccessTokenSecret("FIlIGoPWqPwV3qKgpKohI16Pw91mQTtLj0aTSLYD2qo0n");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			List<Status> statuses = twitter.getHomeTimeline();
			String show = new String();
			for (Status status : statuses) {
				if (status.getUser().getName().contains(search) || status.getText().contains(search)) {
					System.out.println(status);
					
				}
			}
			twitter.updateStatus(search);
		} catch (Exception e) { System.out.println(e.getMessage()); }
	
		
	}

}

