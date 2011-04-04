package fit5030.ass.one.searchclient.video.youtube;

import fit5030.ass.one.searchclient.base.AbstractQuery;

public class YoutubeSearchQuery extends AbstractQuery {

	@Override
	public String getBaseUrl() {
		return "http://gdata.youtube.com/feeds/api/videos?q=";
	}

}
