package fit5030.ass.one.searchclient.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;

import fit5030.ass.one.searchclient.image.flickr.FlickrSearchEngine;
import fit5030.ass.one.searchclient.image.flickr.FlickrSearchQuery;
import fit5030.ass.one.searchclient.image.picasa.PicasaSearchEngine;
import fit5030.ass.one.searchclient.image.picasa.PicasaSearchQuery;
import fit5030.ass.one.searchclient.web.yahoo.YahooWebSearchEngine;
import fit5030.ass.one.searchclient.web.yahoo.YahooWebSearchQuery;
import fit5030.ass.two.searchclient.comment.SocialSearchQuery;
import fit5030.ass.two.searchclient.comment.twitter.*;
import fit5030.ass.two.searchclient.webservice.Ajax;
import fit5030.ass.two.searchclient.webservice.SimpleAjax;
import fit5030.ass.two.searchclient.webservice.SimpleAjax.UnifiedQuery;
import fit5030.ass.two.searchclient.webservice.Ajax.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * YahooWebSearchEngine webse = new YahooWebSearchEngine();
		 * YahooWebSearchQuery webquery = new YahooWebSearchQuery();
		 * webquery.setQueryInput("beijing");
		 * System.out.println(webse.search(webquery,5,1));
		 * 
		 * FlickrSearchEngine imgse=new FlickrSearchEngine(); FlickrSearchQuery
		 * imgquery=new FlickrSearchQuery(); imgquery.setQueryInput("shanghai");
		 * System.out.println(imgse.search(imgquery,5,2));
		 * 
		 * PicasaSearchEngine se=new PicasaSearchEngine(); PicasaSearchQuery
		 * query=new PicasaSearchQuery(); query.setQueryInput("usa");
		 * System.out.println(se.search(query,10,1));
		 */

		// TwitterCommentSearchEngine twitterse=new
		// TwitterCommentSearchEngine();
		// TwitterSingleDaySearchQuery twitterq=new
		// TwitterSingleDaySearchQuery();
		// System.out.println(twitterq);
		// twitterse.search(twitterq, 100, 1);
		// TwitterSingleDaySearchQuery q=new TwitterSingleDaySearchQuery();
		// q.setQueryInput("monash");
		// q.setDate(new Date());
		// System.out.println(q);
		// TwitterSingleDaySearchEngine e=new TwitterSingleDaySearchEngine();
		// e.search(q);

		// TwitterCommentSearchEngine e = new TwitterCommentSearchEngine();
		// TwitterCommentSearchQuery q = new TwitterCommentSearchQuery();
		// q.setDays(5);
		// q.setQueryInput("melbourne");
		// e.search(q);
		Ajax a = new Ajax();

		// WebSearchQuery q = new WebSearchQuery();
		// q.setQueryName("Google");

		// ImageSearchQuery q=new ImageSearchQuery();
		// q.setQueryName("Flickr");
		// try {
		// q.setStart(new SimpleDateFormat("dd/MM/yyyy").parse("30/11/2010"));
		// q.setEnd(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2020"));
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }

//		VideoSearchQuery q = new VideoSearchQuery();
//		q.setQueryName("Youtube");
//
//		q.setPageNumber(1);
//		q.setPageSize(10);

		// String re = a.webSearch(q).getContent();
		// String re=a.imageSearch(q).getContent();
//		VideoSearchResult rr = a.videoSearch(q);
		
//		Ajax.SocialSearchQuery q=new Ajax.SocialSearchQuery();
//		q.setQueryName("Twitter");
//		q.setDays(4);
//		q.setQueryInput("monash");
//		SocialSearchResult rr=a.socialSearch(q);
//		String re = rr.getContent();
//		System.out.println(re);
		
		UnifiedQuery q=new UnifiedQuery();
		q.setTarget("Twitter");
		q.setQ("monash");
		q.setDays(3);
		SimpleAjax sa=new SimpleAjax();
		String query=q.toJSONString();
		System.out.println(query);
		try {
			System.out.println(sa.unifiedSearch(query));
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
