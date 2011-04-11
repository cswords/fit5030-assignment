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
		YahooWebSearchEngine webse = new YahooWebSearchEngine();
		YahooWebSearchQuery webquery = new YahooWebSearchQuery();
		
		FlickrSearchEngine imgse=new FlickrSearchEngine();
		FlickrSearchQuery imgquery=new FlickrSearchQuery();
		
		webquery.setQueryInput("melbourne");
		System.out.println(webse.search(webquery,3,0));
		
		imgquery.setQueryInput("china");
		System.out.println(imgse.search(imgquery,3,2));
		
	}

}
