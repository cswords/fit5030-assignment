package fit5030.ass.two.searchclient.comment.twitter;

import java.text.SimpleDateFormat;
import java.util.Date;

import fit5030.ass.two.searchclient.comment.SingleDaySocialSearchQuery;

public class TwitterSingleDaySearchQuery extends SingleDaySocialSearchQuery {

	@Override
	public String getBaseUrl() {
		return "http://search.twitter.com/search.atom?q=";
	}
	@Override
	public void setDate(Date date) {
		this.setOption("since",
				(new SimpleDateFormat("yyyy-MM-dd")).format(date.getTime()-86400*1000));
		this.setOption("until",
				(new SimpleDateFormat("yyyy-MM-dd")).format(date));

	}

}
