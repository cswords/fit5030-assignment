package fit5030.ass.two.searchclient.comment.twitter;

import java.text.SimpleDateFormat;
import java.util.Date;
import fit5030.ass.two.searchclient.comment.SocialSearchQuery;

public class TwitterCommentSearchQuery extends SocialSearchQuery {
	public TwitterCommentSearchQuery() {

	}

	public String getBaseUrl() {

		return "http://search.twitter.com/search.atom?q=";
	}

	protected void setMinCommentDate(Date from) {
		this.setOption("since",
				(new SimpleDateFormat("yyyy-MM-dd")).format(from));
	}

	protected void setMaxCommentDate(Date to) {
		this.setOption("until", (new SimpleDateFormat("yyyy-MM-dd")).format(to));
	}

}
