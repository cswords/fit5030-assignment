package fit5030.ass.one.searchclient.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import fit5030.ass.one.searchclient.image.flickr.FlickrSearchEngine;
import fit5030.ass.one.searchclient.image.flickr.FlickrSearchQuery;
import fit5030.ass.one.searchclient.image.picasa.PicasaSearchEngine;
import fit5030.ass.one.searchclient.image.picasa.PicasaSearchQuery;
import fit5030.ass.one.searchclient.web.yahoo.YahooWebSearchEngine;
import fit5030.ass.one.searchclient.web.yahoo.YahooWebSearchQuery;
import fit5030.ass.two.searchclient.comment.SocialSearchQuery;
import fit5030.ass.two.searchclient.comment.twitter.*;


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
		
//		TwitterCommentSearchEngine twitterse=new TwitterCommentSearchEngine();
//		TwitterSingleDaySearchQuery twitterq=new TwitterSingleDaySearchQuery();
//		System.out.println(twitterq);
//		twitterse.search(twitterq, 100, 1);
		TwitterSingleDaySearchQuery q=new TwitterSingleDaySearchQuery();
		q.setQueryInput("monash");
		q.setDate(new Date());
		System.out.println(q);
		TwitterSingleDaySearchEngine e=new TwitterSingleDaySearchEngine();
		e.search(q);
		
		

		
	}

}
