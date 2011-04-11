package fit5030.ass.one.searchclient.image.picasa;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fit5030.ass.one.searchclient.base.AbstractSearchEngine;
import fit5030.ass.one.searchclient.base.SearchResultList;
import fit5030.ass.one.searchclient.image.ImageSearchResultEntry;

public class PicasaSearchEngine extends
		AbstractSearchEngine<PicasaSearchQuery, ImageSearchResultEntry> {

	public SearchResultList<ImageSearchResultEntry> search(
			PicasaSearchQuery query) {
		SearchResultList<ImageSearchResultEntry> result = new SearchResultList<ImageSearchResultEntry>();

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

			// Process the response from Picasa Services
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(rstream);

			NodeList nl = doc.getElementsByTagName("entry");
			
			for (int i = 0; i < nl.getLength(); i++) {
				ImageSearchResultEntry entry = new ImageSearchResultEntry();
				NodeList nl2 = nl.item(i).getChildNodes();
				for (int j = 0; j < nl2.getLength(); j++) {
					Node n2 = nl2.item(j);
					if (n2.getNodeName() == "title") {
						String title = this.GetXmlNodeValue(n2);
						entry.setTitle(title);
					} else if (n2.getNodeName() == "content") {
						String photoUrl = this.GetXmlNodeValue(n2
								.getAttributes().getNamedItem("src"));
						entry.setPhotoUrl(photoUrl);
					} else if (n2.getNodeName() == "media:group") {
						NodeList nl3 = nl2.item(j).getChildNodes();
						for (int k = 0; k < nl3.getLength(); k++) {
							Node n3 = nl3.item(k);
							if (n3.getNodeName() == "media:thumbnail") {
								String thumbUrl = this.GetXmlNodeValue(n3
										.getAttributes().getNamedItem("url"));
								entry.setThumbUrl(thumbUrl);
								break;
							}
						}
					}
				}
				result.add(entry);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	public SearchResultList<ImageSearchResultEntry> search(
			PicasaSearchQuery query, int pageSize, int pageNumber) {
		query.setOption("max-results", String.valueOf(pageSize)); // number of
																	// pics per
																	// page
		query.setOption("start-index",
				String.valueOf((pageNumber - 1) * pageSize + 1)); // index of
																	// page
																	// default=1
	
		SearchResultList<ImageSearchResultEntry> result = this.search(query);

		result.setPageSize(pageSize);
		result.setPageNumber(pageNumber);
		return result;
	}

}
