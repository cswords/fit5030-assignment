package fit5030.ass.one.searchclient.image.picasa;

import fit5030.ass.one.searchclient.base.AbstractQuery;

public class PicasaSearchQuery extends AbstractQuery {
	public PicasaSearchQuery(){
		
	}
		
	public String getBaseUrl() {
		return "https://picasaweb.google.com/data/feed/api/all/?q=";

	}

}
