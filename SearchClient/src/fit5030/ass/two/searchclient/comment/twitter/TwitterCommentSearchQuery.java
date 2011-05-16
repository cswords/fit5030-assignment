package fit5030.ass.two.searchclient.comment.twitter;

import java.text.SimpleDateFormat;
import java.util.Date;

import fit5030.ass.one.searchclient.base.AbstractQuery;

public class TwitterCommentSearchQuery extends AbstractQuery {
	public TwitterCommentSearchQuery() {

	}

	public String getBaseUrl() {

		return "http://search.twitter.com/search.atom?q=";
	}

	public void setMinCommentDate(Date from) {
		this.setOption("since",
				(new SimpleDateFormat("yyyy-MM-dd")).format(from));
	}

	public void setMaxCommentDate(Date to) {
		this.setOption("until", 
				(new SimpleDateFormat("yyyy-MM-dd")).format(to));
	}

}
