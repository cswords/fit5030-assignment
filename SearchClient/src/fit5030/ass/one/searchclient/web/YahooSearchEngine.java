package fit5030.ass.one.searchclient.web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.List;
import java.io.*;
import java.util.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

import fit5030.ass.one.searchclient.base.AbstractSearchEngine;

public class YahooSearchEngine extends AbstractSearchEngine {

	@Override
	public List<WebSearchResultEntry> search(String request) {
		// TODO Auto-generated method stub
		try {

			HttpClient client = new HttpClient();
			GetMethod method = new GetMethod(request);

			// Send GET request
			int statusCode = client.executeMethod(method);

			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + method.getStatusLine());
			}
			InputStream rstream = null;

			// Get the response body
			rstream = method.getResponseBodyAsStream();

			// Process the response from Yahoo! Web Services
			/*
			 * BufferedReader br = new BufferedReader(new
			 * InputStreamReader(rstream)); String line; String reply=null;
			 * while ((line = br.readLine()) != null) { reply=reply+line; }
			 * br.close();
			 */

			List<WebSearchResultEntry> list = new Vector<WebSearchResultEntry>();

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(rstream);
			NodeList nl = doc.getElementsByTagName("result");
			for (int i = 0; i < nl.getLength(); i++) {
				/*
				 * System.out.println("Title:" +
				 * doc.getElementsByTagName("title").item(i)
				 * .getFirstChild().getNodeValue());
				 * System.out.println("Abstract:" +
				 * doc.getElementsByTagName("abstract").item(i)
				 * .getFirstChild().getNodeValue()); System.out.println("Url:" +
				 * doc.getElementsByTagName("url").item(i)
				 * .getFirstChild().getNodeValue()); System.out.println("Date:"
				 * + doc.getElementsByTagName("date").item(i)
				 * .getFirstChild().getNodeValue());
				 */
				WebSearchResultEntry result = new WebSearchResultEntry();
				result.setTitle(doc.getElementsByTagName("title").item(i)
						.getFirstChild().getNodeValue());
				result.setSummary(doc.getElementsByTagName("abstract").item(i)
						.getFirstChild().getNodeValue());
				result.setUrl(doc.getElementsByTagName("url").item(i)
						.getFirstChild().getNodeValue());
				SimpleDateFormat mydate = new java.text.SimpleDateFormat(
						"yyyy-MM-dd");
				result.setDate(mydate.parse(doc.getElementsByTagName("date").item(i)
						.getFirstChild().getNodeValue()));
				list.add(result);
			}
			return list;
		} catch (Exception e) {

		}
		return null;
	}

}
