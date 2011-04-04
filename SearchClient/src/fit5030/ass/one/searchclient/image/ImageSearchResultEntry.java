package fit5030.ass.one.searchclient.image;

import fit5030.ass.one.searchclient.base.ISearchResultEntry;

public class ImageSearchResultEntry implements ISearchResultEntry {
	protected String url;
	protected String title;
	protected String originalUrl;

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {
		String result = "<td>" + this.getTitle() + "<br>" + "<a href="
				+ this.getOriginalUrl() + ">" + "<img src=" + this.getUrl()
				+ "></img>" + "</a></td>";

		return result;
	}

}
