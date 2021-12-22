import twitter4j.*;

public class TweetListener implements StatusListener{

        @Override
        public void onStatus(Status status) {        	
        	Tweet newTweet = createTweetFrom(status);     	 
            processTweet(newTweet);
        }
        
        private Tweet createTweetFrom(Status currentStatus){        	
        	Tweet newTweet = new Tweet();        	
        	newTweet.initializeTweet(currentStatus);
            
            return newTweet;
        }
        
        private void processTweet(Tweet currentTweet){
        	
        	if(Filter.containsKeywords(currentTweet)){
        		
        		currentTweet.printTweet();
        	}	
        }
        /* Notifications can be printed to console but were commented out as they were not helpful
         * in this specific case */
         
        @Override
        /*
         * (non-Javadoc)
         * @see twitter4j.StatusListener#onTrackLimitationNotice(int)
         */
        public void onTrackLimitationNotice(int arg0) {  /*System.out.println("onTrackLimitationNotice" +"\n"); */   }
        @Override
        /*
         * (non-Javadoc)
         * @see twitter4j.StatusListener#onStallWarning(twitter4j.StallWarning)
         */
        public void onStallWarning(StallWarning arg0) {  /* System.out.println("onStallWarning" +"\n");*/ }
        @Override
        /*
         * (non-Javadoc)
         * @see twitter4j.StreamListener#onException(java.lang.Exception)
         */
        public void onException(Exception arg0) { /* System.out.println("onException" +"\n");*/ }  
        @Override
        /*
         * (non-Javadoc)
         * @see twitter4j.StatusListener#onDeletionNotice(twitter4j.StatusDeletionNotice)
         */
        public void onDeletionNotice(StatusDeletionNotice arg0) { /* System.out.println("onDeletionNotice" +"\n");*/  }
        @Override
        /*
         * (non-Javadoc)
         * @see twitter4j.StatusListener#onScrubGeo(long, long)
         */
        public void onScrubGeo(long arg0, long arg1) { /*System.out.println("onScrubGeo" +"\n");*/  }
}
