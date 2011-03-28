package fit5030.assignement.one.searchclient.test;

import fit5030.assignement.one.searchclient.*;

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
