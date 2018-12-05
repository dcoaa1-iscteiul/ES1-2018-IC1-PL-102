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

public class FacebookAPI {
	

	public static List<String> info = new ArrayList<String>();
	
	public static void search(String search) {
		info.clear();
		System.out.println(search);
		String accessToken2 = "EAAEyBUHNss4BANSHu9XT6kJ6V0fgic9nEOmLBR3CppIkzc6NxnmnzLTZCwe1qSRZAts2PajGWGQLZByOndvlSVJJrehL6oXsQCRLHMgSUOnKuBhGCCIZB1Ue8GieO5pMXUZAgOEg0PHcKxxFtcugESqIc1O3kpP86f8yPckuyEVrcGiJwiBhcSe1J3iDyBadRkjIvWPZAbjwjOZANPIU5ZCqGTV5ZCYIlD2qpwatZAdjanvwZDZD\r\n" + 
				"";
		FacebookClient fbClient2 = new DefaultFacebookClient(accessToken2);
		User me2 = fbClient2.fetchObject("me", User.class);
		String accessToken4 = "EAAEyBUHNss4BANSHu9XT6kJ6V0fgic9nEOmLBR3CppIkzc6NxnmnzLTZCwe1qSRZAts2PajGWGQLZByOndvlSVJJrehL6oXsQCRLHMgSUOnKuBhGCCIZB1Ue8GieO5pMXUZAgOEg0PHcKxxFtcugESqIc1O3kpP86f8yPckuyEVrcGiJwiBhcSe1J3iDyBadRkjIvWPZAbjwjOZANPIU5ZCqGTV5ZCYIlD2qpwatZAdjanvwZDZD\r\n" + 
				"";
		FacebookClient fbClient4 = new DefaultFacebookClient(accessToken4);
		AccessToken extendedAccessToken4 = fbClient4.obtainExtendedAccessToken("336473136935630","ff838d09a35ad6bdaa17b1dcaa76aef6");

		String accessToken5 ;//= "EAAGZBEccjciEBAJ37ZAIbHKiL1Mo1HHex2pQTcs41dq8azfBvFGgt4eGgKBq12kSssOof51FKO0niKu7AaVKs3dy8W1ilqp4xcjFD1F9mmjJpVyeDnZAffUXRfh7zXL06BuSwQtfHMJbmJ079qCnkT844brHx966cz73JZBZBFy2Bv1rWu7T1rQddZCVpxywZCO6lDxoWDk2gZDZD";
		accessToken5 = "EAAEyBUHNss4BANSHu9XT6kJ6V0fgic9nEOmLBR3CppIkzc6NxnmnzLTZCwe1qSRZAts2PajGWGQLZByOndvlSVJJrehL6oXsQCRLHMgSUOnKuBhGCCIZB1Ue8GieO5pMXUZAgOEg0PHcKxxFtcugESqIc1O3kpP86f8yPckuyEVrcGiJwiBhcSe1J3iDyBadRkjIvWPZAbjwjOZANPIU5ZCqGTV5ZCYIlD2qpwatZAdjanvwZDZD\r\n" + 
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
		String accessToken = "EAAEyBUHNss4BANSHu9XT6kJ6V0fgic9nEOmLBR3CppIkzc6NxnmnzLTZCwe1qSRZAts2PajGWGQLZByOndvlSVJJrehL6oXsQCRLHMgSUOnKuBhGCCIZB1Ue8GieO5pMXUZAgOEg0PHcKxxFtcugESqIc1O3kpP86f8yPckuyEVrcGiJwiBhcSe1J3iDyBadRkjIvWPZAbjwjOZANPIU5ZCqGTV5ZCYIlD2qpwatZAdjanvwZDZD\r\n" + 
				"";
		FacebookClient fbClient = new DefaultFacebookClient(accessToken);
		FacebookType response = fbClient.publish("me/feed", FacebookType.class, Parameter.with("messeage", post));
		JOptionPane.showMessageDialog(FacebookFrame.frame, "Post feito!");
	}
	public static List<String> getInfo() {
		return info;
	}
	
}

