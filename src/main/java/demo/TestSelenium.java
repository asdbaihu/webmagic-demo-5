package demo;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

/**
 * Created by sunjw on 2016/12/4 0004.
 */
public class TestSelenium implements PageProcessor{

    private Site site = Site.me().setRetryTimes(1).setSleepTime(1000);

    @Override
    public void process(Page page) {
        System.out.println("page=" + page.getUrl());
        Selectable dt = page.getHtml().xpath("//div[@id=summary-price]/div[@class=dt]/text()");
        Selectable price = page.getHtml().xpath("//div[@id=summary-price]//strong[@id=jd-price]");
        System.out.println("dt=" + dt + ",price=" + price);
    }

    @Override
    public Site getSite() {
        return site;
    }


}
