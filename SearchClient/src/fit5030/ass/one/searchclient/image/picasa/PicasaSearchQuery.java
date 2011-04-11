package fit5030.ass.one.searchclient.image.picasa;

import fit5030.ass.one.searchclient.base.AbstractQuery;

public class PicasaSearchQuery extends AbstractQuery {
	public PicasaSearchQuery() {
		// this.setOption("prettyprint", "true");
	//	this.setOption("updated-min", "2008-11-13");
	//	this.setOption("updated-max", "2008-12-15T00:01:25.000Z");
		this.setOption("published-min", "2001-12-16T00:00:00.000Z");
		this.setOption("published-max", "2010-12-15T00:00:00.000Z");

	}

	public String getBaseUrl() {
		return "https://picasaweb.google.com/data/feed/api/all/?q=";

	}

}
