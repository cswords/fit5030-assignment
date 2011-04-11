package fit5030.ass.one.searchclient.image.flickr;

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
import fit5030.ass.one.searchclient.image.ImageSearchResultEntry;

public class FlickrSearchEngine extends
		AbstractSearchEngine<FlickrSearchQuery, ImageSearchResultEntry> {

	public SearchResultList<ImageSearchResultEntry> search(
			FlickrSearchQuery query) {
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

			// Process the response from Google Web Services
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(rstream);

			NodeList nl = doc.getElementsByTagName("photo");

			for (int i = 0; i < nl.getLength(); i++) {
				ImageSearchResultEntry entry = new ImageSearchResultEntry();
				String photo_id = this.GetXmlNodeValue(nl.item(i)
						.getAttributes().getNamedItem("id"));
				String secret = this.GetXmlNodeValue(nl.item(i).getAttributes()
						.getNamedItem("secret"));
				String farm_id = this.GetXmlNodeValue(nl.item(i)
						.getAttributes().getNamedItem("farm"));
				String server_id = this.GetXmlNodeValue(nl.item(i)
						.getAttributes().getNamedItem("server"));
				String title = this.GetXmlNodeValue(nl.item(i).getAttributes()
						.getNamedItem("title"));
				String owner = this.GetXmlNodeValue(nl.item(i).getAttributes()
						.getNamedItem("owner"));
				entry.setTitle(title);
				entry.setThumbUrl("http://farm" + farm_id
						+ ".static.flickr.com/" + server_id + "/" + photo_id
						+ "_" + secret + "_s" + ".jpg");
				entry.setPhotoUrl("http://farm" + farm_id
						+ ".static.flickr.com/" + server_id + "/" + photo_id
						+ "_" + secret + ".jpg");
				result.add(entry);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	public SearchResultList<ImageSearchResultEntry> search(
			FlickrSearchQuery query, int pageSize, int pageNumber) {

		query.setOption("per_page", String.valueOf(pageSize)); // number of pics
																// per page
		query.setOption("page", String.valueOf(pageNumber)); // index of page
																// default=1
			
		SearchResultList<ImageSearchResultEntry> result = this.search(query);

		
		result.setPageSize(pageSize);
		result.setPageNumber(pageNumber);
		return result;
	}

}
