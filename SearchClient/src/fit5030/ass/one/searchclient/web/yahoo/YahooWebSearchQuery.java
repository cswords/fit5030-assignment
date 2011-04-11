package fit5030.ass.one.searchclient.web.yahoo;

import fit5030.ass.one.searchclient.base.AbstractQuery;

public class YahooWebSearchQuery extends AbstractQuery {
	public YahooWebSearchQuery() {
		this.setOption("appid",
				"wLrDBTvV34GCv0NakiabQcDGxznW0GbscvtL5T.D6rABBC7QENo9v6a1xa2cFUtwBzgWcPv570.N");
		this.setOption("format", "xml");
	}

	public String getBaseUrl() {
		return "http://boss.yahooapis.com/ysearch/web/v1/";
	}

}
