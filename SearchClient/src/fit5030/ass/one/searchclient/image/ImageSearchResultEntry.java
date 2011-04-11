package fit5030.ass.one.searchclient.image;

import fit5030.ass.one.searchclient.base.ISearchResultEntry;

public class ImageSearchResultEntry implements ISearchResultEntry {
	protected String thumbUrl;
	protected String title;
	protected String photoUrl;


	public String getThumbUrl() {
		return thumbUrl;
	}


	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPhotoUrl() {
		return photoUrl;
	}


	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}


	public String toString() {
		String result = "<td>" + this.getTitle() + "<br>" + "<a href="
				+ this.getPhotoUrl() + ">" + "<img src=" + this.getThumbUrl()
				+ "></img>" + "</a></td>";

		return result;
	}


}
