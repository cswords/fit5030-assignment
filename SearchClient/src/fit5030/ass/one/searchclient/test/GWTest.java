package fit5030.ass.one.searchclient.test;

import fit5030.ass.one.searchclient.web.google.*;

public class GWTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GoogleWebSearchQuery q = new GoogleWebSearchQuery();
		q.setQueryInput("Monash");
		GoogleWebSearchEngine e = new GoogleWebSearchEngine();
		System.out.println(e.search(q));
	}

}
