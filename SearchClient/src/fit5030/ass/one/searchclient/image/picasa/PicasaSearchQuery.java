package fit5030.ass.one.searchclient.image.picasa;

import fit5030.ass.one.searchclient.base.AbstractQuery;

public class PicasaSearchQuery extends AbstractQuery {
	public PicasaSearchQuery() {
		this.setOption("published-min", "2001-12-16T00:00:00.000Z");
		this.setOption("published-max", "2010-12-15T23:59:59.000Z");
	}

	public String getBaseUrl() {
		return "https://picasaweb.google.com/data/feed/api/all/?q=";

	}

}
