package fit5030.ass.one.searchclient.base;

import java.util.*;

public class SearchResultList<T extends ISearchResultEntry> implements
		Iterable<T> {
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	protected int pageNumber = -1;
	protected List<T> resultList = new LinkedList<T>();

	@Override
	public Iterator<T> iterator() {
		return this.resultList.iterator();
	}
}
