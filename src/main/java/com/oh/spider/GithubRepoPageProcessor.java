/**  
 * @Title: GithubRepoPageProcessor.java
 * @Package com.oh.spider
 *
 */ 
package com.oh.spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @ClassName: GithubRepoPageProcessor
 * @Description: TODO
 * @author yi.he
 * @date Dec 16, 2016 10:59:06 AM
 *
 */
public class GithubRepoPageProcessor implements PageProcessor {

	/**
	 * 
	 */
	public GithubRepoPageProcessor() {
		// TODO Auto-generated constructor stub
	}

	 private Site site = Site.me().setRetryTimes(3).setSleepTime(5000);

	    @Override
	    public void process(Page page) {
	        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
	        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
	        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
	        if (page.getResultItems().get("name")==null){
	            //skip this page
	            page.setSkip(true);
	        }
	        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
	    }

	    @Override
	    public Site getSite() {
	        return site;
	    }

	    public static void main(String[] args) {
	        Spider.create(new GithubRepoPageProcessor()).addPipeline(new ConsolePipeline()).addUrl("https://github.com/code4craft").thread(5).run();
	    }

}