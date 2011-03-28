package fit5030.assignement.one.searchclient;

public class YahooWebSearchQuery {
	private String appid = "wLrDBTvV34GCv0NakiabQcDGxznW0GbscvtL5T.D6rABBC7QENo9v6a1xa2cFUtwBzgWcPv570.N";
	private String query;
	private YahooDocType format = YahooDocType.xml;
	private String requestBase = "http://boss.yahooapis.com/ysearch/web/v1/";

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public YahooDocType getFormat() {
		return format;
	}

	public void setFormat(YahooDocType format) {
		this.format = format;
	}

	public void setRequestBase(String requestBase) {
		this.requestBase = requestBase;
	}

	public String getRequestBase() {
		return requestBase;
	}

	public String toString() {
		return this.requestBase + this.query + "?appid=" + this.appid
				+ "&format=" + this.format;
	}
}
