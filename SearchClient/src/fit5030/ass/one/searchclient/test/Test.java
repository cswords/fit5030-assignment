package fit5030.ass.one.searchclient.test;

import fit5030.ass.one.searchclient.web.yahoo.YahooSearchEngine;
import fit5030.ass.one.searchclient.web.yahoo.YahooWebSearchQuery;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YahooSearchEngine se = new YahooSearchEngine();
		YahooWebSearchQuery query = new YahooWebSearchQuery();
		query.setQuery("monash&nbsp;student");
		se.search(query.toString());
	}

}
