package fit5030.ass.one.searchclient.ui;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.*;

import fit5030.ass.one.searchclient.image.flickr.*;
import fit5030.ass.one.searchclient.image.picasa.*;
import fit5030.ass.one.searchclient.video.youtube.*;
import fit5030.ass.one.searchclient.web.google.*;
import fit5030.ass.one.searchclient.web.yahoo.*;

@SuppressWarnings("serial")
public class Service extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		resp.setContentType("text/html");

		String respHtml = "";

		try {
			QueryType queryType = QueryType.parse(req.getParameter("qtype"));
			int pageSize = Integer.parseInt(req.getParameter("size"));
			int pageNumber = Integer.parseInt(req.getParameter("page"));
			String query = req.getParameter("q");
			query = URLEncoder.encode(query, "UTF-8");

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			String fromStr = req.getParameter("from");
			Date fromDate = null;
			if (fromStr != null)
				if (fromStr.trim().length() > 0)
					fromDate = df.parse(fromStr);

			String toStr = req.getParameter("to");
			Date toDate = null;
			if (toStr != null)
				if (toStr.trim().length() > 0)
					toDate = df.parse(toStr);

			switch (queryType) {
			case GoogleWeb:
				respHtml = this.googleweb(query, pageSize, pageNumber);
				break;
			case YahooWeb:
				respHtml = this.yahooweb(query, pageSize, pageNumber);
				break;
			case Youtube:
				respHtml = this.youtube(query, pageSize, pageNumber);
				break;
			case Flickr:
				respHtml = this.flickr(query, pageSize, pageNumber, fromDate,
						toDate);
				break;
			case Picasa:
				respHtml = this.picasa(query, pageSize, pageNumber, fromDate,
						toDate);
				break;
			default:
				throw new UnsupportedOperationException(
						"Query type not supported.");
			}

			resp.getWriter().print(respHtml);
		} catch (IllegalArgumentException e) {
			resp.getOutputStream().print(
					"Please check the parameters of your request.");
		} catch (ParseException e) {
			resp.getOutputStream().print(
					"Please check the parameters of your request.");
		}
	}

	private String googleweb(String query, int pageSize, int pageNumber) {
		GoogleWebSearchQuery q = new GoogleWebSearchQuery();
		q.setQueryInput(query);
		GoogleWebSearchEngine e = new GoogleWebSearchEngine();
		return e.search(q, pageSize, pageNumber).toString();
	}

	private String yahooweb(String query, int pageSize, int pageNumber) {
		YahooWebSearchQuery q = new YahooWebSearchQuery();
		q.setQueryInput(query);
		YahooWebSearchEngine e = new YahooWebSearchEngine();
		return e.search(q, pageSize, pageNumber).toString();
	}

	private String youtube(String query, int pageSize, int pageNumber) {
		YoutubeSearchQuery q = new YoutubeSearchQuery();
		q.setQueryInput(query);
		YoutubeSearchEngine e = new YoutubeSearchEngine();
		return e.search(q, pageSize, pageNumber).toString();
	}

	private String flickr(String query, int pageSize, int pageNumber,
			Date from, Date to) {
		FlickrSearchQuery q = new FlickrSearchQuery();
		q.setQueryInput(query);
		if (from != null & to != null) {
			q.setMinUploadDate(from);
			q.setMaxUploadDate(to);
		}
		FlickrSearchEngine e = new FlickrSearchEngine();
		return e.search(q, pageSize, pageNumber).toString();
	}

	private String picasa(String query, int pageSize, int pageNumber,
			Date from, Date to) {
		PicasaSearchQuery q = new PicasaSearchQuery();
		q.setQueryInput(query);
		if (from != null & to != null) {
			q.setMinPublishDate(from);
			q.setMaxPublishDate(to);
		}
		PicasaSearchEngine e = new PicasaSearchEngine();
		return e.search(q, pageSize, pageNumber).toString();
	}

	enum QueryType {
		GoogleWeb, YahooWeb, Youtube, Flickr, Picasa;
		public static QueryType parse(String name) {
			if (name.equalsIgnoreCase("googleweb"))
				return GoogleWeb;
			else if (name.equalsIgnoreCase("yahooweb"))
				return YahooWeb;
			else if (name.equalsIgnoreCase("youtube"))
				return Youtube;
			else if (name.equalsIgnoreCase("flickr"))
				return Flickr;
			else if (name.equalsIgnoreCase("picasa"))
				return Picasa;
			else
				throw new IllegalArgumentException("Unknow query type.");
		}
	}

	public static String getUrl(HttpServletRequest req) {
		String reqUrl = req.getRequestURL().toString();
		String queryString = req.getQueryString(); // d=789
		if (queryString != null) {
			reqUrl += "?" + queryString;
		}
		return reqUrl;
	}

}
