package fit5030.ass.one.searchclient.base;

import java.util.*;

public class SearchResultList<T extends ISearchResultEntry> implements
		Iterable<T> {

	protected int pageSize = 1;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	protected int pageNumber = -1;

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	protected List<T> resultList = new LinkedList<T>();

	@Override
	public Iterator<T> iterator() {
		return this.resultList.iterator();
	}

	public void add(T entry) {
		this.resultList.add(entry);
	}

	public String toString() {
		String result = "<table class='searchresult' width='100%'>\n";
		boolean nodata = true;
		for (ISearchResultEntry entry : this) {
			nodata = false;
			result += "<tr>\n" + entry.toString() + "</tr>\n";
		}
		if (nodata) {
			result += "<tr>\n<b>So sorry, no search result.</b></tr>\n";
		}
		result += "</table>";
		return result;
	}
}
