package fit5030.ass.two.searchclient.webservice;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import fit5030.ass.two.searchclient.webservice.Ajax.*;

public class SimpleAjax {
	private Ajax ajax = new Ajax();

	public String webSearch(WebSearchQuery query) {
		return ajax.webSearch(query).getContent();
	}

	public String imageSearch(ImageSearchQuery query) {
		return ajax.imageSearch(query).getContent();
	}

	public String videoSearch(VideoSearchQuery query) {
		return ajax.videoSearch(query).getContent();
	}

	public String socialSearch(SocialSearchQuery query) {
		return ajax.socialSearch(query).getContent();
	}

	public String unifiedSearch(String jsonStr) throws JSONException,
			ParseException {
		UnifiedQuery q = UnifiedQuery.parseUnifiedQuery(jsonStr);
		WebSearchQuery wsq = q.toWebSearchQuery();
		if (wsq != null)
			return this.webSearch(wsq);
		ImageSearchQuery isq = q.toImageSearchQuery();
		if (isq != null)
			return this.imageSearch(isq);
		VideoSearchQuery vsq = q.toVideoSearchQuery();
		if (vsq != null)
			return this.videoSearch(vsq);
		SocialSearchQuery ssq = q.toSocialSearchQuery();
		if (ssq != null)
			return this.socialSearch(ssq);
		return "Your query is not supported.";
	}

	public static class UnifiedQuery {
		private static SimpleDateFormat dateFormat = new SimpleDateFormat(
				"dd/MM/yyyy");

		private String target;
		private String q;
		private Date from;// dd/MM/yyyy
		private Date to;// dd/MM/yyyy
		private int pageSize;
		private int pageNumber;
		private int days;

		public String getTarget() {
			return target;
		}

		public void setTarget(String target) {
			this.target = target;
		}

		public String getQ() {
			return q;
		}

		public void setQ(String q) {
			this.q = q;
		}

		public String getFrom() {
			return dateFormat.format(this.from);
		}

		public void setFrom(String from) throws ParseException {
			if (!(from.trim().length() == 0))
				this.from = dateFormat.parse(from);
		}

		public String getTo() {
			return dateFormat.format(this.to);
		}

		public void setTo(String to) throws ParseException {
			if (!(to.trim().length() == 0))
				this.to = dateFormat.parse(to);
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getPageNumber() {
			return pageNumber;
		}

		public void setPageNumber(int pageNumber) {
			this.pageNumber = pageNumber;
		}

		public int getDays() {
			return days;
		}

		public void setDays(int days) {
			this.days = days;
		}

		public WebSearchQuery toWebSearchQuery() {
			WebSearchQuery result = new WebSearchQuery();
			if (this.getTarget().equals("Google")
					| this.getTarget().equals("Yahoo")) {
				result.setFormat("HTML");
				result.setPageNumber(this.getPageNumber());
				result.setPageSize(this.getPageSize());
				result.setQueryInput(this.getQ());
				result.setQueryName(this.getTarget());
				return result;
			} else
				return null;
		}

		public ImageSearchQuery toImageSearchQuery() {
			ImageSearchQuery result = new ImageSearchQuery();
			if (this.getTarget().equals("Flickr")) {
				result.setFormat("HTML");
				result.setPageNumber(this.getPageNumber());
				result.setPageSize(this.getPageSize());
				result.setQueryInput(this.getQ());
				result.setQueryName(this.getTarget());
				result.setStart(this.from);
				result.setEnd(this.to);
				return result;
			} else
				return null;
		}

		public VideoSearchQuery toVideoSearchQuery() {
			VideoSearchQuery result = new VideoSearchQuery();
			if (this.getTarget().equals("Youtube")) {
				result.setFormat("HTML");
				result.setPageNumber(this.getPageNumber());
				result.setPageSize(this.getPageSize());
				result.setQueryInput(this.getQ());
				result.setQueryName(this.getTarget());
				return result;
			} else
				return null;
		}

		public SocialSearchQuery toSocialSearchQuery() {
			SocialSearchQuery result = new SocialSearchQuery();
			if (this.getTarget().equals("Twitter")) {
				result.setFormat("HTML");
				result.setQueryInput(this.getQ());
				result.setQueryName(this.getTarget());
				result.setDays(this.getDays());
				return result;
			} else
				return null;
		}

		public String toJSONString() {
			JSONObject jo = new JSONObject(this);
			return jo.toString();
		}

		public static UnifiedQuery parseUnifiedQuery(String jsonStr)
				throws JSONException, ParseException {
			JSONObject jo = new JSONObject(jsonStr);
			UnifiedQuery result = new UnifiedQuery();
			try {
				result.setDays(jo.getInt("days"));
			} catch (JSONException e) {
			}
			try {
				result.setFrom(jo.getString("from"));
			} catch (JSONException e) {
			}
			try {
				result.setPageNumber(jo.getInt("pageNumber"));
			} catch (JSONException e) {
			}
			try {
				result.setPageSize(jo.getInt("pageSize"));
			} catch (JSONException e) {
			}
			try {
				String q = jo.getString("q");
				if (q != null)
					result.setQ(java.net.URLDecoder.decode(q, "UTF-8").replace(
							' ', '+'));
			} catch (JSONException e) {
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			try {
				result.setTarget(jo.getString("target"));
			} catch (JSONException e) {
			}
			try {
				result.setTo(jo.getString("to"));
			} catch (JSONException e) {
			}
			return result;
		}
	}
}
