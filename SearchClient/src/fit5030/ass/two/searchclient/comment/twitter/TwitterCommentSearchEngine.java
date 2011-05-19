package fit5030.ass.two.searchclient.comment.twitter;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import fit5030.ass.one.searchclient.base.AbstractSearchEngine;
import fit5030.ass.two.searchclient.comment.CommentSearchResultEntry;
import fit5030.ass.two.searchclient.comment.SingleDaySocialSearchResult;
import fit5030.ass.two.searchclient.comment.SocialSearchQuery;
import fit5030.ass.two.searchclient.comment.SocialSearchResult;

public class TwitterCommentSearchEngine
		extends
		AbstractSearchEngine<TwitterCommentSearchQuery, CommentSearchResultEntry> {

	public SocialSearchResult search(TwitterCommentSearchQuery query) {
		SocialSearchResult result = new SocialSearchResult();

		try {
			result.setDays(query.getDays());
			this.barrier = new CyclicBarrier(result.getDays() + 1);
			// //////////////
			for (int i = 0; i < query.getDays(); i++) {
				SingleDaySearchThread t = new SingleDaySearchThread();
				t.setIndex(i);
				t.setQuery(query);
				t.setResult(result);
				(new Thread(t)).start();

			}
			// //////////////////
			this.barrier.await();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		//for (int j = 0; j < result.getDays(); j++)
		//	System.out.println("result of day[" + j + "] is "
		//			+ result.getTrend()[j]);
		return result;
	}

	public SocialSearchResult search(TwitterCommentSearchQuery query,
			int pageSize, int pageNumber) {
		query.setOption("rpp", String.valueOf(pageSize));
		query.setOption("page", String.valueOf(pageNumber));

		//System.out.println(query);

		SocialSearchResult result = this.search(query);
		result.setPageSize(pageSize);
		result.setPageNumber(pageNumber);
		return result;
	}

	private CyclicBarrier barrier;

	private class SingleDaySearchThread implements Runnable {

		@Override
		public void run() {
			TwitterSingleDaySearchEngine e = new TwitterSingleDaySearchEngine();
			TwitterSingleDaySearchQuery q = new TwitterSingleDaySearchQuery();
			Date date = new Date(new Date().getTime()-86400*1000*index);// =date.now-index
			q.setDate(date);
			q.setQueryInput(this.getQuery().getQueryInput());
			SingleDaySocialSearchResult r = e.search(q);
			this.getResult().getTrend()[this.getIndex()] = r.getTrend();
			try {
				barrier.await();
			} catch (InterruptedException ex) {
				return;
			} catch (BrokenBarrierException ex) {
				return;
			}

		}

		private int index = 0;

		public void setIndex(int index) {
			this.index = index;
		}

		public int getIndex() {
			return index;
		}

		private SocialSearchResult result = null;

		public void setResult(SocialSearchResult result) {
			this.result = result;
		}

		public SocialSearchResult getResult() {
			return result;
		}

		private SocialSearchQuery query;

		public void setQuery(SocialSearchQuery query) {
			this.query = query;
		}

		public SocialSearchQuery getQuery() {
			return query;
		}

	}
}
