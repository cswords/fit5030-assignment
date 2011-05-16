package fit5030.ass.two.searchclient.comment.twitter;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import fit5030.ass.one.searchclient.base.AbstractSearchEngine;
import fit5030.ass.one.searchclient.base.SearchResultList;
import fit5030.ass.two.searchclient.comment.CommentSearchResultEntry;
import fit5030.ass.two.searchclient.comment.SingleDaySocialSearchQuery;
import fit5030.ass.two.searchclient.comment.SocialSearchResult;

public class TwitterSingleDaySearchEngine
		extends
		AbstractSearchEngine<SingleDaySocialSearchQuery, CommentSearchResultEntry> {

	@Override
	public SearchResultList<CommentSearchResultEntry> search(
			SingleDaySocialSearchQuery query) {
		
		SocialSearchResult result = new SocialSearchResult();
		
		
		try {
			query.setOption("rpp", "100");
			
			
						
			HttpClient client = new HttpClient();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			int trend=0;
			
			for(int page=15;page>0;page--){
				query.setOption("page", String.valueOf(page));
				GetMethod method = new GetMethod(query.toString());
				int statusCode = client.executeMethod(method);
				InputStream rstream = null;
				rstream = method.getResponseBodyAsStream();
				Document doc = builder.parse(rstream);
				NodeList nl = doc.getElementsByTagName("entry");
				
				System.out.println("paqe="+page);
				if(nl.getLength()>=1){
					trend=100*(page-1)+nl.getLength();
					break;
				}
				
			}
	
			System.out.println("Total trend="+trend);
			System.out.println(query);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return result;
				
	}

	@Override
	public SearchResultList<CommentSearchResultEntry> search(
			SingleDaySocialSearchQuery query, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
