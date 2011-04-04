package fit5030.ass.one.searchclient.video.youtube;

import java.io.InputStream;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fit5030.ass.one.searchclient.base.*;
import fit5030.ass.one.searchclient.video.VideoSearchResultEntry;

public class YoutubeSearchEngine extends
		AbstractSearchEngine<YoutubeSearchQuery, VideoSearchResultEntry> {

	@Override
	public SearchResultList<VideoSearchResultEntry> search(
			YoutubeSearchQuery query) {
		SearchResultList<VideoSearchResultEntry> result = new SearchResultList<VideoSearchResultEntry>();

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

				VideoSearchResultEntry entry = new VideoSearchResultEntry();

				NodeList l = nl.item(i).getChildNodes();

				for (int j = 0; j < l.getLength(); j++) {
					Node n = l.item(j);
					if (n.getNodeName() == "title") {
						entry.setTitle(this.GetXmlNodeValue(n));
					} else if (n.getNodeName() == "content") {
						entry.setText(this.GetXmlNodeValue(n));
					} else if (n.getNodeName() == "id") {
						String t = "";
						t += "<object width=\"640\" height=\"390\">";
						t += "	<param name=\"movie\"";
						t += "		value=\"http://www.youtube.com/v/****?fs=1&amp;hl=en_US\"></param>";
						t += "	<param name=\"allowFullScreen\" value=\"true\"></param>";
						t += "	<param name=\"allowscriptaccess\" value=\"always\"></param>";
						t += "	<embed wmode=\"opaque\"";
						t += "		src=\"http://www.youtube.com/v/Lfso7_i9Ko8?fs=1&amp;hl=en_US\" type=\"application/x-shockwave-flash\"";
						t += "		allowscriptaccess=\"always\" allowfullscreen=\"true\" width=\"640\" height=\"390\"></embed>";
						t += "</object>";
						String a = this.GetXmlNodeValue(n);
						t = t.replace("****", a.replace(
								"http://gdata.youtube.com/feeds/api/videos/",
								""));
						entry.setEmbedFlashCode(t);
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

}
