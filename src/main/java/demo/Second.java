package demo;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sunjw on 2016/12/3 0003.
 */
public class Second implements PageProcessor {

    AtomicInteger id = new AtomicInteger(0);

    //初始化Site
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    /**
     * 定义页面的处理逻辑，页面如何处理
     * @param page
     */
    @Override
    public void process(Page page) {

        page.addTargetRequests(page.getHtml().regex("http\\://home\\.meishichina\\.com/recipe-\\d+\\.html").all());

        //跳过首页
        if(!page.getUrl().toString().equals("http://www.meishichina.com/")){
            page.putField("image", page.getHtml().xpath("//a[@class=J_photo]//img/@src"));
//            page.putField("title", page.getHtml().css("a[id=recipe_title]", "text"));
            //page.putField("image", page.getHtml().css("a.J_photo img", "src"));

           /* String src = page.getHtml().css("a.J_photo img", "src").toString();
            System.out.println("img" + src);
            try {
                FileUtils.download( src, "download/" + id.incrementAndGet()+".jpg");
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new Second()).addUrl("http://www.meishichina.com/")
//                .addPipeline(new JsonFilePipeline("json"))
                .addPipeline(new ConsolePipeline())
//                .addPipeline(new FilePipeline("meishi"))
                .thread(1)
                .run();
    }
}
