package fit5030.ass.one.searchclient.test;

import fit5030.ass.one.searchclient.image.flickr.FlickrSearchEngine;
import fit5030.ass.one.searchclient.image.flickr.FlickrSearchQuery;
import fit5030.ass.one.searchclient.image.picasa.PicasaSearchEngine;
import fit5030.ass.one.searchclient.image.picasa.PicasaSearchQuery;
import fit5030.ass.one.searchclient.web.yahoo.YahooWebSearchEngine;
import fit5030.ass.one.searchclient.web.yahoo.YahooWebSearchQuery;
import fit5030.ass.two.searchclient.comment.twitter.TwitterCommentSearchEngine;
import fit5030.ass.two.searchclient.comment.twitter.TwitterCommentSearchQuery;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*		YahooWebSearchEngine webse = new YahooWebSearchEngine();
		YahooWebSearchQuery webquery = new YahooWebSearchQuery();
		webquery.setQueryInput("beijing");
		System.out.println(webse.search(webquery,5,1));
	
		FlickrSearchEngine imgse=new FlickrSearchEngine();
		FlickrSearchQuery imgquery=new FlickrSearchQuery();
		imgquery.setQueryInput("shanghai");
		System.out.println(imgse.search(imgquery,5,2));
		
		PicasaSearchEngine se=new PicasaSearchEngine();
		PicasaSearchQuery query=new PicasaSearchQuery();
		query.setQueryInput("usa");
		System.out.println(se.search(query,10,1));*/
		
		TwitterCommentSearchEngine twitterse=new TwitterCommentSearchEngine();
		TwitterCommentSearchQuery twitterq=new TwitterCommentSearchQuery();
		twitterq.setQueryInput("melbourne");
		System.out.println(twitterq);
		twitterse.search(twitterq, 100, 1);
		
		
	}

}
