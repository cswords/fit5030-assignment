package fit5030.ass.two.searchclient.comment.twitter;

import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import fit5030.ass.one.searchclient.base.AbstractSearchEngine;
import fit5030.ass.one.searchclient.base.SearchResultList;
import fit5030.ass.two.searchclient.comment.CommentSearchResultEntry;
import fit5030.ass.two.searchclient.comment.SocialSearchResult;

public class TwitterCommentSearchEngine
		extends
		AbstractSearchEngine<TwitterCommentSearchQuery, CommentSearchResultEntry> {

	public SocialSearchResult search(
			TwitterCommentSearchQuery query) {
		SocialSearchResult result = new SocialSearchResult();

		try {
			HttpClient client = new HttpClient();
			GetMethod method = new GetMethod(query.toString());
			int statusCode = client.executeMethod(method);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + method.getStatusLine());
			}
			InputStream rstream = null;
			rstream = method.getResponseBodyAsStream();
			
			

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return result;
	}

	public SocialSearchResult search(
			TwitterCommentSearchQuery query, int pageSize, int pageNumber) {
		query.setOption("rpp", String.valueOf(pageSize));
		query.setOption("page", String.valueOf(pageNumber));
		
		System.out.println(query);
		
		SocialSearchResult result = this.search(query);
		result.setPageSize(pageSize);
		result.setPageNumber(pageNumber);
		return result;
	}

}
