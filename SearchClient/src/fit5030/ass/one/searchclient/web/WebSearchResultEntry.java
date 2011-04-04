package fit5030.ass.one.searchclient.web;

import java.util.*;

import fit5030.ass.one.searchclient.base.ISearchResultEntry;

public class WebSearchResultEntry implements ISearchResultEntry {
	protected String summary;
	protected String url;
	protected Date date;
	protected String title;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {
		String result = "<td>" + this.getTitle() + "</td>\n";
		result += "<td><a href='" + this.getUrl() + "'>" + this.getSummary()
				+ "</a></td>\n";
		return result;
	}
}
