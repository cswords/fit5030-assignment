package fit5030.ass.one.searchclient.video;

import java.util.*;

import fit5030.ass.one.searchclient.base.ISearchResultEntry;

public class VideoSearchResultEntry implements ISearchResultEntry {
	protected Date date;
	protected String title;
	protected String text;
	protected String embedFlashCode;

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getEmbedFlashCode() {
		return embedFlashCode;
	}

	public void setEmbedFlashCode(String embedFlashCode) {
		this.embedFlashCode = embedFlashCode;
	}

	public String toString() {
		String result = "<td>" + this.getTitle() + "<br/>"
				+ this.getEmbedFlashCode() + "</td>\n";
		return result;

	}
}
