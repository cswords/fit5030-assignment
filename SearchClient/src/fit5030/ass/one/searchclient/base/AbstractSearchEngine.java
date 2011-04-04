package fit5030.ass.one.searchclient.base;

import org.w3c.dom.Node;

public abstract class AbstractSearchEngine<Q extends AbstractQuery, R extends ISearchResultEntry> {
	public abstract SearchResultList<R> search(Q query);

	public String GetXmlNodeValue(Node node) {
		if (node.getNodeValue() != null) {
			return node.getNodeValue();
		} else {
			return node.getTextContent();
		}
	}
}
