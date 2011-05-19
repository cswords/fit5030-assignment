package fit5030.ass.two.searchclient.webservice;

import java.util.Random;

abstract class AjaxBase {

	private Random a;

	public RandomNumberResult searchRandom(RandomNumberQuery q) {
		a = new Random(q.getSeed());
		RandomNumberResult result = new RandomNumberResult();
		return result;
	}

	public static abstract class AjaxQueryResult {
		private String format;

		public void setFormat(String format) {
			this.format = format;
		}

		public String getFormat() {
			return format;
		}

		public abstract String getContent();
	}

	public static abstract class PagingAjaxQueryResult extends AjaxQueryResult {
		private int pageSize;

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getPageSize() {
			return pageSize;
		}

		private int pageNumber;

		public void setPageNumber(int pageNumber) {
			this.pageNumber = pageNumber;
		}

		public int getPageNumber() {
			return pageNumber;
		}
	}

	public static abstract class AjaxQuery {
		private String format;

		public void setFormat(String format) {
			this.format = format;
		}

		public String getFormat() {
			return format;
		}

		public abstract String getQueryName();

	}

	public static abstract class PagingAjaxQuery extends AjaxQuery {
		private int pageSize;

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getPageSize() {
			return pageSize;
		}

		private int pageNumber;

		public void setPageNumber(int pageNumber) {
			this.pageNumber = pageNumber;
		}

		public int getPageNumber() {
			return pageNumber;
		}
	}

	public class RandomNumberResult extends AjaxQueryResult {

		@Override
		public String getContent() {
			return String.valueOf(a.nextInt());
		}

	}

	public class RandomNumberQuery extends AjaxQuery {

		@Override
		public String getQueryName() {
			return "RandomNumber";
		}

		private long seed = System.currentTimeMillis();

		public void setSeed(long seed) {
			this.seed = seed;
		}

		public long getSeed() {
			return seed;
		}

	}
}
