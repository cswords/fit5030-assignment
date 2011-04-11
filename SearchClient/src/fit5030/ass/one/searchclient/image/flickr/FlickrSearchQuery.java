package fit5030.ass.one.searchclient.image.flickr;

import fit5030.ass.one.searchclient.base.AbstractQuery;

public class FlickrSearchQuery extends AbstractQuery {
	public FlickrSearchQuery() {
		this.setOption("method", "flickr.photos.search");
		this.setOption("api_key", "67f5b764236ad3530f13ec933453662a");

		// this.setOption("min_upload_date","2011/04/11");
		this.setOption("max_upload_date", "2010/04/11");
		// this.setOption("min_taken_date","");
		// this.setOption("max_taken_date","");
		// this.setOption("format", "xmlrpc");
	}

	public String getBaseUrl() {
		return "http://api.flickr.com/services/rest/?text=";
	}

}
