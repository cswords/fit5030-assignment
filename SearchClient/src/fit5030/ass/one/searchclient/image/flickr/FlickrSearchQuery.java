package fit5030.ass.one.searchclient.image.flickr;

import java.text.SimpleDateFormat;
import java.util.Date;

import fit5030.ass.one.searchclient.base.AbstractQuery;

public class FlickrSearchQuery extends AbstractQuery {
	public FlickrSearchQuery() {
		this.setOption("method", "flickr.photos.search");
		this.setOption("api_key", "67f5b764236ad3530f13ec933453662a");
	}

	public String getBaseUrl() {
		return "http://api.flickr.com/services/rest/?text=";
	}

	public void setMinUploadDate(Date from) {
		this.setOption("min_upload_date",
				(new SimpleDateFormat("yyyy/MM/dd")).format(from));
	}

	public void setMaxUploadDate(Date to) {
		this.setOption("max_upload_date",
				(new SimpleDateFormat("yyyy/MM/dd")).format(to));
	}
}
