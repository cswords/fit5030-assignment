package fit5030.ass.one.searchclient.web.google;

import java.io.InputStream;
import java.text.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import fit5030.ass.one.searchclient.base.*;
import fit5030.ass.one.searchclient.web.WebSearchResultEntry;

public class GoogleWebSearchEngine extends
		AbstractSearchEngine<GoogleWebSearchQuery, WebSearchResultEntry> {

	@Override
	public SearchResultList<WebSearchResultEntry> search(
			GoogleWebSearchQuery query) {
		SearchResultList<WebSearchResultEntry> result = new SearchResultList<WebSearchResultEntry>();

		try {

			HttpClient client = new HttpClient();
			GetMethod method = new GetMethod(query.toString());

			// Send GET request
			int statusCode = client.executeMethod(method);

			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + method.getStatusLine());
			}
			InputStream rstream = null;

			// Get the response body
			rstream = method.getResponseBodyAsStream();

			// Process the response from Google Web Services

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(rstream);

			NodeList nl = doc.getElementsByTagName("entry");

			for (int i = 0; i < nl.getLength(); i++) {

				WebSearchResultEntry entry = new WebSearchResultEntry();

				entry.setTitle(doc.getElementsByTagName("title").item(i)
						.getFirstChild().getNodeValue());
				entry.setSummary(doc.getElementsByTagName("summary").item(i)
						.getFirstChild().getNodeValue());
				entry.setUrl(doc.getElementsByTagName("id").item(i)
						.getFirstChild().getNodeValue());

				SimpleDateFormat mydate = new java.text.SimpleDateFormat(
						"yyyy-MM-dd");
				entry.setDate(mydate.parse(doc.getElementsByTagName("updated")
						.item(i).getFirstChild().getNodeValue()));

				result.add(entry);
			}
		} catch (Exception e) {

		}
		return result;
	}

}
