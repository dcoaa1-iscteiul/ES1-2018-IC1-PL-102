package project;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;




public class TwitterMain {


	//private ConfigurationBuilder cb;
	private TwitterFactory tf;
	public static List<String> info = new ArrayList<String>();



	/*
	@Override
	public void run() {
		while(!interrupted()) {
			//startTwitter();

		}
	}
	 */
	/*
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

*/
	public static void tweet(String tweet) {
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			.setOAuthConsumerKey("gSs8YTJ2uMDSdBHImPqxbEHxA")
			.setOAuthConsumerSecret("SUPKAPtB9wNc0r6qlixXHxgthWt9LR66KccA02j9CMSu166jCF")
			.setOAuthAccessToken("1055232838059077632-aQRtKqJfuvhUyF9Nr7O5YdWExQCFsL")
			.setOAuthAccessTokenSecret("FIlIGoPWqPwV3qKgpKohI16Pw91mQTtLj0aTSLYD2qo0n");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			twitter.updateStatus(tweet);
		} catch (Exception e) { System.out.println(e.getMessage()); }
	}
	

	public static void search(String search) {
		try {
			info.clear();
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
					//System.out.println(status.getCreatedAt() + " " +
							//status.getUser().getName() + " " + status.getText());
					//info2JList(status);
					
					//List<String> info = new ArrayList<String>();
					info.add(status.getCreatedAt() + " " +
							status.getUser().getName() + " " + status.getText());
					
					System.out.println(info);
					TwitterFrame.info2JList();


				}
			}
			twitter.updateStatus(search);
		} catch (Exception e) { System.out.println(e.getMessage()); }
	}
	
	public List<String> getList() {
		return info;
	}
	
}


