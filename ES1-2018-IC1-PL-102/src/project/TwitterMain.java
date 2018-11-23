package project;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import project.Mensagem.Tipo;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;




public class TwitterMain {

	private TwitterFactory tf;
	public static List<Mensagem> info = new ArrayList<Mensagem>();



	public static void tweet(String tweet) {
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			.setOAuthConsumerKey("C24UhBh4Pi2xkpz0BQemkb9B4")
			.setOAuthConsumerSecret("HTCFuTBoWLMZoZIwb8QGeL9eEyqVK4szzRuSaSuNZDuI4WyKsC")
			.setOAuthAccessToken("1055232838059077632-0Fb1FKz7vbKhCuf2na0fZxG3vQjL9V")
			.setOAuthAccessTokenSecret("Dd8weM1Dbn5vLkJwnrBVLJS1W2MVRsPAf7W0thQ7qvkRA");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			twitter.updateStatus(tweet);
			JOptionPane.showMessageDialog(TwitterFrame.frame, "Tweet enviado!");
		} catch (Exception e) { System.out.println(e.getMessage()); }
	}

	public static void retweet(Long tweetID) {
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			.setOAuthConsumerKey("C24UhBh4Pi2xkpz0BQemkb9B4")
			.setOAuthConsumerSecret("HTCFuTBoWLMZoZIwb8QGeL9eEyqVK4szzRuSaSuNZDuI4WyKsC")
			.setOAuthAccessToken("1055232838059077632-0Fb1FKz7vbKhCuf2na0fZxG3vQjL9V")
			.setOAuthAccessTokenSecret("Dd8weM1Dbn5vLkJwnrBVLJS1W2MVRsPAf7W0thQ7qvkRA");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			twitter.retweetStatus(tweetID);
			System.out.println(tweetID);
			JOptionPane.showMessageDialog(TwitterFrame.frame, "ReTweet enviado!");
		} catch (Exception e) { System.out.println(e.getMessage()); }
	}
	
	

	public static void search(String search) {
		try {
			info.clear();
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			.setOAuthConsumerKey("C24UhBh4Pi2xkpz0BQemkb9B4")
			.setOAuthConsumerSecret("HTCFuTBoWLMZoZIwb8QGeL9eEyqVK4szzRuSaSuNZDuI4WyKsC")
			.setOAuthAccessToken("1055232838059077632-0Fb1FKz7vbKhCuf2na0fZxG3vQjL9V")
			.setOAuthAccessTokenSecret("Dd8weM1Dbn5vLkJwnrBVLJS1W2MVRsPAf7W0thQ7qvkRA");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			List<Status> statuses = twitter.getHomeTimeline();
			for (Status status : statuses) {
				Mensagem msg = new Mensagem(Tipo.TWITTER, status.getId(), status.getText(), status.getUser().getName(), status.getCreatedAt().toString());
				
				if (status.getUser().getName().contains(search) || status.getText().contains(search)) {
					//System.out.println(status.getCreatedAt() + " " +
					//status.getUser().getName() + " " + status.getText());
					//info2JList(status);

					//List<String> info = new ArrayList<String>();
					
					//info.add(status.getCreatedAt() + " " +
							//status.getUser().getName() + " " + status.getText());
					
					info.add(msg);

					System.out.println(info);
					TwitterFrame.info2JList();


				}
			}
			//twitter.updateStatus(search);
		} catch (Exception e) { System.out.println(e.getMessage()); }
	}

	public List<Mensagem> getList() {
		return info;
	}

}


