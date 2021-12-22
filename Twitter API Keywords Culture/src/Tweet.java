import twitter4j.*;
public class Tweet {	
	
	private String username ;     
	private String userbio;     
	private String profileLocation ;    
	private long id ;      
	private  String content;     
	private GeoLocation geolocation ;

	public void initializeTweet(Status status){
		
		User currentUser = status.getUser();

        setUsername( currentUser.getName());            
        setUserbio( currentUser.getDescription());         
        setProfileLocation( currentUser.getLocation());            	
        setId(status.getId());         
    	setContent(status.getText());            
        setGeolocation(status.getGeoLocation());  
	}
	
	public void printTweet(){	
		
		/* Console output is saved to output file via Eclipse "Run Configurations..." settings */
	    System.out.println(username + "\n" +
	    				   userbio + "\n" +
	    				   geolocation + "\n" +
	    				   profileLocation + "\n" +
	    				   id + "\n" +
	    				   content + "\n");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserbio() {
		return userbio;
	}

	public void setUserbio(String userbio) {
		this.userbio = userbio;
	}

	public String getProfileLocation() {
		return profileLocation;
	}

	public void setProfileLocation(String profileLocation) {
		this.profileLocation = profileLocation;
	}

	public long getId() {
		return id;
	}

	public void setId(long tweetId) {
		this.id = tweetId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public GeoLocation getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(GeoLocation geolocation) {
		this.geolocation = geolocation;
	}
   
}
