package fit5030.ass.two.searchclient.comment;

import fit5030.ass.one.searchclient.base.ISearchResultEntry;
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

	public String toString() {
		String result = "<table>\n";
		for (int i=0;i<this.getDays();i++) {
			result += "<tr>\n" +"<td>Number of comment on Day " + this.getDays() + "="
			+ this.trend[i] + "</td>\n" + "</tr>\n";
		}
		result += "</table>";
		
		return result;
	}

}
