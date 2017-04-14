/**  
 * @Title: BaiDuRepoPageProcessor.java
 * @Package com.oh.spider
 *
 */ 
package com.oh.spider;

import java.io.UnsupportedEncodingException;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

/**
 * @ClassName: BaiDuRepoPageProcessor
 * @Description: TODO
 * @author yi.he
 * @date Dec 16, 2016 2:44:54 PM
 *
 */
public class BaiDuRepoPageProcessor implements PageProcessor {

	 private Site site = Site.me().setCharset("UTF-8").setRetryTimes(3).setSleepTime(5000);

	/**
	 * 
	 */
	public BaiDuRepoPageProcessor() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see us.codecraft.webmagic.processor.PageProcessor#process(us.codecraft.webmagic.Page)
	 */
	@Override
	public void process(Page page) {
		Selectable selectable = page.getHtml().xpath("//div[@class='news-list']/div[@id='all-news']/div[@class='item']");
		int i = 0;
		for (Selectable st : selectable.nodes()) {
//			page.addTargetRequests(st.xpath("//div[@class='content']/ul/li/").links().regex("http://www.zhibo8\\.cc/zhibo/other/2016/*.htm").all());
			String tempTitle = st.xpath("//div[@class='main-info']/a[@class='title']/span/text()").toString();
			page.putField("title" + i, tempTitle);
			String temp = st.xpath("//div[@class='main-info']/div[@class='summary']/text()").toString();
			try {
				page.putField("summary" + i, new String(temp.getBytes(), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if(null == tempTitle){
				page.setSkip(true);
			}
			i++;
		}
	}

	/* (non-Javadoc)
	 * @see us.codecraft.webmagic.processor.PageProcessor#getSite()
	 */
	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

	 public static void main(String[] args) {
	        Spider.create(new BaiDuRepoPageProcessor())
	        	.addPipeline(new ConsolePipeline())
	        	.addPipeline(new JsonFilePipeline("E:\\webmagic"))
	        	.addUrl("https://www.oschina.net/news").thread(5).run();
	    }
}
