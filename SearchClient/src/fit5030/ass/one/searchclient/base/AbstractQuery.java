package fit5030.ass.one.searchclient.base;

import java.util.*;

public abstract class AbstractQuery {
	Map<String, String> queryParams = new HashMap<String, String>();

	public void setOption(String key, String value) {
		this.queryParams.put(key, value);
	}

	String queryInput;

	public String getQueryInput() {
		return queryInput;
	}

	public void setQueryInput(String queryInput) {
		this.queryInput = queryInput;
	}

	public abstract String getBaseUrl();

	public String toString() {
		String result = this.getBaseUrl();
		result += this.getQueryInput();
		for (Map.Entry<String, String> entry : this.queryParams.entrySet()) {
			if (result.contains("?")) {
				result += "&";
			} else {
				result += "?";
			}
			result += entry.getKey() + "=" + entry.getValue();
		}
		return result;
	}
}
