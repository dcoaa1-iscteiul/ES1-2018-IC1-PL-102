package project;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Post;
import com.restfb.types.User;

import project.Mensagem.Tipo;

public class FacebookAPI {
	

	public static List<String> info = new ArrayList<String>();
	
	public static void search(String search) {
		info.clear();
		System.out.println(search);
		String accessToken2 = "EAAEyBUHNss4BAI7mbqERBGpE3XDfljeyaNHgxS3gJrRL3BnlUz7DcHKH1yIExvukdZCJWAv35P2D6at4z81l0jSWzlgGYjHc64U7huD9bY3lEcSOYQCbLxEQa1AhukW6RTebs8CnFT23WhpXhbYyHCMuXn8EZD\r\n" + 
				"";
		FacebookClient fbClient2 = new DefaultFacebookClient(accessToken2);
		User me2 = fbClient2.fetchObject("me", User.class);
		String accessToken4 = "EAAEyBUHNss4BAI7mbqERBGpE3XDfljeyaNHgxS3gJrRL3BnlUz7DcHKH1yIExvukdZCJWAv35P2D6at4z81l0jSWzlgGYjHc64U7huD9bY3lEcSOYQCbLxEQa1AhukW6RTebs8CnFT23WhpXhbYyHCMuXn8EZD\r\n" + 
				"";
		FacebookClient fbClient4 = new DefaultFacebookClient(accessToken4);
		AccessToken extendedAccessToken4 = fbClient4.obtainExtendedAccessToken("336473136935630","a9394f2b0aa7667e6274ce1d47d73239");

		String accessToken5 ;//= "EAAGZBEccjciEBAJ37ZAIbHKiL1Mo1HHex2pQTcs41dq8azfBvFGgt4eGgKBq12kSssOof51FKO0niKu7AaVKs3dy8W1ilqp4xcjFD1F9mmjJpVyeDnZAffUXRfh7zXL06BuSwQtfHMJbmJ079qCnkT844brHx966cz73JZBZBFy2Bv1rWu7T1rQddZCVpxywZCO6lDxoWDk2gZDZD";
		accessToken5 = "EAAEyBUHNss4BAI7mbqERBGpE3XDfljeyaNHgxS3gJrRL3BnlUz7DcHKH1yIExvukdZCJWAv35P2D6at4z81l0jSWzlgGYjHc64U7huD9bY3lEcSOYQCbLxEQa1AhukW6RTebs8CnFT23WhpXhbYyHCMuXn8EZD\r\n" + 
				"";	
		FacebookClient fbClient5 = new DefaultFacebookClient(accessToken5);

		Connection<Post> result = fbClient5.fetchConnection("me/feed",Post.class);
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "Inform"
				if (aPost.getMessage() != null && aPost.getMessage().contains(search)) {
					info.add(aPost.getMessage().toString());
					FacebookFrame.info2JList();
				}
			}
		}	
	}

	public static void post(String post) {
		String accessToken2 = "EAAEyBUHNss4BAN2myLeWX3l2BW9rqzo1STZABZCfjDKMYy7AK6VZBqJhAtDv98Om05kA0eKAaWLZAT4rbCx0ADQ6Idc57gimKenXu91ZA9VDAuaxiaNZCwS1NIdZAMkkUBV7kiSHGkT60LMqhFlD16WEJKMZCFjP3NdevxF0WuwZAj8oXAs4kpoZB1i3ST9NnNy2B00URF6lXEpQZDZD\r\n" + 
				"";
		FacebookClient fbClient2 = new DefaultFacebookClient(accessToken2);
		fbClient2.publish("me/feed", FacebookType.class, Parameter.with(post, accessToken2));
		JOptionPane.showMessageDialog(FacebookFrame.frame, "ReTweet enviado!");
	}
	public static List<String> getInfo() {
		return info;
	}
	
}

