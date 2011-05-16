package fit5030.ass.two.searchclient.comment;

import fit5030.ass.one.searchclient.base.SearchResultList;

public class SingleDaySocialSearchResult extends
		SearchResultList<CommentSearchResultEntry> {

	protected int trend = 0;

	public int getTrend() {
		return trend;
	}

	public void setTrend(int trend) {
		this.trend = trend;
	}

}
