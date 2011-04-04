package fit5030.ass.one.searchclient.test;

import fit5030.ass.one.searchclient.video.youtube.YoutubeSearchEngine;
import fit5030.ass.one.searchclient.video.youtube.YoutubeSearchQuery;


public class YTTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		YoutubeSearchQuery q = new YoutubeSearchQuery();
		q.setQueryInput("Monash");
		YoutubeSearchEngine e = new YoutubeSearchEngine();
		System.out.println(e.search(q));

	}

}
