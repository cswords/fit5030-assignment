package fit5030.ass.one.searchclient.image.flickr;

import fit5030.ass.one.searchclient.base.AbstractQuery;

public class FlickrSearchQuery extends AbstractQuery {
	public FlickrSearchQuery(){
		this.setOption("method","flickr.photos.search");
		this.setOption("api_key", "67f5b764236ad3530f13ec933453662a");
	//	this.setOption("format", "xmlrpc");
	}
	
	
	public String getBaseUrl() {
		return "http://api.flickr.com/services/rest/?tags=";
	}

}
