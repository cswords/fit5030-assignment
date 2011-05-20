package fit5030.ass.two.searchclient.webservice;

import fit5030.ass.two.searchclient.webservice.Ajax.*;

public class SimpleAjax {
	private Ajax ajax=new Ajax();
	
	public String webSearch(WebSearchQuery query){
		return ajax.webSearch(query).getContent();
	}

	public String imageSearch(ImageSearchQuery query){
		return ajax.imageSearch(query).getContent();
	}

	public String videoSearch(VideoSearchQuery query){
		return ajax.videoSearch(query).getContent();
	}
	

	public String socialSearch(SocialSearchQuery query){
		return ajax.socialSearch(query).getContent();
	}
}
