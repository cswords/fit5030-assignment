package fit5030.ass.one.searchclient.web.google;

import java.io.InputStream;
import java.text.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fit5030.ass.one.searchclient.base.*;
import fit5030.ass.one.searchclient.web.WebSearchResultEntry;

public class GoogleWebSearchEngine extends
		AbstractSearchEngine<GoogleWebSearchQuery, WebSearchResultEntry> {

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

				NodeList l = nl.item(i).getChildNodes();

				for (int j = 0; j < l.getLength(); j++) {
					Node n = l.item(j);
					if (n.getNodeName() == "title") {
						entry.setTitle(this.GetXmlNodeValue(n));
					} else if (n.getNodeName() == "summary") {
						entry.setSummary(this.GetXmlNodeValue(n));
					} else if (n.getNodeName() == "id") {
						entry.setUrl(this.GetXmlNodeValue(n));
					} else if (n.getNodeName() == "updated") {
						SimpleDateFormat mydate = new java.text.SimpleDateFormat(
								"yyyy-MM-dd");
						entry.setDate(mydate.parse(this.GetXmlNodeValue(n)));
					}
				}

				result.add(entry);
			}
		} catch (Exception e) {
			System.out.println(e.getClass().toString() + ":" + e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return result;
	}

	@Override
	public SearchResultList<WebSearchResultEntry> search(
			GoogleWebSearchQuery query, int pageSize, int pageNumber) {
		
		query.setOption("start", (pageSize * (pageNumber - 1) + 1) + "");
		query.setOption("num", pageSize + "");

		SearchResultList<WebSearchResultEntry> result = this.search(query);
		result.setPageNumber(pageNumber);
		result.setPageSize(pageSize);
		return result;
	}

}
