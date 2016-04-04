package com.mycompany.app;

import java.util.ArrayList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.*;

public class App {

	public static void main(String[] args) throws TwitterException {

		// access the twitter API using your twitter4j.properties file
		Twitter twitter = TwitterFactory.getSingleton();

		// create a new search
		Query query = new Query("long and hard");

		// get the results from that search
		QueryResult result = twitter.search(query);

		// get the first tweet from those results
		Status tweetResult = result.getTweets().get(0);

		// reply to that tweet
		StatusUpdate statusUpdate = new StatusUpdate(
				".@" + tweetResult.getUser().getScreenName() + " that's what she said");
		statusUpdate.inReplyToStatusId(tweetResult.getId());
		Status status = twitter.updateStatus(statusUpdate);

		System.out.println("Done.");
	}
}
