package fit5030.ass.one.searchclient.test;

import fit5030.ass.one.searchclient.image.flickr.FlickrSearchEngine;
import fit5030.ass.one.searchclient.image.flickr.FlickrSearchQuery;
import fit5030.ass.one.searchclient.web.yahoo.YahooWebSearchEngine;
import fit5030.ass.one.searchclient.web.yahoo.YahooWebSearchQuery;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlickrSearchEngine se = new FlickrSearchEngine();
		FlickrSearchQuery query = new FlickrSearchQuery();
		
		query.setQueryInput("monash&nbsp;student");
		System.out.println(query);
		System.out.println(se.search(query));
	}

}
