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
			System.out.println("-------------\nN� of Results: " + counter+"/"+counterTotal);

			//enviar a lista pro retweet
			//            Retweet.retweet();

		} catch (Exception e) { System.out.println(e.getMessage()); }
	}


	public void authentication() {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("gSs8YTJ2uMDSdBHImPqxbEHxA")
		.setOAuthConsumerSecret("SUPKAPtB9wNc0r6qlixXHxgthWt9LR66KccA02j9CMSu166jCF")
		.setOAuthAccessToken("1055232838059077632-aQRtKqJfuvhUyF9Nr7O5YdWExQCFsL")
		.setOAuthAccessTokenSecret("FIlIGoPWqPwV3qKgpKohI16Pw91mQTtLj0aTSLYD2qo0n");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();        		
	}


	public static void retweet(String s) {

		//obter o texto que o utilizador quiser inserir no retweet;
		//if(!retweet.isEmpty()) {
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
				//twitter.retweetStatus(arg0);
				twitter.updateStatus(s);
			} catch (Exception e) { System.out.println(e.getMessage()); }
		}
	
	public void startTwitter() {
		authentication();
		//search();
		//retweet(List<Status> retweet);
		//retweet();
		
	}
}



