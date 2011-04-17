package fit5030.ass.one.searchclient.image.picasa;

import java.text.SimpleDateFormat;
import java.util.Date;

import fit5030.ass.one.searchclient.base.AbstractQuery;

public class PicasaSearchQuery extends AbstractQuery {
	public PicasaSearchQuery() {
	}

	public String getBaseUrl() {
		return "https://picasaweb.google.com/data/feed/api/all/?q=";

	}

	public void setMinPublishDate(Date from) {
		this.setOption("published-min",
				(new SimpleDateFormat("yyyy-MM-dd")).format(from)
						+ "T00:00:00.000Z");
	}

	public void setMaxPublishDate(Date to) {
		this.setOption("published-max",
				(new SimpleDateFormat("yyyy-MM-dd")).format(to)
						+ "T23:59:59.999Z");
	}

}
