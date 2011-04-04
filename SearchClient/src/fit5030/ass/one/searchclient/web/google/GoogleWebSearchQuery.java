package fit5030.ass.one.searchclient.web.google;

import fit5030.ass.one.searchclient.base.AbstractQuery;

public class GoogleWebSearchQuery extends AbstractQuery {

	public GoogleWebSearchQuery() {
		this.setOption("key", "AIzaSyDU9Sl7Bq2494UEqAEXdsJN3cM2qtUWthg");
		this.setOption("cx", "017576662512468239146:omuauf_lfve");
		this.setOption("alt", "atom");
	}

	@Override
	public String getBaseUrl() {
		return "https://www.googleapis.com/customsearch/v1?q=";
	}

}
