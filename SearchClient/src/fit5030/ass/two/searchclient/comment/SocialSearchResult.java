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
		for (int i = 0; i < this.getDays(); i++) {
			if (i == 0)
				result += "<tr>\n"
						+ "<td>Today: </td><td>"
						+ ((this.trend[i] < 1500) ? this.trend[i]
								: "very hot!(>=1500)") + "</td>\n" + "</tr>\n";
			else if (i == 1)
				result += "<tr>\n"
						+ "<td>Yesterday: </td><td>"
						+ ((this.trend[i] < 1500) ? this.trend[i]
								: "very hot!(>=1500)") + "</td>\n" + "</tr>\n";
			else
				result += "<tr>\n"
						+ "<td>"
						+ i
						+ " days before: </td><td>"
						+ ((this.trend[i] < 1500) ? this.trend[i]
								: "very hot!(>=1500)") + "</td>\n" + "</tr>\n";
		}
		result += "</table>";

		return result;
	}

}
