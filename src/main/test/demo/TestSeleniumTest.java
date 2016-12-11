package demo;

import junit.framework.TestCase;
import org.junit.Test;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

/**
 * Created by sunjw on 2016/12/4 0004.
 */
public class TestSeleniumTest extends TestCase {

    @Test
    public void testPrintPrice(){
        Spider.create(new TestSelenium())
                .addPipeline(new ConsolePipeline())
                .addUrl("https://item.jd.com/2342601.html")
                .run();
    }


    @Test
    public void testSeleniumPrintPrice(){
        Spider.create(new TestSelenium())
                .addPipeline(new ConsolePipeline())
                .setDownloader(new SeleniumDownloader("E:\\opensource\\JetBrains\\source\\chromedriver_win32\\chrome.exe"))
                .addUrl("https://item.jd.com/2342601.html")
                .run();
    }

}