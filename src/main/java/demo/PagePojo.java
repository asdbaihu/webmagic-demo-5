package demo;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * Created by sunjw on 2016/12/4 0004.
 * 测试使用webmagic的注解模式来爬取页面，但是失败了
 */
@TargetUrl("http://www.meishichina.com/.*")
public class PagePojo {

//    @ExtractBy(type = ExtractBy.Type.Css, value = "a[id=recipe_title] text()")
//    private String title;

    @ExtractBy("//a[@class=J_photo]//img/@src")
    private String img;


    public static void main(String[] args) {
        OOSpider.create(Site.me(), new ConsolePageModelPipeline(), PagePojo.class)
                .addUrl("http://www.meishichina.com/")
                .thread(2)
                .run();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
