package fit5030.ass.two.searchclient.comment;

import java.util.Date;

import fit5030.ass.one.searchclient.base.ISearchResultEntry;

public class CommentSearchResultEntry implements ISearchResultEntry{
	protected String auther;
	protected Date date;
	protected String title;
	protected String titleUrl;
	protected String thumbPic;
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
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
	public String getTitleUrl() {
		return titleUrl;
	}
	public void setTitleUrl(String titleUrl) {
		this.titleUrl = titleUrl;
	}
	public String getThumbPic() {
		return thumbPic;
	}
	public void setThumbPic(String thumbPic) {
		this.thumbPic = thumbPic;
	}
	
	public String toString(){
		String result=null;
		
		return result;
	}
	
	
	
	
}
