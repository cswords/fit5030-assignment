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

	public String webSearch(UnifiedQuery query) {
		WebSearchQuery q = query.toWebSearchQuery();
		if (q != null)
			return ajax.webSearch(q).getContent();
		else
			return "Not supported";
	}

	public String imageSearch(UnifiedQuery query) {
		ImageSearchQuery q = query.toImageSearchQuery();
		if (q != null)
			return ajax.imageSearch(q).getContent();
		else
			return "Not supported";
	}

	public String videoSearch(UnifiedQuery query) {
		VideoSearchQuery q = query.toVideoSearchQuery();
		if (q != null)
			return ajax.videoSearch(q).getContent();
		else
			return "Not supported";
	}

	public String socialSearch(UnifiedQuery query) {
		SocialSearchQuery q = query.toSocialSearchQuery();
		if (q != null)
			return ajax.socialSearch(q).getContent();
		else
			return "Not supported";
	}

	public String unifiedSearch(String jsonStr) throws JSONException,
			ParseException {
		UnifiedQuery q = UnifiedQuery.parseUnifiedQuery(jsonStr);
		WebSearchQuery wsq = q.toWebSearchQuery();
		if (wsq != null)
			return ajax.webSearch(wsq).getContent();
		ImageSearchQuery isq = q.toImageSearchQuery();
		if (isq != null)
			return ajax.imageSearch(isq).getContent();
		VideoSearchQuery vsq = q.toVideoSearchQuery();
		if (vsq != null)
			return ajax.videoSearch(vsq).getContent();
		SocialSearchQuery ssq = q.toSocialSearchQuery();
		if (ssq != null)
			return ajax.socialSearch(ssq).getContent();
		return "Your query is not supported.";
	}
}
