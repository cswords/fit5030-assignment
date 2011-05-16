package fit5030.ass.two.searchclient.comment;

import java.util.Date;

import fit5030.ass.one.searchclient.base.AbstractQuery;

public abstract class SocialSearchQuery extends AbstractQuery {

	protected abstract void setMinCommentDate(Date date);

	protected abstract void setMaxCommentDate(Date date);

	protected int days = 7;

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
		Date today = new Date();
		this.setMaxCommentDate(today);// setMax=today
		this.setMinCommentDate(new Date(today.getTime() - 86400 * 1000 * days));// setMin=today-days

	}

}
