package fit5030.ass.two.searchclient.webservice;

import java.util.Date;

import fit5030.ass.one.searchclient.base.SearchResultList;
import fit5030.ass.one.searchclient.image.ImageSearchResultEntry;
import fit5030.ass.one.searchclient.image.flickr.FlickrSearchEngine;
import fit5030.ass.one.searchclient.image.flickr.FlickrSearchQuery;
import fit5030.ass.one.searchclient.video.VideoSearchResultEntry;
import fit5030.ass.one.searchclient.video.youtube.YoutubeSearchEngine;
import fit5030.ass.one.searchclient.video.youtube.YoutubeSearchQuery;
import fit5030.ass.one.searchclient.web.WebSearchResultEntry;
import fit5030.ass.one.searchclient.web.google.GoogleWebSearchEngine;
import fit5030.ass.one.searchclient.web.google.GoogleWebSearchQuery;
import fit5030.ass.one.searchclient.web.yahoo.YahooWebSearchEngine;
import fit5030.ass.one.searchclient.web.yahoo.YahooWebSearchQuery;
import fit5030.ass.two.searchclient.comment.CommentSearchResultEntry;
import fit5030.ass.two.searchclient.comment.twitter.TwitterCommentSearchEngine;
import fit5030.ass.two.searchclient.comment.twitter.TwitterCommentSearchQuery;
import fit5030.ass.two.searchclient.util.GenericArray;

public class Ajax extends AjaxBase {

	private <T> T[] copyCollectionToArray(final Iterable<T> collection) {
		GenericArray<T> a = new GenericArray<T>(collection);
		return a.getArray();
	}

	public static class WebSearchResult extends PagingAjaxQueryResult {

		public WebSearchResult() {
			this.setFormat("HTML");
		}

		private WebSearchResultEntry[] searchResultList;

		public void setSearchResultList(WebSearchResultEntry[] searchResultList) {
			this.searchResultList = searchResultList;
		}

		public WebSearchResultEntry[] getSearchResultList() {
			return searchResultList;
		}

		private String content;

		@Override
		public String getContent() {
			return this.content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}

	public static class WebSearchQuery extends PagingAjaxQuery {

		public WebSearchQuery() {
			this.setFormat("HTML");
		}

		private String queryName;

		@Override
		public String getQueryName() {
			return this.queryName;
		}

		private String queryInput;

		public String getQueryInput() {
			return queryInput;
		}

		public void setQueryInput(String queryInput) {
			this.queryInput = queryInput;
		}

		public void setQueryName(String queryName) {
			this.queryName = queryName;
		}

	}

	public WebSearchResult webSearch(WebSearchQuery query) {
		WebSearchResult result = new WebSearchResult();
		if (query.getQueryName().equals("Yahoo")) {
			YahooWebSearchEngine e = new YahooWebSearchEngine();
			YahooWebSearchQuery q = new YahooWebSearchQuery();
			q.setQueryInput(query.getQueryInput());

			SearchResultList<WebSearchResultEntry> r = e.search(q,
					query.getPageSize(), query.getPageNumber());
			result.setPageNumber(r.getPageNumber());
			result.setPageSize(r.getPageSize());
			result.setSearchResultList(this.copyCollectionToArray(r));
			result.setContent(r.toString());
		} else {

			GoogleWebSearchEngine e = new GoogleWebSearchEngine();
			GoogleWebSearchQuery q = new GoogleWebSearchQuery();
			q.setQueryInput(query.getQueryInput());

			SearchResultList<WebSearchResultEntry> r = e.search(q,
					query.getPageSize(), query.getPageNumber());
			result.setPageNumber(r.getPageNumber());
			result.setPageSize(r.getPageSize());
			result.setSearchResultList(this.copyCollectionToArray(r));
			result.setContent(r.toString());
		}
		return result;
	}

	public static class ImageSearchResult extends PagingAjaxQueryResult {

		public ImageSearchResult() {
			this.setFormat("HTML");
		}

		private ImageSearchResultEntry[] searchResultList;

		public void setSearchResultList(
				ImageSearchResultEntry[] searchResultList) {
			this.searchResultList = searchResultList;
		}

		public ImageSearchResultEntry[] getSearchResultList() {
			return searchResultList;
		}

		private String content;

		@Override
		public String getContent() {
			return this.content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}

	public static class ImageSearchQuery extends PagingAjaxQuery {

		public ImageSearchQuery() {
			this.setFormat("HTML");
		}

		private String queryName;

		@Override
		public String getQueryName() {
			return this.queryName;
		}

		private String queryInput;

		public String getQueryInput() {
			return queryInput;
		}

		public void setQueryInput(String queryInput) {
			this.queryInput = queryInput;
		}

		public void setQueryName(String queryName) {
			this.queryName = queryName;
		}

		private Date start;

		public void setStart(Date start) {
			this.start = start;
		}

		public Date getStart() {
			return start;
		}

		private Date end;

		public void setEnd(Date end) {
			this.end = end;
		}

		public Date getEnd() {
			return end;
		}

	}

	public ImageSearchResult imageSearch(ImageSearchQuery query) {
		ImageSearchResult result = new ImageSearchResult();
		if (query.getQueryName().equals("Flickr")) {
			FlickrSearchEngine e = new FlickrSearchEngine();
			FlickrSearchQuery q = new FlickrSearchQuery();
			q.setQueryInput(query.getQueryInput());
			q.setMinUploadDate(query.getStart());
			q.setMaxUploadDate(query.getEnd());
			SearchResultList<ImageSearchResultEntry> r = e.search(q,
					query.getPageSize(), query.getPageNumber());
			result.setPageNumber(r.getPageNumber());
			result.setPageSize(r.getPageSize());
			result.setSearchResultList(this.copyCollectionToArray(r));
			result.setContent(r.toString());
		}
		return result;
	}

	public static class VideoSearchResult extends PagingAjaxQueryResult {

		public VideoSearchResult() {
			this.setFormat("HTML");
		}

		private VideoSearchResultEntry[] searchResultList;

		public void setSearchResultList(
				VideoSearchResultEntry[] searchResultList) {
			this.searchResultList = searchResultList;
		}

		public VideoSearchResultEntry[] getSearchResultList() {
			return searchResultList;
		}

		private String content;

		@Override
		public String getContent() {
			return this.content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}

	public static class VideoSearchQuery extends PagingAjaxQuery {

		public VideoSearchQuery() {
			this.setFormat("HTML");
		}

		private String queryName;

		@Override
		public String getQueryName() {
			return this.queryName;
		}

		private String queryInput;

		public String getQueryInput() {
			return queryInput;
		}

		public void setQueryInput(String queryInput) {
			this.queryInput = queryInput;
		}

		public void setQueryName(String queryName) {
			this.queryName = queryName;
		}

	}

	public VideoSearchResult videoSearch(VideoSearchQuery query) {
		VideoSearchResult result = new VideoSearchResult();
		if (query.getQueryName().equals("Youtube")) {
			YoutubeSearchEngine e = new YoutubeSearchEngine();
			YoutubeSearchQuery q = new YoutubeSearchQuery();
			q.setQueryInput(query.getQueryInput());

			SearchResultList<VideoSearchResultEntry> r = e.search(q,
					query.getPageSize(), query.getPageNumber());
			result.setPageNumber(r.getPageNumber());
			result.setPageSize(r.getPageSize());
			result.setSearchResultList(this.copyCollectionToArray(r));
			result.setContent(r.toString());
		}
		return result;
	}

	public static class SocialSearchResult extends AjaxQueryResult {

		public SocialSearchResult() {
			this.setFormat("HTML");
		}

		private String content;

		@Override
		public String getContent() {
			return this.content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		private int[] trend;
		
		public void setTrend(int[] trend) {
			this.trend = trend;
		}

		public int[] getTrend() {
			return trend;
		}
	}

	public static class SocialSearchQuery extends AjaxQuery {

		public SocialSearchQuery() {
			this.setFormat("HTML");
		}

		private String queryName;

		@Override
		public String getQueryName() {
			return this.queryName;
		}

		private String queryInput;

		public String getQueryInput() {
			return queryInput;
		}

		public void setQueryInput(String queryInput) {
			this.queryInput = queryInput;
		}

		public void setQueryName(String queryName) {
			this.queryName = queryName;
		}

		private int days = 5;

		public void setDays(int days) {
			this.days = days;
		}

		public int getDays() {
			return days;
		}

	}

	public SocialSearchResult socialSearch(SocialSearchQuery query) {
		SocialSearchResult result = new SocialSearchResult();
		if (query.getQueryName().equals("Twitter")) {
			TwitterCommentSearchEngine e = new TwitterCommentSearchEngine();
			TwitterCommentSearchQuery q = new TwitterCommentSearchQuery();
			q.setQueryInput(query.getQueryInput());
			q.setDays(query.getDays());
			fit5030.ass.two.searchclient.comment.SocialSearchResult r = e.search(q);
			result.setContent(r.toString());
			result.setTrend(r.getTrend());
		}
		return result;
	}
}
