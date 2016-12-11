package demo;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by sunjw on 2016/11/28 0028.
 */
public class FirstSpider implements PageProcessor{

    Site site = Site.me().setRetryTimes(3).setSleepTime(5000);

    public void process(Page page) {
        //page.putField("title", page.getHtml().css("div[id=name]").toString());
        //page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
        //System.out.println("====" + page.getHtml().$("div[id=name] h1", "text"));
//        System.out.println("====" + page.getHtml().$("strong[id=jd-price]", "text"));
        System.out.println("====" + page.getHtml().$("strong[id=jd-price] + a", "text"));
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new FirstSpider())
                //从"https://github.com/code4craft"开始抓
                .addUrl("https://item.jd.com/2342601.html")
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
}
