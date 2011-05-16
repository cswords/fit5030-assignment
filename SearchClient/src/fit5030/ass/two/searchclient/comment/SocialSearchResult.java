package fit5030.ass.two.searchclient.comment;

import fit5030.ass.one.searchclient.base.SearchResultList;

public class SocialSearchResult extends
		SearchResultList<CommentSearchResultEntry> {

	protected int[] trend = null;

	public int getDays() {
		if (trend == null)
			return -1;
		else
			return trend.length;
	}

	public void setDays(int days) {
		trend = new int[days];
	}

	public int[] getTrend() {
		return trend;
	}
	
	public void setTrend(int days,int trend){
		this.trend[days]=trend;
	}
	
	
}
