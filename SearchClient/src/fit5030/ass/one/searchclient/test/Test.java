package fit5030.ass.one.searchclient.test;

import fit5030.ass.one.searchclient.web.yahoo.YahooWebSearchEngine;
import fit5030.ass.one.searchclient.web.yahoo.YahooWebSearchQuery;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YahooWebSearchEngine se = new YahooWebSearchEngine();
		YahooWebSearchQuery query = new YahooWebSearchQuery();
		query.setQueryInput("monash&nbsp;student");
		System.out.println(se.search(query));
		System.out.println(query);
	}

}
