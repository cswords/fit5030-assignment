package fit5030.ass.one.searchclient.web.google;

import fit5030.ass.one.searchclient.base.AbstractQuery;

public class GoogleWebSearchQuery extends AbstractQuery {

	public GoogleWebSearchQuery() {
		this.setOption("key", "AIzaSyD2c6QpxMauz_Bj_CbC0vLM_Fia5r86fb0");
		this.setOption("cx", "016673009104692472454:i8uofzr7dam");
		this.setOption("alt", "atom");
	}

	@Override
	public String getBaseUrl() {
		return "https://www.googleapis.com/customsearch/v1?q=";
	}

}
