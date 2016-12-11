package demo;

import junit.framework.TestCase;
import org.junit.Test;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;

/**
 * Created by sunjw on 2016/12/4 0004.
 */
public class OOTestTest extends TestCase {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void testOOSpider(){
        OOSpider.create(Site.me(), new ConsolePageModelPipeline(), PagePojo.class)
                .addUrl("http://www.meishichina.com/")
                .thread(2)
                .run();
    }

}