	import java.util.Arrays;
	import twitter4j.conf.ConfigurationBuilder;
	import twitter4j.*;
	
public class TweetStreamer {	

	public static void main(String[] args) {
	    ConfigurationBuilder builder= createBuilder();
	    
	    TwitterStreamFactory streamFactory = new TwitterStreamFactory(builder.build()); 
	    TwitterStream twitterStream = streamFactory.getInstance();
	    
	    TweetListener listener = new TweetListener();
	    twitterStream.addListener(listener);	    
	 
	    double[][] boundingBox = getBoundingBox();       

	    FilterQuery query = new FilterQuery();
	    query.locations(boundingBox);
	    twitterStream.filter(query);  
	   
	    query.locations(boundingBox);
	    twitterStream.filter(query);   
	}

	private static double[][] getBoundingBox(){		
		double latitude = 20.0;
	    double longitude = 78.0;
	    double lat1 = latitude - 12;
	    double long1 = longitude - 10.5;
	    double lat2 = latitude + 12;
	    double long2 = longitude + 10.5;
	    
	    double[][] boundingbox = {{long1, lat1}, {long2, lat2}};
	    return boundingbox;
	}
	
	private static ConfigurationBuilder createBuilder(){
		
		ConfigurationBuilder configbuilder = new ConfigurationBuilder();
	    
		configbuilder.setDebugEnabled(true);
		/* OAuth authentication
	     * Replace placeholders with personal Twitter API access tokens */
		configbuilder.setOAuthConsumerKey("******************************");
		configbuilder.setOAuthConsumerSecret("*****************************************");
		configbuilder.setOAuthAccessToken("***************************************");
		configbuilder.setOAuthAccessTokenSecret("**********************************");

		return configbuilder;
	}
	
	public static boolean stringContainsKeyword(String tweet, String[] keywordlist) {
	    return Arrays.stream(keywordlist).parallel().anyMatch(tweet::contains);
	}
}

