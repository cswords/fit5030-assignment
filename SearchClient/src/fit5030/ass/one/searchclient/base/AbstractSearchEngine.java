package fit5030.ass.one.searchclient.base;

public abstract class AbstractSearchEngine<Q extends AbstractQuery, R extends ISearchResultEntry> {
	public abstract SearchResultList<R> search(Q query);
}
